package com.enchantedguys.wizardingworldmod.common.items.charmbooks;

import com.enchantedguys.wizardingworldmod.client.screens.charmbook.AbstractCharmBookScreen;
import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * Every charm book must extend this class.
 */
public abstract class AbstractCharmBook extends Item implements ICharmBook {

    public AbstractCharmBook() {
        super(new Item.Properties().group(WizardingWorldMod.CHARMS).maxStackSize(1));
    }

    /**
     * This method must return the screen instance, otherwise it throws a NPE
     * Use {@link com.enchantedguys.wizardingworldmod.client.screens.charmbook.CharmBookScreenManager#getScreen(Class)}, the manager can you geht from
     * {@link WizardingWorldMod#getCharmBookScreenManager()}
     *
     * @return the screen instance.
     */
    public abstract AbstractCharmBookScreen getScreen();

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(worldIn.isRemote) {
            Minecraft.getInstance().displayGuiScreen(getScreen());
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
