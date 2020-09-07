package com.enchantedguys.wizardingworldmod.client.screens;

import com.enchantedguys.wizardingworldmod.common.container.BaseContainer;
import com.enchantedguys.wizardingworldmod.common.tile.ContainerTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public abstract class WWMScreen<T extends ContainerTile, C extends BaseContainer<T>> extends ContainerScreen<C> {

    private final ResourceLocation background;

    public WWMScreen(C screenContainer, PlayerInventory inv, ITextComponent titleIn, ResourceLocation background) {
        super(screenContainer, inv, titleIn);
        this.background = background;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bindTexture(background);
        int startX = this.guiLeft;
        int startY = this.guiTop;
        this.blit(matrixStack, startX, startY, 0, 0, this.xSize, this.ySize);
        this.backgroundRendering(partialTicks, x, y);
    }

    public abstract void backgroundRendering(float partialTicks, int mouseX, int mouseY);


}
