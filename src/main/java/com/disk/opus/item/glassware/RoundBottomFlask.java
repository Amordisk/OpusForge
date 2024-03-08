package com.disk.opus.item.glassware;

import com.disk.opus.item.ModItems;

import net.minecraft.world.item.Item;

public class RoundBottomFlask extends Flask
{
    public RoundBottomFlask(final Properties properties)
    {
        super(properties);
    }

    protected Item getFilledVariant()
    {
        return ModItems.FALLBACK.get();
    }
}
