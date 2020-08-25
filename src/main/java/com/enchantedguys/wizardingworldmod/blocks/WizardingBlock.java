package com.enchantedguys.wizardingworldmod.blocks;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class WizardingBlock extends Block {

    public WizardingBlock() {
        super(AbstractBlock.Properties.create(Material.WOOD)
                .hardnessAndResistance(2.5f,14f )
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE));
    }

}
