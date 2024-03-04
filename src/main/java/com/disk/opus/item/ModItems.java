package com.disk.opus.item;

import com.disk.opus.Opus;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, Opus.MOD_ID);


    // Items  ------------------------------------------------------------------------------------------------------------------
    @SuppressWarnings("null")
    public static final RegistryObject<Item> TEST_TUBE = ITEMS.register("test_tube",
     () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    //  ------------------------------------------------------------------------------------------------------------------------
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
