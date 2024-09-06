package com.rinko1231.linearxpforge;

import com.mojang.logging.LogUtils;
import com.rinko1231.linearxpforge.config.LinearXpConfig;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// 使用 @Mod 注解，并指定你的模组 ID
@Mod("linearxpforge")
public class LinearXpForge {

    // 模组的日志记录器，便于在控制台输出调试信息
    private static final Logger LOGGER = LogUtils.getLogger();

    // 构造函数 - 这个是模组的启动入口
    public LinearXpForge() {
        // 注册事件总线 (Event Bus)
        MinecraftForge.EVENT_BUS.register(this);
        LinearXpConfig.setup();



        LOGGER.info("linearxpforge 模组已初始化！");
    }
}