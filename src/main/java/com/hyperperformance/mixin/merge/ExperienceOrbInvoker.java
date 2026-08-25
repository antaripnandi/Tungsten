package com.hyperperformance.mixin.merge;

import net.minecraft.world.entity.ExperienceOrb;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ExperienceOrb.class)
public interface ExperienceOrbInvoker {
//? if >=1.21.1 {
    @Invoker("scanForMerges")
    void invokeScanForMerges();
//?}
}
