package com.enchantedguys.wizardingworldmod.common.util.math;

public class ModMath {

    public static int getRandomNumberWithinIntRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}
