package com.enchantedguys.wizardingworldmod.client.screens.charmbook;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractCharmBookScreen extends Screen {

    protected ResourceLocation texture;
    protected int texWidth;
    protected int texHeight;
    protected int guiLeft;
    protected int guiTop;
    protected Button doneButton;

    public AbstractCharmBookScreen(ITextComponent titleIn, ResourceLocation texture, int texWidth, int texHeight) {
        super(titleIn);
        this.texture = texture;
        this.texWidth = texWidth;
        this.texHeight = texHeight;
    }

    @Override
    protected void init() {
        super.init();
        this.guiLeft = (this.width - texWidth) / 2;
        this.guiTop = ((this.height - texHeight) / 2) - 15;
        this.doneButton = this.addButton(new Button(this.guiLeft + (texWidth / 2) - 49, this.guiTop + texHeight + 10, 98, 20, DialogTexts.field_240632_c_, (press) -> closeScreen()));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        renderBackground(matrixStack, 0);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        renderComponentHoverEffect(matrixStack, Style.EMPTY, mouseX, mouseY);
        this.additionalBackgroundRendering(matrixStack);
    }

    /**
     * Override if you want render extra things
     */
    public void additionalBackgroundRendering(MatrixStack stack) {

    }

    @Override
    public void renderBackground(MatrixStack matrixStack, int vOffset) {
        super.renderBackground(matrixStack, vOffset);
        RenderSystem.clearColor(1.0F, 1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bindTexture(this.texture);
        this.blit(matrixStack, this.guiLeft, this.guiTop, 0, 0, texWidth, texHeight);
    }
}
