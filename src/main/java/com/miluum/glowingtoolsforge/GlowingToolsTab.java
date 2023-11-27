package com.miluum.glowingtoolsforge;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GlowingToolsTab extends CreativeModeTab {

    public GlowingToolsTab() {
        super("glowing_tools.tools");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(GlowingItemTransformer.getItemFromRegistry("glowing_netherite_pickaxe"));
    }
}

