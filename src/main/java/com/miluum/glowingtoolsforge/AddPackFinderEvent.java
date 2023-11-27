package com.miluum.glowingtoolsforge;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
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
    public static void addPackFinders(AddPackFindersEvent event)
    {
        try
        {
            if (event.getPackType() == PackType.CLIENT_RESOURCES)
            {
                var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resourcepacks/legacy_glowing_tools");
                var pack = new PathPackResources(ModList.get().getModFileById(MODID).getFile().getFileName() + ":" + resourcePath, resourcePath);
                var metadataSection = pack.getMetadataSection(PackMetadataSection.SERIALIZER);
                if (metadataSection != null)
                {
                    event.addRepositorySource((packConsumer, packConstructor) ->
                            packConsumer.accept(packConstructor.create(
                                    "builtin/legacy_glowing_tools", Component.literal("Legacy Glowing Tools"), false,
                                    () -> pack, metadataSection, Pack.Position.TOP, PackSource.BUILT_IN, false)));
                }
            }
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
