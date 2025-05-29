package com.kaleblangley.examples.mixin.compat;

import com.kaleblangley.examples.config.LinearXpConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "io.redspace.ironsrpgtweaks.xp_module.entity.XpCatalyst")
public class XpCatalystMixin {
    @Inject(method = "getXpNeededForLevel", at = @At("HEAD"), cancellable = true)
    public void lineXp(int level, CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(LinearXpConfig.XpPerLevel.get());
    }
}
