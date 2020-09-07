package com.enchantedguys.wizardingworldmod.client.screens.charmbook;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.items.charmbooks.AbstractCharmBook;
import com.google.common.collect.Maps;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Objects;

/**
 * This class is been used to register the screens for the charm books
 * You can access to this class from: {@link WizardingWorldMod#getCharmBookScreenManager()}
 */
public class CharmBookScreenManager {

    private final Map<Class<? extends AbstractCharmBook>, AbstractCharmBookScreen> screens;

    public CharmBookScreenManager() {
        this.screens = Maps.newHashMap();
    }

    /**
     * Use this method to register a screen for a charm book
     *
     * @param clazz the charm book class, where you want to add the screen
     * @param screen a new instance from the screen class
     */
    public void registerScreen(Class<? extends AbstractCharmBook> clazz, AbstractCharmBookScreen screen) {
        Objects.requireNonNull(clazz, "Can not register charm book screen, screen type is null");
        Objects.requireNonNull(screen, "Can not register charm book screen, screen object is null");
        if (screens.containsKey(clazz))
            return;
        screens.put(clazz, screen);
        WizardingWorldMod.LOGGER.info("Registered screen: " + clazz.toString());
    }

    /**
     * Returned the screen
     *
     * @param type the type from the screen (Just the item calss)
     * @return the screen
     * @throws NullPointerException if the screen was ot found or the type is null
     */
    @Nonnull
    public AbstractCharmBookScreen getScreen(Class<? extends AbstractCharmBook> type) {
        Objects.requireNonNull(type, "Can not register charm book screen, screen type is null");
        if (!this.screens.containsKey(type))
            throw new NullPointerException("Charm book screen not found with type: " + type.toString());
        return this.screens.get(type);
    }

}
