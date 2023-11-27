package com.miluum.glowingtoolsforge;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import static com.miluum.glowingtoolsforge.GlowingTools.*;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GlowingItemTransformer {
    public static ItemStack getVanillaTool(ItemStack stack){
        Item item = stack.getItem();
        if(item instanceof GlowingAxeItem) return getVanillaAxeStack((AxeItem) item);
        else if(item instanceof GlowingHoeItem) return getVanillaHoeStack((HoeItem) item);
        else if(item instanceof GlowingPickaxeItem) return getVanillaPickaxeStack((PickaxeItem) item);
        else if(item instanceof GlowingShovelItem) return getVanillaShovelStack((ShovelItem) item);
        else if(item instanceof GlowingSwordItem) return getVanillaSwordStack((SwordItem) item);
        else return new ItemStack(Items.AIR);
    }

    public static ItemStack getGlowingTool(ItemStack stack){
        Item item = stack.getItem();
        if(item instanceof AxeItem) return getGlowingAxeStack((AxeItem) item);
        else if(item instanceof HoeItem) return getGlowingHoeStack((HoeItem) item);
        else if(item instanceof PickaxeItem) return getGlowingPickaxeStack((PickaxeItem) item);
        else if(item instanceof ShovelItem) return getGlowingShovelStack((ShovelItem) item);
        else if(item instanceof SwordItem) return getGlowingSwordStack((SwordItem) item);
        else return new ItemStack(Items.AIR);
    }

    public static ItemStack getVanillaAxeStack(AxeItem axe){
        AxeItem vanillaTool;
        Tier material = axe.getTier();
        if (material.equals(Tiers.WOOD))
            vanillaTool = (AxeItem) Items.WOODEN_AXE;
        else if (material.equals(Tiers.STONE))
            vanillaTool = (AxeItem) Items.STONE_AXE;
        else if (material.equals(Tiers.IRON))
            vanillaTool = (AxeItem) Items.IRON_AXE;
        else if (material.equals(Tiers.GOLD))
            vanillaTool = (AxeItem) Items.GOLDEN_AXE;
        else if (material.equals(Tiers.DIAMOND))
            vanillaTool = (AxeItem) Items.DIAMOND_AXE;
        else if (material.equals(Tiers.NETHERITE))
            vanillaTool = (AxeItem) Items.NETHERITE_AXE;
        else
            vanillaTool = (AxeItem) Items.WOODEN_AXE;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getVanillaHoeStack(HoeItem hoe){
        HoeItem vanillaTool;
        Tier material = hoe.getTier();
        if (material.equals(Tiers.WOOD))
            vanillaTool = (HoeItem) Items.WOODEN_HOE;
        else if (material.equals(Tiers.STONE))
            vanillaTool = (HoeItem) Items.STONE_HOE;
        else if (material.equals(Tiers.IRON))
            vanillaTool = (HoeItem) Items.IRON_HOE;
        else if (material.equals(Tiers.GOLD))
            vanillaTool = (HoeItem) Items.GOLDEN_HOE;
        else if (material.equals(Tiers.DIAMOND))
            vanillaTool = (HoeItem) Items.DIAMOND_HOE;
        else if (material.equals(Tiers.NETHERITE))
            vanillaTool = (HoeItem) Items.NETHERITE_HOE;
        else
            vanillaTool = (HoeItem) Items.WOODEN_HOE;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getVanillaPickaxeStack(PickaxeItem pickaxe){
        PickaxeItem vanillaTool;
        Tier material = pickaxe.getTier();
        if (material.equals(Tiers.WOOD))
            vanillaTool = (PickaxeItem) Items.WOODEN_PICKAXE;
        else if (material.equals(Tiers.STONE))
            vanillaTool = (PickaxeItem) Items.STONE_PICKAXE;
        else if (material.equals(Tiers.IRON))
            vanillaTool = (PickaxeItem) Items.IRON_PICKAXE;
        else if (material.equals(Tiers.GOLD))
            vanillaTool = (PickaxeItem) Items.GOLDEN_PICKAXE;
        else if (material.equals(Tiers.DIAMOND))
            vanillaTool = (PickaxeItem) Items.DIAMOND_PICKAXE;
        else if (material.equals(Tiers.NETHERITE))
            vanillaTool = (PickaxeItem) Items.NETHERITE_PICKAXE;
        else
            vanillaTool = (PickaxeItem) Items.WOODEN_PICKAXE;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getVanillaShovelStack(ShovelItem shovel){
        ShovelItem vanillaTool;
        Tier material = shovel.getTier();
        if (material.equals(Tiers.WOOD))
            vanillaTool = (ShovelItem) Items.WOODEN_SHOVEL;
        else if (material.equals(Tiers.STONE))
            vanillaTool = (ShovelItem) Items.STONE_SHOVEL;
        else if (material.equals(Tiers.IRON))
            vanillaTool = (ShovelItem) Items.IRON_SHOVEL;
        else if (material.equals(Tiers.GOLD))
            vanillaTool = (ShovelItem) Items.GOLDEN_SHOVEL;
        else if (material.equals(Tiers.DIAMOND))
            vanillaTool = (ShovelItem) Items.DIAMOND_SHOVEL;
        else if (material.equals(Tiers.NETHERITE))
            vanillaTool = (ShovelItem) Items.NETHERITE_SHOVEL;
        else
            vanillaTool = (ShovelItem) Items.WOODEN_SHOVEL;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getVanillaSwordStack(SwordItem sword){
        SwordItem vanillaTool;
        Tier material = sword.getTier();
        if (material.equals(Tiers.WOOD))
            vanillaTool = (SwordItem) Items.WOODEN_SWORD;
        else if (material.equals(Tiers.STONE))
            vanillaTool = (SwordItem) Items.STONE_SWORD;
        else if (material.equals(Tiers.IRON))
            vanillaTool = (SwordItem) Items.IRON_SWORD;
        else if (material.equals(Tiers.GOLD))
            vanillaTool = (SwordItem) Items.GOLDEN_SWORD;
        else if (material.equals(Tiers.DIAMOND))
            vanillaTool = (SwordItem) Items.DIAMOND_SWORD;
        else if (material.equals(Tiers.NETHERITE))
            vanillaTool = (SwordItem) Items.NETHERITE_SWORD;
        else
            vanillaTool = (SwordItem) Items.WOODEN_SWORD;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getGlowingAxeStack(AxeItem axe){
        GlowingAxeItem glowingTool;
        Tier material = axe.getTier();
        if (material.equals(Tiers.WOOD))
            glowingTool = (GlowingAxeItem) getItemFromRegistry("glowing_wooden_axe");
        else if (material.equals(Tiers.STONE))
            glowingTool = (GlowingAxeItem) getItemFromRegistry("glowing_stone_axe");
        else if (material.equals(Tiers.IRON))
            glowingTool = (GlowingAxeItem) getItemFromRegistry("glowing_iron_axe");
        else if (material.equals(Tiers.GOLD))
            glowingTool = (GlowingAxeItem) getItemFromRegistry("glowing_golden_axe");
        else if (material.equals(Tiers.DIAMOND))
            glowingTool = (GlowingAxeItem) getItemFromRegistry("glowing_diamond_axe");
        else if (material.equals(Tiers.NETHERITE))
            glowingTool = (GlowingAxeItem) getItemFromRegistry("glowing_netherite_axe");
        else
            glowingTool = (GlowingAxeItem) getItemFromRegistry("glowing_wooden_axe");

        return new ItemStack(glowingTool);
    }

    public static ItemStack getGlowingHoeStack(HoeItem hoe){
        GlowingHoeItem glowingTool;
        Tier material = hoe.getTier();
        if (material.equals(Tiers.WOOD))
            glowingTool = (GlowingHoeItem) getItemFromRegistry("glowing_wooden_hoe");
        else if (material.equals(Tiers.STONE))
            glowingTool = (GlowingHoeItem) getItemFromRegistry("glowing_stone_hoe");
        else if (material.equals(Tiers.IRON))
            glowingTool = (GlowingHoeItem) getItemFromRegistry("glowing_iron_hoe");
        else if (material.equals(Tiers.GOLD))
            glowingTool = (GlowingHoeItem) getItemFromRegistry("glowing_golden_hoe");
        else if (material.equals(Tiers.DIAMOND))
            glowingTool = (GlowingHoeItem) getItemFromRegistry("glowing_diamond_hoe");
        else if (material.equals(Tiers.NETHERITE))
            glowingTool = (GlowingHoeItem) getItemFromRegistry("glowing_netherite_hoe");
        else
            glowingTool = (GlowingHoeItem) getItemFromRegistry("glowing_wooden_hoe");

        return new ItemStack(glowingTool);
    }

public static ItemStack getGlowingPickaxeStack(PickaxeItem pickaxe){
        GlowingPickaxeItem glowingTool;
        Tier material = pickaxe.getTier();
        if (material.equals(Tiers.WOOD))
            glowingTool = (GlowingPickaxeItem) getItemFromRegistry("glowing_wooden_pickaxe");
        else if (material.equals(Tiers.STONE))
            glowingTool = (GlowingPickaxeItem) getItemFromRegistry("glowing_stone_pickaxe");
        else if (material.equals(Tiers.IRON))
            glowingTool = (GlowingPickaxeItem) getItemFromRegistry("glowing_iron_pickaxe");
        else if (material.equals(Tiers.GOLD))
            glowingTool = (GlowingPickaxeItem) getItemFromRegistry("glowing_golden_pickaxe");
        else if (material.equals(Tiers.DIAMOND))
            glowingTool = (GlowingPickaxeItem) getItemFromRegistry("glowing_diamond_pickaxe");
        else if (material.equals(Tiers.NETHERITE))
            glowingTool = (GlowingPickaxeItem) getItemFromRegistry("glowing_netherite_pickaxe");
        else
            glowingTool = (GlowingPickaxeItem) getItemFromRegistry("glowing_wooden_pickaxe");

        return new ItemStack(glowingTool);
    }

public static ItemStack getGlowingShovelStack(ShovelItem shovel){
        GlowingShovelItem glowingTool;
        Tier material = shovel.getTier();
        if (material.equals(Tiers.WOOD))
            glowingTool = (GlowingShovelItem) getItemFromRegistry("glowing_wooden_shovel");
        else if (material.equals(Tiers.STONE))
            glowingTool = (GlowingShovelItem) getItemFromRegistry("glowing_stone_shovel");
        else if (material.equals(Tiers.IRON))
            glowingTool = (GlowingShovelItem) getItemFromRegistry("glowing_iron_shovel");
        else if (material.equals(Tiers.GOLD))
            glowingTool = (GlowingShovelItem) getItemFromRegistry("glowing_golden_shovel");
        else if (material.equals(Tiers.DIAMOND))
            glowingTool = (GlowingShovelItem) getItemFromRegistry("glowing_diamond_shovel");
        else if (material.equals(Tiers.NETHERITE))
            glowingTool = (GlowingShovelItem) getItemFromRegistry("glowing_netherite_shovel");
        else
            glowingTool = (GlowingShovelItem) getItemFromRegistry("glowing_wooden_shovel");

        return new ItemStack(glowingTool);
    }

    public static ItemStack getGlowingSwordStack(SwordItem sword){
        GlowingSwordItem glowingTool;
        Tier material = sword.getTier();
        if (material.equals(Tiers.WOOD))
            glowingTool = (GlowingSwordItem) getItemFromRegistry("glowing_wooden_sword");
        else if (material.equals(Tiers.STONE))
            glowingTool = (GlowingSwordItem) getItemFromRegistry("glowing_stone_sword");
        else if (material.equals(Tiers.IRON))
            glowingTool = (GlowingSwordItem) getItemFromRegistry("glowing_iron_sword");
        else if (material.equals(Tiers.GOLD))
            glowingTool = (GlowingSwordItem) getItemFromRegistry("glowing_golden_sword");
        else if (material.equals(Tiers.DIAMOND))
            glowingTool = (GlowingSwordItem) getItemFromRegistry("glowing_diamond_sword");
        else if (material.equals(Tiers.NETHERITE))
            glowingTool = (GlowingSwordItem) getItemFromRegistry("glowing_netherite_sword");
        else
            glowingTool = (GlowingSwordItem) getItemFromRegistry("glowing_wooden_sword");

        return new ItemStack(glowingTool);
    }

    public static Item getItemFromRegistry(String path){
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID, path));
    }

    public static boolean placeTorch(Level world, BlockPos pos, Direction side, Player miner){
        if(!(world.getBlockState(pos).isSolidRender(world, pos))) return false;
        BlockState torchState;
        if (side == Direction.UP) torchState = Blocks.TORCH.defaultBlockState();
        else if (side == Direction.DOWN) return false;
        else torchState = Blocks.WALL_TORCH.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, side);
        BlockPos torchPos = pos.relative(side);
        if (!(world.getBlockState(torchPos).isAir()))  return false;
        world.setBlock(torchPos, torchState, 3);
        world.playSound(null, torchPos, world.getBlockState(torchPos).getSoundType(world, pos, null).getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
        ItemStack torchStack = new ItemStack(Items.TORCH);
        if (miner.getInventory().contains(torchStack)) {
            miner.getInventory().removeItem(miner.getInventory().findSlotMatchingItem(torchStack), 1);
            return false;
        }
        return true;
    }

    public static InteractionResult pickUpTorch(Player player, Level world, InteractionHand hand, BlockHitResult hitResult){
        ItemStack stack = player.getItemInHand(hand);
        if (!player.isCrouching()) return InteractionResult.PASS;
        if (!(stack.getItem() instanceof TieredItem)) return InteractionResult.PASS;

        BlockPos pos = hitResult.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (!(state.getBlock() == Blocks.TORCH || state.getBlock() == Blocks.WALL_TORCH)) return InteractionResult.PASS;

        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        world.playSound(null, pos, state.getSoundType(world, pos, null).getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);

        if (stack.getItem() instanceof GlowingItem) {
            player.getInventory().add(new ItemStack(Blocks.TORCH));
            return InteractionResult.SUCCESS;
        }
        else {
            GlowingItemTransformer.transformVanillaTool(stack, player);
        }
        return InteractionResult.SUCCESS;
    }

    public static void copyData(ItemStack stack, ItemStack vanillaToolStack) {
        vanillaToolStack.setDamageValue(stack.getDamageValue());
        EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(stack), vanillaToolStack);
    }

    public static void turnToVanillaTool(ItemStack stack, Player miner) {
        try {
            ItemStack vanillaToolStack = GlowingItemTransformer.getVanillaTool(stack);
            copyData(stack, vanillaToolStack);
            stack.shrink(1);
            miner.setItemSlot(EquipmentSlot.MAINHAND, vanillaToolStack);
        }
        catch (Exception e) {
            LOGGER.error("E: " + e);
        }
    }

    public static void turnToGlowingTool(ItemStack stack, Player miner) {
        try {
            ItemStack glowingToolStack = GlowingItemTransformer.getGlowingTool(stack);
            copyData(stack, glowingToolStack);
            stack.shrink(1);
            miner.setItemSlot(EquipmentSlot.MAINHAND, glowingToolStack);
        }
        catch (Exception e) {
            LOGGER.error("E: " + e);
        }
    }

    public static void transformGlowingTool(ItemStack stack, Level world, BlockPos pos, Player miner, Direction side){
        if(GlowingItemTransformer.placeTorch(world, pos, side, miner)) GlowingItemTransformer.turnToVanillaTool(stack, miner);
    }

    public static void transformVanillaTool(ItemStack stack, Player miner){
        GlowingItemTransformer.turnToGlowingTool(stack, miner);
    }


    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
        InteractionResult result = pickUpTorch(
                event.getEntity(),
                event.getLevel(),
                event.getHand(),
                event.getHitVec()
        );
    }
}