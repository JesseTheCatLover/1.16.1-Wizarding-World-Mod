package com.enchantedguys.wizardingworldmod.client.screens;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.container.WizardingBenchContainer;
import com.enchantedguys.wizardingworldmod.common.tile.WizardingBenchTile;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class WizardingBenchScreen extends WWMScreen<WizardingBenchTile, WizardingBenchContainer> {

    public WizardingBenchScreen(WizardingBenchContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn, WizardingWorldMod.rlTexture("gui/container/wizarding_bench_gui.png"));
    }

    @Override
    public void backgroundRendering(float partialTicks, int mouseX, int mouseY) {

    }
}
