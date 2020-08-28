package com.enchantedguys.wizardingworldmod.client.renderer.models;// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.enchantedguys.wizardingworldmod.common.entities.ChocolateFrogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ChocolateFrogModel extends EntityModel<ChocolateFrogEntity> {

    private final ModelRenderer Body;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer LeftForwardLeg;
    private final ModelRenderer Head;
    private final ModelRenderer RightLeg;
    private final ModelRenderer RightForwardLeg;

    public ChocolateFrogModel() {
        textureWidth = 32;
        textureHeight = 32;

        Body = new ModelRenderer(this);
        Body.setRotationPoint(-0.842F, 22.0603F, 0.0F);
        setRotationAngle(Body, 0.0F, 0.0F, -0.3491F);
        Body.setTextureOffset(0, 0).addBox(-3.0677F, -2.0501F, -3.4F, 7.0F, 3.0F, 5.0F, 0.0F, false);

        LeftLeg = new ModelRenderer(this);
        LeftLeg.setRotationPoint(-0.2875F, 23.875F, 2.4188F);
        setRotationAngle(LeftLeg, 0.0F, -0.3491F, 0.0F);
        LeftLeg.setTextureOffset(12, 8).addBox(-4.3806F, -1.875F, -0.5963F, 4.0F, 2.0F, 2.0F, 0.0F, false);
        LeftLeg.setTextureOffset(8, 16).addBox(-1.2511F, -0.875F, -0.5927F, 3.0F, 1.0F, 2.0F, 0.0F, false);

        LeftForwardLeg = new ModelRenderer(this);
        LeftForwardLeg.setRotationPoint(2.975F, 22.95F, 1.525F);
        setRotationAngle(LeftForwardLeg, 0.0F, 0.0F, -0.1309F);
        LeftForwardLeg.setTextureOffset(0, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        Head = new ModelRenderer(this);
        Head.setRotationPoint(3.7402F, 19.5102F, -0.9F);
        setRotationAngle(Head, 0.0F, 0.0F, -0.0873F);
        Head.setTextureOffset(0, 8).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        RightLeg = new ModelRenderer(this);
        RightLeg.setRotationPoint(-0.2875F, 23.875F, -4.7312F);
        setRotationAngle(RightLeg, 0.0F, 0.3491F, 0.0F);
        RightLeg.setTextureOffset(10, 12).addBox(-4.4915F, -1.875F, -0.9385F, 4.0F, 2.0F, 2.0F, 0.0F, false);
        RightLeg.setTextureOffset(0, 14).addBox(-1.533F, -0.875F, -0.9401F, 3.0F, 1.0F, 2.0F, 0.0F, false);

        RightForwardLeg = new ModelRenderer(this);
        RightForwardLeg.setRotationPoint(2.975F, 22.95F, -1.275F);
        setRotationAngle(RightForwardLeg, 0.0F, 0.0F, -0.1309F);
        RightForwardLeg.setTextureOffset(0, 17).addBox(-0.5F, -2.0F, -2.55F, 1.0F, 3.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(ChocolateFrogEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Body.render(matrixStack, buffer, packedLight, packedOverlay);
        LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        LeftForwardLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
        RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        RightForwardLeg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}



