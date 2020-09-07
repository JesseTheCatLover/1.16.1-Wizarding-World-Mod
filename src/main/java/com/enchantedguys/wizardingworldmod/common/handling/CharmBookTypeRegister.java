package com.enchantedguys.wizardingworldmod.common.handling;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.items.charmbooks.ICharmBook;
import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

/**
 * This class is been used to register the charm books.
 * If you add a new charm book you have to call registerCharmBook and you HAVE TO create a new
 * public static final ResourceLocation NAME = WizardingWorldMod.rl("name");
 * variable for the type and return this type in the charm book class.
 *
 * You can access to this class from {@link WizardingWorldMod#getCharmBookTypeRegister()}
 *
 */
public class CharmBookTypeRegister {

    public static final ResourceLocation KILLING_CURSE = WizardingWorldMod.rl("charm_book_killing_curse");

    private List<ICharmBook> charmBooks;

    public CharmBookTypeRegister() {
        this.charmBooks = Lists.newArrayList();
    }

    /**
     * This method is been used to register the charm book
     * @param book the charm book instance
     */
    public void registerCharmBook(ICharmBook book) {
        Objects.requireNonNull(book, "Can not register charm book. Reason: null");
        if (charmBooks.contains(book))
            return;
        charmBooks.add(book);
        WizardingWorldMod.LOGGER.info("Registered charm book with id: " + book.getTypeId().getPath());
    }

    /**
     * @param id the id from the charm book
     * @return the charm book instance or
     *         null if the charm book does not exist
     */
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

    /**
     * @param id the id where you want to get
     * @return the charm bok instance or
     *         null if the charm book does not exist
     */
    @Nullable
    public static ICharmBook findById(String id) {
        CharmBookTypeRegister register = WizardingWorldMod.getCharmBookTypeRegister();
        return register.getCharmBook(WizardingWorldMod.rl(WizardingWorldMod.withoutWWM(id)));
    }

}
