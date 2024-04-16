package survivalblock.drippingparticle.mixin;

import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import survivalblock.drippingparticle.common.init.ModParticles;

@Mixin(ParticleManager.class)
public abstract class ParticleManagerMixin {

    @Shadow protected abstract <T extends ParticleEffect> void registerBlockLeakFactory(ParticleType<T> type, ParticleFactory.BlockLeakParticleFactory<T> factory);

    @Inject(method = "registerDefaultFactories", at = @At("TAIL"))
    private void registerMyBlockLeakParticleFactoriesToo(CallbackInfo ci){
        this.registerBlockLeakFactory(ModParticles.DRIPPING_SOUL_TEAR, ModParticles::createDrippingSoulTear);
        this.registerBlockLeakFactory(ModParticles.FALLING_SOUL_TEAR, ModParticles::createFallingSoulTear);
        this.registerBlockLeakFactory(ModParticles.LANDING_SOUL_TEAR, ModParticles::createLandingSoulTear);
    }
}
