package com.disk.opus.block;

import com.disk.opus.Opus;
import com.disk.opus.item.ModCreativeModeTab;
import com.disk.opus.item.ModItems;
import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("null")
public final class ModBlocks
{
    private ModBlocks()
    {
        throw new UnsupportedOperationException();
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Opus.MOD_ID);

    //#region Blocks

    public static final RegistryObject<Block> SILICA_BLOCK = registerBlock("silica_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.SAND)), ModCreativeModeTab.OPUS_TAB);

    //#endregion

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block, final CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(tab)));
        return toReturn;
    }

    public static void register(final IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
