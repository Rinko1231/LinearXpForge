package com.kaleblangley.examples.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class LinearXpConfig
{
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static ModConfigSpec CONFIG;
    public static ModConfigSpec.IntValue XpPerLevel;

    static
    {
        BUILDER.push("linear Xp per Level");

        XpPerLevel = BUILDER
                .comment("linear Xp per Level, default is 50, min is 1")
                .defineInRange("XpPerLevel", 50, 1, Integer.MAX_VALUE);

        CONFIG = BUILDER.build();
    }
}