package com.disk.opus.item.glassware;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public abstract class Flask extends Item
{
    public Flask(final Properties properties)
    {
        super(properties);
    }

    @SuppressWarnings("null")
    @Override
    public final InteractionResultHolder<ItemStack> use(@Nonnull final Level world, @Nonnull final Player player, @Nonnull final InteractionHand hand)
    {
        ItemStack itemstack = player.getItemInHand(hand);
        HitResult hitresult = getPlayerPOVHitResult(world, player, ClipContext.Fluid.SOURCE_ONLY);
        if (hitresult.getType() == HitResult.Type.MISS)
        {
            return InteractionResultHolder.pass(itemstack);
        } else
        {
            if (hitresult.getType() == HitResult.Type.BLOCK)
            {
                BlockPos blockpos = ((BlockHitResult) hitresult).getBlockPos();
                if (!world.mayInteract(player, blockpos))
                {
                    return InteractionResultHolder.pass(itemstack);
                }
                if (world.getFluidState(blockpos).is(FluidTags.WATER))
                {
                    world.gameEvent(player, GameEvent.FLUID_PICKUP, blockpos);
                    return InteractionResultHolder.sidedSuccess(this.turnBottleIntoItem(itemstack, player), world.isClientSide());
                }
            }
            return InteractionResultHolder.pass(itemstack);
        }
    }

    @SuppressWarnings("null")
    protected final ItemStack turnBottleIntoItem(@Nonnull final ItemStack emptyitem, final Player player)
    {
        player.awardStat(Stats.ITEM_USED.get(this));
        return ItemUtils.createFilledResult(emptyitem, player, new ItemStack(getFilledVariant()));
    }

    protected abstract Item getFilledVariant();
}
