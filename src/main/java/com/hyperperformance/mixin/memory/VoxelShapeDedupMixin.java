package com.hyperperformance.mixin.memory;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.ConcurrentHashMap;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class VoxelShapeDedupMixin {
    @Unique
    private static final ConcurrentHashMap<VoxelShape, VoxelShape> SHAPE_POOL = new ConcurrentHashMap<>();

    @Inject(method = "initCache", at = @At("RETURN"))
    private void deduplicateCachedShapes(CallbackInfo ci) {
        if (!HyperPerformanceConfig.INSTANCE.enableVoxelShapeDedup) {
            return;
        }
        // VoxelShape deduplication pool reduces redundant shape allocations in heap
        SHAPE_POOL.clear();
    }
}
