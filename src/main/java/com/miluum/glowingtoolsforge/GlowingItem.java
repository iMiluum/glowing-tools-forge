package com.miluum.glowingtoolsforge;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public interface GlowingItem {
    boolean isGlowing(ItemStack stack);
    InteractionResult useOn(UseOnContext context);
}
