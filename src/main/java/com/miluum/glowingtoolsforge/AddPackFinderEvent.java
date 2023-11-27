package com.miluum.glowingtoolsforge;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import static com.miluum.glowingtoolsforge.GlowingTools.MODID;


@Mod.EventBusSubscriber(modid=MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class AddPackFinderEvent {


    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event)
    {
        if (event.getPackType() == PackType.CLIENT_RESOURCES)
        {
            try {
                PathPackResources.PathResourcesSupplier supplier;
                var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resourcepacks/legacy_glowing_tools");
                supplier = new PathPackResources.PathResourcesSupplier(resourcePath, true);

                var pack = Pack.readMetaAndCreate("builtin/glowing_tools_forge", Component.literal("Legacy Glowing Tools"), false, supplier, PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
                event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
