package com.disk.opus.item.glassware;

import com.disk.opus.item.ModItems;

import net.minecraft.world.item.Item;

public class TestTube extends Flask
{

    public TestTube(final Properties properties)
    {
        super(properties);
    }

    protected Item getFilledVariant()
    {
        return ModItems.FALLBACK.get();
    }
}
