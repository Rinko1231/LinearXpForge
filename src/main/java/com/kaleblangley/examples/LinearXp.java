package com.kaleblangley.examples;

import com.kaleblangley.examples.config.LinearXpConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kaleblangley.examples.config.LinearXpConfig.CONFIG;

@Mod(LinearXp.MODID)
public class LinearXp {
    public static final String MODID = "linearxpforge";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public LinearXp(IEventBus modEventBus, ModContainer modContainer){
        modContainer.registerConfig(ModConfig.Type.COMMON, CONFIG);
    }
}
