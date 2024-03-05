package com.disk.opus.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModCreativeModeTab
{
    private ModCreativeModeTab()
    {
        throw new UnsupportedOperationException();
    }
    public static final CreativeModeTab OPUS_TAB = new CreativeModeTab("opustab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.TEST_TUBE.get());
        }
    };
}
