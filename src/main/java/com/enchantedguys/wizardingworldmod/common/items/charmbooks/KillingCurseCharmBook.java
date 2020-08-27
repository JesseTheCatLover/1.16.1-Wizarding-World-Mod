package com.enchantedguys.wizardingworldmod.common.items.charmbooks;

import com.enchantedguys.wizardingworldmod.client.screens.charmbook.AbstractCharmBookScreen;
import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;


public class KillingCurseCharmBook extends AbstractCharmBook {

    @Override
    public AbstractCharmBookScreen getScreen() {
        return WizardingWorldMod.getCharmBookScreenManager().getScreen(KillingCurseCharmBook.class);
    }

    @Override
    public Item getCharmBookItem() {
        return this;
    }
}
