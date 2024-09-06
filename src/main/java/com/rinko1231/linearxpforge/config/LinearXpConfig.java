package com.rinko1231.linearxpforge.config;

import net.minecraft.util.Mth;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class LinearXpConfig
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec CONFIG;
    public static ForgeConfigSpec.IntValue XpPerLevel;

    static
    {
        BUILDER.push("linear Xp per Level");

        XpPerLevel = BUILDER
                .comment("linear Xp per Level, default is 10")
                .defineInRange("XpPerLevel", 10, 0, Integer.MAX_VALUE);

        CONFIG = BUILDER.build();
    }
}
