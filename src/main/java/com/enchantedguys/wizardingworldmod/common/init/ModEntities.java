package com.enchantedguys.wizardingworldmod.common.init;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.entities.ChocolateFrogEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, WizardingWorldMod.MOD_ID);

    public static final RegistryObject<EntityType<ChocolateFrogEntity>> CHOCOLATE_FROG = registerEntity("chocolate_frog", ChocolateFrogEntity::new, EntityClassification.MISC, 1.0F, 1.0F);

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String registryName, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height) {
        return ENTITY_TYPES.register(registryName, () -> EntityType.Builder.create(factory, classification).size(width, height).build(WizardingWorldMod.rl(registryName).toString()));
    }

}
