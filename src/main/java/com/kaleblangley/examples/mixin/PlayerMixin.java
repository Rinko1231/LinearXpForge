package com.kaleblangley.examples.mixin;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    private static final int XP_PER_LEVEL = 50;

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow
    public abstract void increaseScore(int score);

    @Shadow
    public int totalExperience;

    @Shadow
    public int experienceLevel;

    @Shadow
    public float experienceProgress;

    @Shadow
    private int lastLevelUpTime;

    @Inject(method = "giveExperiencePoints", at = @At("HEAD"), cancellable = true)
    private void onGiveExperiencePoints(int xpPoints, CallbackInfo ci) {
        PlayerXpEvent.XpChange event = new PlayerXpEvent.XpChange((Player) (Object) this, xpPoints);
        if (NeoForge.EVENT_BUS.post(event).isCanceled()) {
            ci.cancel();
            return;
        }
        xpPoints = event.getAmount();

        this.increaseScore(xpPoints);
        this.totalExperience = Mth.clamp(this.totalExperience + xpPoints, 0, Integer.MAX_VALUE);
        this.experienceLevel = this.totalExperience / XP_PER_LEVEL;
        this.experienceProgress = (this.totalExperience % XP_PER_LEVEL) / (float) XP_PER_LEVEL;

        ci.cancel();
    }

    @Inject(method = "giveExperienceLevels", at = @At("HEAD"), cancellable = true)
    private void onGiveExperienceLevels(int levels, CallbackInfo ci) {
        PlayerXpEvent.LevelChange event = new PlayerXpEvent.LevelChange((Player) (Object) this, levels);
        if (NeoForge.EVENT_BUS.post(event).isCanceled()) {
            ci.cancel();
            return;
        }
        levels = event.getLevels();

        int xpChange = levels * XP_PER_LEVEL;
        this.totalExperience = Mth.clamp(this.totalExperience + xpChange, 0, Integer.MAX_VALUE);
        this.experienceLevel = this.totalExperience / XP_PER_LEVEL;
        this.experienceProgress = (this.totalExperience % XP_PER_LEVEL) / (float) XP_PER_LEVEL;

        if (levels > 0 && this.experienceLevel % 5 == 0 && this.lastLevelUpTime < this.tickCount - 100) {
            float f = 1.0F;
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_LEVELUP, this.getSoundSource(), f * 0.75F, 1.0F);
            this.lastLevelUpTime = this.tickCount;
        }

        ci.cancel();
    }

    @Inject(method = "getXpNeededForNextLevel", at = @At("HEAD"))
    public void setXpPerLevel(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(XP_PER_LEVEL);
    }
}
