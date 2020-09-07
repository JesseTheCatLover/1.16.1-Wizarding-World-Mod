package com.enchantedguys.wizardingworldmod.common.items.charmbooks;

import com.enchantedguys.wizardingworldmod.client.screens.charmbook.AbstractCharmBookScreen;
import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.handling.CharmBookTypeRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ResourceLocation;


public class KillingCurseCharmBook extends AbstractCharmBook {

    @Override
    public AbstractCharmBookScreen getScreen() {
        return WizardingWorldMod.getCharmBookScreenManager().getScreen(KillingCurseCharmBook.class);
    }

    @Override
    public Item getCharmBookItem() {
        return this;
    }

    @Override
    public ResourceLocation getTypeId() {
        return CharmBookTypeRegister.KILLING_CURSE;
    }

    @Override
    public ICharmBook cloneBook() throws CloneNotSupportedException{
        return (ICharmBook) this.clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
