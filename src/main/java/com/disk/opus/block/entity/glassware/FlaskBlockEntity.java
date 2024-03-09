package com.disk.opus.block.entity.glassware;

import javax.annotation.Nonnull;

import com.disk.opus.block.entity.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class FlaskBlockEntity extends BlockEntity
{
    private final ItemStackHandler itemHandler = new ItemStackHandler(4)
    {
        @Override
        protected void onContentsChanged(final int slot)
        {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public FlaskBlockEntity(final BlockPos pWorldPosition, final BlockState pBlockState)
    {
        super(ModBlockEntities.FLASK_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    public FlaskBlockEntity(final BlockEntityType<?> pType, final BlockPos pWorldPosition, final BlockState pBlockState)
    {
        super(pType, pWorldPosition, pBlockState);
    }

    @SuppressWarnings("null")
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, @javax.annotation.Nullable final Direction side)
    {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad()
    {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()
    {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @SuppressWarnings("null")
    @Override
    protected void saveAdditional(@Nonnull final CompoundTag tag)
    {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @SuppressWarnings("null")
    @Override
    public void load(final CompoundTag nbt)
    {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    @SuppressWarnings("null")
    public void drops()
    {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++)
        {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(final Level pLevel, final BlockPos pPos, final BlockState pState, final FlaskBlockEntity pBlockEntity)
    {

    }
}
