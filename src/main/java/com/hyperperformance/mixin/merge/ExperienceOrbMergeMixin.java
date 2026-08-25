package com.hyperperformance.mixin.merge;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.world.entity.ExperienceOrb;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceOrb.class)
public abstract class ExperienceOrbMergeMixin {
    @Shadow private int age;

    @Inject(method = "tick", at = @At("HEAD"))
    private void accelerateOrbMerge(CallbackInfo ci) {
        if (!HyperPerformanceConfig.INSTANCE.enableItemMerging) {
            return;
        }
//? if >=1.21.1 {
        // Accelerate XP orb merging by triggering it every 10 ticks.
        // No need to check isClientSide() - vanilla's scanForMerges() handles this internally.
        if (this.age > 0 && this.age % 10 == 0) {
            ((ExperienceOrbInvoker) this).invokeScanForMerges();
        }
//?}
    }
}
