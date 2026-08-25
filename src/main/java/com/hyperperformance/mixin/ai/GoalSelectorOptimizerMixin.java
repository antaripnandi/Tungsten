package com.hyperperformance.mixin.ai;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(GoalSelector.class)
public abstract class GoalSelectorOptimizerMixin {
    @Shadow @Final private Set<WrappedGoal> availableGoals;
    @Unique private int tungsten$tickCount = 0;

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void optimizeGoalTick(CallbackInfo ci) {
        if (!HyperPerformanceConfig.INSTANCE.enableAiThrottling) {
            return;
        }
        tungsten$tickCount++;
        // If the mob has any active running goals (attacking, fleeing, navigating), do not throttle
        for (WrappedGoal goal : this.availableGoals) {
            if (goal.isRunning()) {
                return;
            }
        }
        // Throttle dormant goal sweeps every other tick to save CPU
        if ((tungsten$tickCount & 1) != 0) {
            ci.cancel();
        }
    }
}
