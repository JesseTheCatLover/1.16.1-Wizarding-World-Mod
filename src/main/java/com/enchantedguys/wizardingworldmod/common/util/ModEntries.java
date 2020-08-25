package com.enchantedguys.wizardingworldmod.common.util;

import com.enchantedguys.wizardingworldmod.common.WizardingWorldMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;


public class ModEntries {

    public static final String NextLine = "\n";

    public static ResourceLocation WandsTag = new ResourceLocation(WizardingWorldMod.MOD_ID, "wands");

    public static final String HoldShiftToolTip = TextFormatting.YELLOW + "Hold " + TextFormatting.RESET + TextFormatting.BOLD +"Shift " + TextFormatting.RESET +
            TextFormatting.YELLOW + "for more information!";

    public static final String OnPlayerWithoutWand = TextFormatting.GRAY + "Take your wand in your hand and try again!";

      public static String WandInformation(String woodMaterial, String core, String flexibility)
      {
          return( TextFormatting.GRAY + woodMaterial + " wood with a " + core + " core," + NextLine + flexibility + " flexibility.");
      }

      public static int KillingCurse(PlayerEntity playerIn)
      {

          boolean rightItemIsInTag = ItemTags.getCollection().get(WandsTag).contains(playerIn.getHeldItemMainhand().getItem());
          boolean leftItemIsInTag = ItemTags.getCollection().get(WandsTag).contains(playerIn.getHeldItemOffhand().getItem());

          if(rightItemIsInTag || leftItemIsInTag) {

              // For test...
              playerIn.addPotionEffect(new EffectInstance(Effects.WITHER, 100, 300));

          } else {
              playerIn.sendMessage(new StringTextComponent(OnPlayerWithoutWand), playerIn.getUniqueID());
          }

           return 1;
      }

}
