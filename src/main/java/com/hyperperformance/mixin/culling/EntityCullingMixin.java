package com.hyperperformance.mixin.culling;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityCullingMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private <E extends Entity> void shouldCullEntity(
            E entity,
            double x,
            double y,
            double z,
            float yaw,
            float partialTicks,
            Object poseStack,
            Object bufferSource,
            int packedLight,
            CallbackInfo ci
    ) {
        if (!HyperPerformanceConfig.INSTANCE.enableEntityCulling) {
            return;
        }
        if (entity.isInvisible() && !entity.isCurrentlyGlowing()) {
            ci.cancel();
        }
    }
}
