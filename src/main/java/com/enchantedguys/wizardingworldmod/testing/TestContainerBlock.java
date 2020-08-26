package com.enchantedguys.wizardingworldmod.testing;

import com.enchantedguys.wizardingworldmod.common.blocks.BaseContainerBlock;
import net.minecraft.tileentity.TileEntity;

public class TestContainerBlock extends BaseContainerBlock<TestContainerBlockTile> {

    public TestContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public TileEntity create() {
        return null; //Return ModTileEntities.TILE.get().create() [Just with the exiting tile then]
    }

    @Override
    public Class<TestContainerBlockTile> tileEntityClass() {
        return TestContainerBlockTile.class; //Just return the class
    }
}
