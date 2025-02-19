package com.dragn0007.preycritters.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class CrittersForCatsCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.ConfigValue<Integer> MAX_COYOTE_GROUP;
    public static ForgeConfigSpec.ConfigValue<Integer> MAX_WOLF_GROUP;

    static {
        BUILDER.push("Mice");

        MAX_COYOTE_GROUP = BUILDER.comment("How many Coyotes should be able to be in the same pack? Default is 4.")
                .define("Max Coyotes in a Group", 4);

        MAX_WOLF_GROUP = BUILDER.comment("How many Wolves should be able to be in the same pack? Default is 4.")
                .define("Max Coyotes in a Group", 4);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }

}
