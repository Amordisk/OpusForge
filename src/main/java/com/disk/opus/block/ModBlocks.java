package com.disk.opus.block;

import com.disk.opus.Opus;
import com.disk.opus.item.ModItems;
import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
            DeferredRegister.create(ForgeRegistries.BLOCKS, Opus.MOD_ID);


    //Add blocks here
    public static final RegistryObject<Block> SILICA_BLOCK = registerBlock("silica_block",
         () -> new Block(BlockBehaviour.Properties.of(Material.SAND)), CreativeModeTab.TAB_MISC);

    
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) 
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }


    //Registers item associated with a block
    @SuppressWarnings("null")
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) 
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                 new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) 
    {
        BLOCKS.register(eventBus);
    }
}
