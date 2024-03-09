package com.disk.opus.block.glassware;

import javax.annotation.Nullable;

import org.apache.commons.lang3.NotImplementedException;

import com.disk.opus.block.entity.ModBlockEntities;
import com.disk.opus.block.entity.glassware.FlaskBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("null")
public class FlaskBlock extends BaseEntityBlock
{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public FlaskBlock(final Properties properties)
    {
        super(properties);
    }

    // #region Facing

    @Override
    public BlockState getStateForPlacement(final BlockPlaceContext pContext)
    {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(final BlockState pState, final Rotation pRotation)
    {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(final BlockState pState, final Mirror pMirror)
    {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(FACING);
    }

    // #endregion

    // #region block entity

    @Override
    public RenderShape getRenderShape(final BlockState pState)
    {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(final BlockState pState, final Level pLevel, final BlockPos pPos, final BlockState pNewState, final boolean pIsMoving)
    {
        if (pState.getBlock() != pNewState.getBlock())
        {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof FlaskBlockEntity)
            {
                ((FlaskBlockEntity)blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(final BlockState pState, final Level pLevel, final BlockPos pPos, final Player pPlayer, final InteractionHand pHand,
            final BlockHitResult pHit)
    {
        if (!pLevel.isClientSide())
        {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if (entity instanceof FlaskBlockEntity)
            {
                // Put fluids in / take fluids out
                throw new NotImplementedException();
            } else
            {
                throw new IllegalStateException(
                        String.format("Expected entity at %s to be instanceof FlaskBlockEntity, but was %s", pPos.toString(), entity.getType()));
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(final BlockPos pPos, final BlockState pState)
    {
        return new FlaskBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final Level pLevel, final BlockState pState,
            final BlockEntityType<T> pBlockEntityType)
    {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.FLASK_BLOCK_ENTITY.get(), FlaskBlockEntity::tick);
    }

    // #endregion
}
