package com.disk.opus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.disk.opus.block.ModBlocks;
import com.disk.opus.item.ModItems;

import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Opus.MOD_ID)
public class Opus
{
    public static final String MOD_ID = "opus";

    private static final Logger LOGGER = LogManager.getLogger();

    public Opus()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some pre-init code
        LOGGER.info("HELLO FROM PRE-INIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
