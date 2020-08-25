package com.enchantedguys.wizardingworldmod.common.items.foods;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ChocolateFrog extends Item {
    public ChocolateFrog() {
        super(new Item.Properties()
                .group(WizardingWorldMod.FOODS)
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        playerIn.getHeldItemMainhand().shrink(1);

        worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(),
                playerIn.getPosZ(), SoundEvents.UI_LOOM_TAKE_RESULT, null,
                0.7F, 2.5F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);

        if (playerIn.getHeldItemMainhand().isEmpty()) {
            playerIn.setHeldItem(Hand.MAIN_HAND, new ItemStack(ModItems.CHOCOLATE_FROG_CARD.get()));
        } else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(ModItems.CHOCOLATE_FROG_CARD.get()))) {
            playerIn.dropItem(new ItemStack(ModItems.CHOCOLATE_FROG_CARD.get()), false);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
