package com.enchantedguys.wizardingworldmod.common.util.helpers;

import net.minecraft.item.ItemStack;

public class MethodsHelper {

    @SafeVarargs
    public static <T> boolean containsEmptyElement(T... array) {
        boolean flag;
        for (T t : array) {
            if (t instanceof ItemStack) {
                ItemStack stack = (ItemStack) t;
                flag = stack.isEmpty();
            } else {
                flag = t == null;
            }
            if (flag)
                return true;
        }
        return false;
    }

}
