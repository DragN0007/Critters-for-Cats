package com.dragn0007.preycritters.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class CrittersForCatsCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> MICE_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MICE_MIN;
    public static final ForgeConfigSpec.ConfigValue<Integer> MICE_MAX;

    static {
        BUILDER.push("Mice");

        MICE_WEIGHT = BUILDER.comment("How often should Mice spawn? Default is 3.")
                .define("Mice Spawn Weight", 30);
        MICE_MIN = BUILDER.comment("How many Mice, minimum, should be able to spawn in a group? Default is 1.")
                .define("Mice Spawn Min", 1);
        MICE_MAX = BUILDER.comment("How many Mice, maximum, should be able to spawn in a group? Default is 3.")
                .define("Mice Spawn Max", 3);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
