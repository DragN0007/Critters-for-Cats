package com.dragn0007.preycritters.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class CrittersForCatsCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec SPEC;

//    public static ForgeConfigSpec.ConfigValue<Integer> MICE_WEIGHT;
//    public static ForgeConfigSpec.ConfigValue<Integer> MICE_MIN;
//    public static ForgeConfigSpec.ConfigValue<Integer> MICE_MAX;
//    public static ForgeConfigSpec.ConfigValue<Integer> SQUIRREL_WEIGHT;
//    public static ForgeConfigSpec.ConfigValue<Integer> SQUIRREL_MIN;
//    public static ForgeConfigSpec.ConfigValue<Integer> SQUIRREL_MAX;

    static {
        BUILDER.push("Mice");

//        MICE_WEIGHT = BUILDER.comment("How often should Mice spawn? Default is 10.")
//                .define("Mice Spawn Weight", 10);
//        MICE_MIN = BUILDER.comment("How many Mice, minimum, should be able to spawn in a group? Default is 1.")
//                .define("Mice Spawn Min", 1);
//        MICE_MAX = BUILDER.comment("How many Mice, maximum, should be able to spawn in a group? Default is 3.")
//                .define("Mice Spawn Max", 3);
//
//        SQUIRREL_WEIGHT = BUILDER.comment("How often should Squirrels spawn? Default is 6.")
//                .define("Squirrels Spawn Weight", 6);
//        SQUIRREL_MIN = BUILDER.comment("How many Mice, minimum, should be able to spawn in a group? Default is 1.")
//                .define("Squirrels Spawn Min", 1);
//        SQUIRREL_MAX = BUILDER.comment("How many Mice, maximum, should be able to spawn in a group? Default is 1.")
//                .define("Squirrels Spawn Max", 1);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }

}
