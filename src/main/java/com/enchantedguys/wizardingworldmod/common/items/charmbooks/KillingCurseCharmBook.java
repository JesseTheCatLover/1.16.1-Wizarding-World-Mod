package com.enchantedguys.wizardingworldmod.common.items.charmbooks;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


public class KillingCurseCharmBook extends Item {

    public KillingCurseCharmBook(){

        super(new Item.Properties()
                .group(WizardingWorldMod.CHARMS)
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);

    }
    
}
