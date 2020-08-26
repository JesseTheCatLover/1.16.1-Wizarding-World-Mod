package com.enchantedguys.wizardingworldmod.common.util.helpers;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class TextComponentHelper {

    public static ITextComponent translate(String path) {
        return new TranslationTextComponent(path);
    }

    public static ITextComponent translateScreenName(String screenName) {
        return translate(WizardingWorldMod.MOD_ID + ".screen." + screenName);
    }

}
