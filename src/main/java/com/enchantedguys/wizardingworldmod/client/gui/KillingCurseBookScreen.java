package com.enchantedguys.wizardingworldmod.client.gui;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class KillingCurseBookScreen extends Screen {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(WizardingWorldMod.MOD_ID,
            "textures:/gui/killing_curse_gui.png");


    public KillingCurseBookScreen(ITextComponent titleIn) {
        super(titleIn);

        int guiLeft = 20;
        int guiTop = 0;
        int xSize = 165;
        int ySize = 180;

    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int i = (this.width - 192) / 2;
        int j = 2;
        this.blit(matrixStack, i, 2, 0, 0, 192, 192);
    }

    @Override
    public void init() {
        super.init();
        this.addDoneButton();
    }

    public void addDoneButton() {
        this.addButton(new Button(this.width / 2 - 100, 196, 200, 20, DialogTexts.field_240632_c_, (p_214161_1_) -> {
            this.minecraft.displayGuiScreen((Screen)null);
        }));
    }


}

