package com.enchantedguys.wizardingworldmod.common.blocks;

import com.enchantedguys.wizardingworldmod.common.init.ModTileEntities;
import com.enchantedguys.wizardingworldmod.common.tile.WizardingBenchTile;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

public class WizardingBenchBlock extends BaseContainerBlock<WizardingBenchTile> {

    public WizardingBenchBlock() {
        super(AbstractBlock.Properties.create(Material.WOOD));
    }

    @Override
    public TileEntity create() {
        return ModTileEntities.WIZARDING_BENCH.get().create();
    }

    @Override
    public Class<WizardingBenchTile> tileEntityClass() {
        return WizardingBenchTile.class;
    }
}
