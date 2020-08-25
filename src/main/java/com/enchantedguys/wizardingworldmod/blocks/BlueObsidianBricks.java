package com.enchantedguys.wizardingworldmod.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlueObsidianBricks extends Block {

    public BlueObsidianBricks() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(50f,1200f )
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(3)
                .setRequiresTool()
                .setLightLevel(value -> 8));
    }

}
