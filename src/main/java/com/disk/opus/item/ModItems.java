package com.disk.opus.item;

import com.disk.opus.Opus;
import com.disk.opus.item.glassware.ErlenmeyerFlask;
import com.disk.opus.item.glassware.RoundBottomFlask;
import com.disk.opus.item.glassware.TestTube;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("null")
public final class ModItems
{
    private ModItems()
    {
        throw new UnsupportedOperationException();
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Opus.MOD_ID);

    // #region Items

    public static final RegistryObject<Item> TEST_TUBE =
            ITEMS.register("test_tube", () -> new TestTube(new Item.Properties().tab(ModCreativeModeTab.OPUS_TAB)));

    public static final RegistryObject<Item> ERLENMEYER_FLASK =
            ITEMS.register("erlenmeyer_flask", () -> new ErlenmeyerFlask(new Item.Properties().tab(ModCreativeModeTab.OPUS_TAB)));

    public static final RegistryObject<Item> ROUNDBOTTOM_FLASK =
            ITEMS.register("roundbottom_flask", () -> new RoundBottomFlask(new Item.Properties().tab(ModCreativeModeTab.OPUS_TAB)));

    public static final RegistryObject<Item> FALLBACK = ITEMS.register("fallback", () -> new Item(new Item.Properties()));

    // #endregion

    public static void register(final IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
