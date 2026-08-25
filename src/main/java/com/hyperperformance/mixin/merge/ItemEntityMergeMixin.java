package com.hyperperformance.mixin.merge;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMergeMixin {
    @Shadow private int age;

    @Inject(method = "tick", at = @At("HEAD"))
    private void accelerateItemMerge(CallbackInfo ci) {
        if (!HyperPerformanceConfig.INSTANCE.enableItemMerging) {
            return;
        }
        // Accelerate item merging by triggering it every 10 ticks instead of every tick.
        // No need to check isClientSide() - vanilla's mergeWithNeighbours() handles this internally.
        if (this.age > 0 && this.age % 10 == 0) {
            ((ItemEntityInvoker) this).invokeMergeWithNeighbours();
        }
    }
}
