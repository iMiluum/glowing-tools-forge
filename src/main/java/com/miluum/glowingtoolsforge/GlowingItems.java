package com.miluum.glowingtoolsforge;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.miluum.glowingtoolsforge.GlowingTools.ITEMS;

public class GlowingItems {
    public static final List<Item> itemList = new ArrayList<>();
    public static final Set<RegistryObject<Item>> registeredItems = new HashSet<>();


    public static Item createPickaxeItem(Tier material){
        Item createdItem = new GlowingPickaxeItem(
                material,
                1,
                -2.8f,
                new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
        );
        itemList.add(createdItem);
        return createdItem;
    }

    public static Item createAxeItem(Tier material){
        return createAxeItem(material, 6, -3.2f);
    }

    public static Item createAxeItem(Tier material, int attackDamage){
        return createAxeItem(material, attackDamage, -3.2f);
    }

    public static Item createAxeItem(Tier material, float attackSpeed){
        return createAxeItem(material, 6, attackSpeed);
    }

    public static Item createAxeItem(Tier material, int attackDamage, float attackSpeed){
        Item createdItem = new GlowingAxeItem(
                material,
                attackDamage,
                attackSpeed,
                new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
        );
        itemList.add(createdItem);
        return createdItem;
    }

    public static Item createShovelItem(Tier material){
        Item createdItem = new GlowingShovelItem(
                material,
                1.5f,
                -3.0f,
                new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
        );
        itemList.add(createdItem);
        return createdItem;
    }

    public static Item createSwordItem(Tier material){
        Item createdItem = new GlowingSwordItem(
                material,
                3,
                -2.4f,
                new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
        );
        itemList.add(createdItem);
        return createdItem;
    }

    public static Item createHoeItem(Tier material, int attackDamage, float attackSpeed){
        HoeItem createdItem = new GlowingHoeItem(
                material,
                attackDamage,
                attackSpeed,
                new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)

        );
        itemList.add(createdItem);
        return createdItem;
    }

    public static Set<RegistryObject<Item>> registerItems(){
        registeredItems.add(ITEMS.register("glowing_netherite_pickaxe", () -> createPickaxeItem(Tiers.NETHERITE)));
        registeredItems.add(ITEMS.register("glowing_diamond_pickaxe", () -> createPickaxeItem(Tiers.DIAMOND)));
        registeredItems.add(ITEMS.register("glowing_golden_pickaxe", () -> createPickaxeItem(Tiers.GOLD)));
        registeredItems.add(ITEMS.register("glowing_iron_pickaxe", () -> createPickaxeItem(Tiers.IRON)));
        registeredItems.add(ITEMS.register("glowing_stone_pickaxe", () -> createPickaxeItem(Tiers.STONE)));
        registeredItems.add(ITEMS.register("glowing_wooden_pickaxe", () -> createPickaxeItem(Tiers.WOOD)));

        registeredItems.add(ITEMS.register("glowing_netherite_axe", () -> createAxeItem(Tiers.NETHERITE, 5, -3.0f)));
        registeredItems.add(ITEMS.register("glowing_diamond_axe", () -> createAxeItem(Tiers.DIAMOND, 5, -3.0f)));
        registeredItems.add(ITEMS.register("glowing_golden_axe", () -> createAxeItem(Tiers.GOLD, -3.0f)));
        registeredItems.add(ITEMS.register("glowing_iron_axe", () -> createAxeItem(Tiers.IRON, -3.1f)));
        registeredItems.add(ITEMS.register("glowing_stone_axe", () -> createAxeItem(Tiers.STONE, 7)));
        registeredItems.add(ITEMS.register("glowing_wooden_axe", () -> createAxeItem(Tiers.WOOD)));

        registeredItems.add(ITEMS.register("glowing_netherite_shovel", () -> createShovelItem(Tiers.NETHERITE)));
        registeredItems.add(ITEMS.register("glowing_diamond_shovel", () -> createShovelItem(Tiers.DIAMOND)));
        registeredItems.add(ITEMS.register("glowing_golden_shovel", () -> createShovelItem(Tiers.GOLD)));
        registeredItems.add(ITEMS.register("glowing_iron_shovel", () -> createShovelItem(Tiers.IRON)));
        registeredItems.add(ITEMS.register("glowing_stone_shovel", () -> createShovelItem(Tiers.STONE)));
        registeredItems.add(ITEMS.register("glowing_wooden_shovel", () -> createShovelItem(Tiers.WOOD)));

        registeredItems.add(ITEMS.register("glowing_netherite_sword", () -> createSwordItem(Tiers.NETHERITE)));
        registeredItems.add(ITEMS.register("glowing_diamond_sword", () -> createSwordItem(Tiers.DIAMOND)));
        registeredItems.add(ITEMS.register("glowing_golden_sword", () -> createSwordItem(Tiers.GOLD)));
        registeredItems.add(ITEMS.register("glowing_iron_sword", () -> createSwordItem(Tiers.IRON)));
        registeredItems.add(ITEMS.register("glowing_stone_sword", () -> createSwordItem(Tiers.STONE)));
        registeredItems.add(ITEMS.register("glowing_wooden_sword", () -> createSwordItem(Tiers.WOOD)));

        registeredItems.add(ITEMS.register("glowing_netherite_hoe", () -> createHoeItem(Tiers.NETHERITE, -4, 0f)));
        registeredItems.add(ITEMS.register("glowing_diamond_hoe", () -> createHoeItem(Tiers.DIAMOND, -3, 0f)));
        registeredItems.add(ITEMS.register("glowing_golden_hoe", () -> createHoeItem(Tiers.GOLD, 0, -3.0f)));
        registeredItems.add(ITEMS.register("glowing_iron_hoe", () -> createHoeItem(Tiers.IRON, -2, -1.0f)));
        registeredItems.add(ITEMS.register("glowing_stone_hoe", () -> createHoeItem(Tiers.STONE, -1, -2.0f)));
        registeredItems.add(ITEMS.register("glowing_wooden_hoe", () -> createHoeItem(Tiers.WOOD, 0, -3.0f)));

        return registeredItems;
    }
}
