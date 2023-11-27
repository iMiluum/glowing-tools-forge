package com.miluum.glowingtoolsforge;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(GlowingTools.MODID)
public class GlowingTools {
    public static final String MODID = "glowing_tools_forge";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> REGISTRAR = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> GLOWING_TOOLS_TAB = REGISTRAR.register("tools", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.glowing_tools.tools"))
        .icon(() -> new ItemStack(GlowingItemTransformer.getItemFromRegistry("glowing_netherite_pickaxe")))
        .displayItems((params, output) -> {
            for (Item item : GlowingItems.itemList) output.accept(item);
        })
        .build()
    );


    public GlowingTools() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(AddPackFinderEvent::addPackFinders);
        GlowingItems.registerItems();
        REGISTRAR.register(modEventBus);
        ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(GlowingItemTransformer.class);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Glowing Tools initializing!");
    }
}
