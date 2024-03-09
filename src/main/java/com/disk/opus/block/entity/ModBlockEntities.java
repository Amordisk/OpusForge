package com.disk.opus.block.entity;

import com.disk.opus.Opus;
import com.disk.opus.block.ModBlocks;
import com.disk.opus.block.entity.glassware.FlaskBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("null")
public final class ModBlockEntities
{
    private ModBlockEntities()
    {
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Opus.MOD_ID);

    public static final RegistryObject<BlockEntityType<FlaskBlockEntity>> FLASK_BLOCK_ENTITY = BLOCK_ENTITIES.register("flask_block_entity",
            () -> BlockEntityType.Builder.of(FlaskBlockEntity::new, ModBlocks.SILICA_BLOCK.get()).build(null));

    public static void register(final IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}
