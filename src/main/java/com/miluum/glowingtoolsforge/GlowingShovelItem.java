package com.miluum.glowingtoolsforge;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class GlowingShovelItem extends ShovelItem implements GlowingItem {
    public GlowingShovelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        ItemStack stack = context.getItemInHand();
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player miner = context.getPlayer();
        Direction side = context.getClickedFace();

        assert miner != null;
        if (miner.isCrouching()) GlowingItemTransformer.transformGlowingTool(stack, world, pos, miner, side);
        else super.useOn(context);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("item.glowing_tools.default.tooltip.description").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("item.glowing_tools.default.tooltip.instruction1").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("item.glowing_tools.default.tooltip.instruction2").withStyle(ChatFormatting.GRAY));
    }

    public boolean isGlowing(ItemStack stack) {
        return stack.getItem() instanceof GlowingItem;
    }
}
