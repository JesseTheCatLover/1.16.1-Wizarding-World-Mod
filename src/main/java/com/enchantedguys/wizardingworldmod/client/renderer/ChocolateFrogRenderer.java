package com.enchantedguys.wizardingworldmod.client.renderer;

import com.enchantedguys.wizardingworldmod.client.renderer.models.ChocolateFrogModel;
import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.entities.ChocolateFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ChocolateFrogRenderer extends MobRenderer<ChocolateFrogEntity, ChocolateFrogModel> {

    private static final ResourceLocation TEXTURE = WizardingWorldMod.rlTexture("entities/chocolate_frog.png");

    public ChocolateFrogRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ChocolateFrogModel(), 0.3F);
    }


    @Override
    public ResourceLocation getEntityTexture(ChocolateFrogEntity entity) {
        return TEXTURE;
    }
}
