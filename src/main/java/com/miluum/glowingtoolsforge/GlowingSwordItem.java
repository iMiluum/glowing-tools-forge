package com.miluum.glowingtoolsforge;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GlowingSwordItem extends SwordItem implements GlowingItem {

    public GlowingSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
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

    public boolean isGlowing(ItemStack stack) {
        return stack.getItem() instanceof GlowingItem;
    }
}
