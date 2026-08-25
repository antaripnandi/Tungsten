package com.hyperperformance.mixin.math;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityCollisionFastPathMixin {
    @Shadow public abstract AABB getBoundingBox();

    @Inject(method = "isColliding", at = @At("HEAD"), cancellable = true)
    private void fastCollisionCheck(BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (!HyperPerformanceConfig.INSTANCE.enableFastCollision) {
            return;
        }
        AABB box = this.getBoundingBox();
        if (box == null || box.getSize() <= 0.0) {
            cir.setReturnValue(false);
        }
    }
}
