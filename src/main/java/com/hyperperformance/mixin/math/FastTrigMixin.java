package com.hyperperformance.mixin.math;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mth.class)
public abstract class FastTrigMixin {
    @Unique
    private static final float[] SIN_TABLE = new float[65536];

    static {
        for (int i = 0; i < 65536; ++i) {
            SIN_TABLE[i] = (float) Math.sin((double) i * Math.PI * 2.0 / 65536.0);
        }
    }

//? if <1.21.1 {
/*  @Inject(method = "sin(F)F", at = @At("HEAD"), cancellable = true)
    private static void fastSin(float value, CallbackInfoReturnable<Float> cir) {
        if (HyperPerformanceConfig.INSTANCE.enableFastMath) {
            cir.setReturnValue(SIN_TABLE[(int) (value * 10430.378350470453f) & 65535]);
        }
    }

    @Inject(method = "cos(F)F", at = @At("HEAD"), cancellable = true)
    private static void fastCos(float value, CallbackInfoReturnable<Float> cir) {
        if (HyperPerformanceConfig.INSTANCE.enableFastMath) {
            cir.setReturnValue(SIN_TABLE[(int) (value * 10430.378350470453f + 16384.0f) & 65535]);
        }
    }
*///?} else {
    @Inject(method = "sin(D)F", at = @At("HEAD"), cancellable = true)
    private static void fastSin(double value, CallbackInfoReturnable<Float> cir) {
        if (HyperPerformanceConfig.INSTANCE.enableFastMath) {
            cir.setReturnValue(SIN_TABLE[(int) (value * 10430.378350470453) & 65535]);
        }
    }

    @Inject(method = "cos(D)F", at = @At("HEAD"), cancellable = true)
    private static void fastCos(double value, CallbackInfoReturnable<Float> cir) {
        if (HyperPerformanceConfig.INSTANCE.enableFastMath) {
            cir.setReturnValue(SIN_TABLE[(int) (value * 10430.378350470453 + 16384.0) & 65535]);
        }
    }
//?}
}
