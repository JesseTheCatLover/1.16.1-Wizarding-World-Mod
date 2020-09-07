package com.enchantedguys.wizardingworldmod.client.gui;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;

public class WandGUI extends Screen {

    public static final ResourceLocation BACKGROUND = WizardingWorldMod.rlTexture("gui/wand_gui.png");

    public WandGUI(ITextComponent titleIn) {
        super(titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack, 0);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderComponentHoverEffect(matrixStack, Style.EMPTY, mouseX, mouseY);
    }

    @Override
    public void renderBackground(MatrixStack matrixStack, int vOffset) {
        super.renderBackground(matrixStack, vOffset);
    }


}
