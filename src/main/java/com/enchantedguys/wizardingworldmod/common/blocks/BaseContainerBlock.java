package com.enchantedguys.wizardingworldmod.common.blocks;

import com.enchantedguys.wizardingworldmod.common.tile.ContainerTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public abstract class BaseContainerBlock<T extends ContainerTile> extends Block {

    public BaseContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return this.create();
    }

    public abstract TileEntity create();

    public abstract Class<T> tileEntityClass();

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity != null && (tileEntity.getClass().equals(tileEntityClass()) || tileEntity.getClass().isInstance(tileEntityClass()))) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, pos);
                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.PASS;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity != null && (tileEntity.getClass().equals(tileEntityClass()) || tileEntity.getClass().isInstance(tileEntityClass()))) {
                ContainerTile containerTile = (ContainerTile) tileEntity;
                InventoryHelper.dropItems(worldIn, pos, containerTile.getInventoryItems());
            }
        }

        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }

}
