package com.rinko1231.linearxpforge;

import com.mojang.logging.LogUtils;
import com.rinko1231.linearxpforge.config.LinearXpConfig;

import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

import static com.rinko1231.linearxpforge.config.LinearXpConfig.CONFIG;


@Mod("linearxpforge")
public class LinearXpForge {

    // 模组的日志记录器，便于在控制台输出调试信息
    private static final Logger LOGGER = LogUtils.getLogger();

    // 构造函数 - 这个是模组的启动入口
    public LinearXpForge() {
        // 注册事件总线 (Event Bus)
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CONFIG);
    }
}
