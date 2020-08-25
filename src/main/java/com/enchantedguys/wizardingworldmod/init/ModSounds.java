package com.enchantedguys.wizardingworldmod.init;

import com.enchantedguys.wizardingworldmod.WizardingWorldMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WizardingWorldMod.MOD_ID);


    // Sound Events

    public static final Lazy<SoundEvent> LAZY_HARRY_POTTER_THEME_MUSIC =
            Lazy.of(() -> new SoundEvent(new ResourceLocation(WizardingWorldMod.MOD_ID,"music_disc.harry_potter_theme")));

    public static final RegistryObject<SoundEvent> HARRY_POTTER_THEME_MUSIC =
            SOUNDS.register("harry_potter_theme_by_john_williams", LAZY_HARRY_POTTER_THEME_MUSIC);


}
