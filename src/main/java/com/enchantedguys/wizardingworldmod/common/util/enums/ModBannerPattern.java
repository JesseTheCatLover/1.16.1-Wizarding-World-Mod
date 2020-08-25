package com.enchantedguys.wizardingworldmod.common.util.enums;

public enum ModBannerPattern {
    HOGWARTS("hogwarts", "hog", true),
    DEATH_EATER("death_eater", "dea", true),
    GRYFFINDOR("gryffindor", "gry", true),
    SLYTHERIN("slytherin", "sly", true),
    HUFFLEPUFP("hufflepufp", "huf", true),
    RAVENCLAW("ravenclaw", "rav", true);

    private String name;
    private String hash;
    private boolean bool;

    ModBannerPattern(String NameIn, String hash, boolean bol) {
        this.name = NameIn;
        this.hash = hash;
        this.bool = bol;
    }

    public String getHash() {
        return hash;
    }

    public String getName() {
        return name;
    }

    public boolean isBool() {
        return bool;
    }
}
