package com.enchantedguys.wizardingworldmod.common.items;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import com.enchantedguys.wizardingworldmod.common.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class BeerGlass extends Item {
    public BeerGlass() {
        super(new Item.Properties()
                .group(WizardingWorldMod.MATERIALS)
                .maxStackSize(16)
        );
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        ItemStack itemstack = playerIn.getHeldItem(handIn);
            RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
            if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
                return ActionResult.resultPass(itemstack);
            } else {
                if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                    BlockPos blockpos = ((BlockRayTraceResult)raytraceresult).getPos();
                    if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
                        return ActionResult.resultPass(itemstack);
                    }

                    if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {

                        worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        if (playerIn.getHeldItemMainhand().isEmpty()) {
                            playerIn.setHeldItem(Hand.MAIN_HAND, new ItemStack(ModItems.WATER_GLASS.get()));
                        } else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(ModItems.WATER_GLASS.get()))) {
                            playerIn.dropItem(new ItemStack(ModItems.WATER_GLASS.get()), false);
                        }

                        if(!playerIn.abilities.isCreativeMode)
                        {
                            if(playerIn.getHeldItemMainhand().getItem() == ModItems.BEER_GLASS.get())
                            {
                                playerIn.getHeldItemMainhand().shrink(1);
                            }

                            if(playerIn.getHeldItemOffhand().getItem() == ModItems.BEER_GLASS.get())
                            {
                                playerIn.getHeldItemOffhand().shrink(1);
                            }
                        }
                    }
                }

                return ActionResult.resultPass(itemstack);
            }
        }

}
