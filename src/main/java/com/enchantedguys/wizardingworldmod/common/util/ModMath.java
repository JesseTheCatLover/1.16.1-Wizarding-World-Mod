package com.enchantedguys.wizardingworldmod.common.util;

public class ModMath {

    // Generate random integer within range
    public static int getRandomNumberWithinIntRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    // Generate random float within range
    public static int getRandomNumberWithinFloatRange(float min, float max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}
