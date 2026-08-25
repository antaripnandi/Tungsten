package com.hyperperformance.mixin.ai;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GoalSelector.class)
public abstract class GoalSelectorOptimizerMixin {
    @Unique
    private int tungsten$tickCount = 0;

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void optimizeGoalTick(CallbackInfo ci) {
        if (!HyperPerformanceConfig.INSTANCE.enableAiThrottling) {
            return;
        }
        tungsten$tickCount++;
        // Throttle full goal selector sweeps every other tick to save CPU
        if ((tungsten$tickCount & 1) != 0) {
            ci.cancel();
        }
    }
}
