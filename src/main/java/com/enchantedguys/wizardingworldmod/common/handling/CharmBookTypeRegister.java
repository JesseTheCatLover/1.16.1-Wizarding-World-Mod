package com.enchantedguys.wizardingworldmod.common.handling;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.items.charmbooks.ICharmBook;
import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class CharmBookTypeRegister {

    public static final ResourceLocation KILLING_CURSE = WizardingWorldMod.rl("charm_book_killing_curse");

    private List<ICharmBook> charmBooks;

    public CharmBookTypeRegister() {
        this.charmBooks = Lists.newArrayList();
    }

    public void registerCharmBook(ICharmBook book) {
        Objects.requireNonNull(book, "Can not register charm book. Reason: null");
        if (charmBooks.contains(book))
            return;
        charmBooks.add(book);
        WizardingWorldMod.LOGGER.info("Registered charm book with id: " + book.getTypeId().getPath());
    }

    @Nullable
    public ICharmBook getCharmBook(ResourceLocation id) {
        for (ICharmBook charmBook : charmBooks)
            if (charmBook.getTypeId().equals(id)) {
                try {
                    return charmBook.cloneBook();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        return null;
    }

    @Nullable
    public static ICharmBook findById(String id) {
        CharmBookTypeRegister register = WizardingWorldMod.getCharmBookTypeRegister();
        return register.getCharmBook(WizardingWorldMod.rl(WizardingWorldMod.withoutWWM(id)));
    }

}
