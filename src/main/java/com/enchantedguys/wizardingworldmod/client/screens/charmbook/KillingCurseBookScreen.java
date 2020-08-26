package com.enchantedguys.wizardingworldmod.client.screens.charmbook;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.util.helpers.TextComponentHelper;

public class KillingCurseBookScreen extends AbstractCharmBookScreen {

    public KillingCurseBookScreen() {
        super(TextComponentHelper.translateScreenName("killing_curse"), WizardingWorldMod.rlTexture("gui/killing_curse_gui.png"), 146, 180);
    }
}

