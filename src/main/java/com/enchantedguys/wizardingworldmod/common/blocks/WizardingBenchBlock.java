package com.enchantedguys.wizardingworldmod.common.blocks;

import com.enchantedguys.wizardingworldmod.common.init.ModTileEntities;
import com.enchantedguys.wizardingworldmod.common.tile.WizardingBenchTile;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

/**
 * If you want to create a block with a inventory (a container) you can use this as a example
 */
public class WizardingBenchBlock extends BaseContainerBlock<WizardingBenchTile> {

    public WizardingBenchBlock() {
        super(AbstractBlock.Properties.create(Material.WOOD));
    }

    /**
     * @return the new create() method form the tile entity
     */
    @Override
    public TileEntity create() {
        return ModTileEntities.WIZARDING_BENCH.get().create();
    }

    /**
     * @return the tile entity class for some checks in the parent class
     */
    @Override
    public Class<WizardingBenchTile> tileEntityClass() {
        return WizardingBenchTile.class;
    }
}
