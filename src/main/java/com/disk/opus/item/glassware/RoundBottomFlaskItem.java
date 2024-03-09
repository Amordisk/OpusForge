package com.disk.opus.item.glassware;

import com.disk.opus.item.ModItems;

import net.minecraft.world.item.Item;

public class RoundBottomFlaskItem extends FlaskItem
{
    public RoundBottomFlaskItem(final Properties properties)
    {
        super(properties);
    }

    protected Item getFilledVariant()
    {
        return ModItems.FALLBACK.get();
    }
}
