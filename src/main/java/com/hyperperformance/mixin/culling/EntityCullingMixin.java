package com.hyperperformance.mixin.culling;

import com.hyperperformance.config.HyperPerformanceConfig;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityCullingMixin {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private <E extends Entity> void shouldCullEntity(
            E entity,
            Frustum frustum,
            double x,
            double y,
            double z,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (!HyperPerformanceConfig.INSTANCE.enableEntityCulling) {
            return;
        }
        if (entity.isInvisible() && !entity.isCurrentlyGlowing()) {
            cir.setReturnValue(false);
        }
    }
}
