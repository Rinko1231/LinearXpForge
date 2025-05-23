package com.kaleblangley.examples;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Examples.MODID)
public class Examples {
    public static final String MODID = "examples";
    public static final Logger LOGGER = LoggerFactory.getLogger("examples");
    public Examples(IEventBus modEventBus, ModContainer modContainer){
    }
}
