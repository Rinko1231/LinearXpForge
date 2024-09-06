package com.rinko1231.linearxpforge.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class LinearXpConfig
{
    private static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final LinearXpConfig INSTANCE = new LinearXpConfig();

    public static ForgeConfigSpec.IntValue XpPerLevel;


    static
    {
        BUILDER.push("linear Xp per Level");

        XpPerLevel = BUILDER
                .comment("linear Xp per Level, default is 112, max is 114514")
                .defineInRange("XpPerLevel", 112, 0, 114514);

        SPEC = BUILDER.build();
    }

    // Getters

    public static int getConfigXpPerLevel() {
        return XpPerLevel.get();
    }

    public static void setup()
    {
        Path configPath = FMLPaths.CONFIGDIR.get();
        Path csConfigPath = Paths.get(configPath.toAbsolutePath().toString(), "linearxpforge");

        // Create the config folder
        try
        {
            Files.createDirectory(csConfigPath);
        }
        catch (Exception e)
        {
            // Do nothing
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC, "linearxpforge/linearxpforge.toml");
    }

    public static LinearXpConfig getInstance()
    {
        return INSTANCE;
    }

    public void save() {
        SPEC.save();
    }
}
