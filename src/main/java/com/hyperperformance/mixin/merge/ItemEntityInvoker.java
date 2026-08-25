package com.hyperperformance.mixin.merge;

import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ItemEntity.class)
public interface ItemEntityInvoker {
    @Invoker("mergeWithNeighbours")
    void invokeMergeWithNeighbours();
}
