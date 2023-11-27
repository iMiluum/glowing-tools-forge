package com.miluum.glowingtoolsforge;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.metadata.pack.PackMetadataSectionSerializer;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.resource.PathPackResources;

import java.io.IOException;

import static com.miluum.glowingtoolsforge.GlowingTools.MODID;


@Mod.EventBusSubscriber(modid=MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class AddPackFinderEvent {
    @SubscribeEvent
    public void addPackFinders(AddPackFindersEvent event)
    {
        if (event.getPackType() == PackType.CLIENT_RESOURCES)
        {
            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resources/legacy_glowing_tools");
            var pack = Pack.readMetaAndCreate("builtin/legacy_glowing_tools", Component.literal("Legacy Glowing Tools"), false,
                    (path) -> new PathPackResources(path, true, resourcePath), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
            event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
        }
    }
}
