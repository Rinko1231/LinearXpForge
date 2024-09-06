package com.rinko1231.linearxpforge.mixin;

import com.rinko1231.linearxpforge.config.LinearXpConfig;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {

    // 修改 getXpNeededForNextLevel 方法
    @Inject(method = "getXpNeededForNextLevel", at = @At("HEAD"), cancellable = true)
    public void modifyXpNeededForNextLevel(CallbackInfoReturnable<Integer> cir) {
        // 强制设置每次升级
        cir.setReturnValue(LinearXpConfig.XpPerLevel.get());
    }
}
