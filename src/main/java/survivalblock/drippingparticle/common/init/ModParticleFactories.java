package survivalblock.drippingparticle.common.init;

import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluids;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;
import survivalblock.drippingparticle.mixin.ContinuousFallingAccessor;
import survivalblock.drippingparticle.mixin.DrippingAccessor;
import survivalblock.drippingparticle.mixin.LandingAccessor;


public class ModParticleFactories {
    public static BlockLeakParticle.Dripping createDrippingSoulTear(@Nullable BlockLeakParticle.Dripping dripping, DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        if (dripping == null) dripping = DrippingAccessor.newDripping(world, x, y, z, Fluids.EMPTY, ModParticleTypes.FALLING_SOUL_TEAR);
        dripping.obsidianTear = true;
        dripping.gravityStrength *= 0.01F;
        dripping.maxAge = 100;
        dripping.setColor(0.396078431f, 0.988235294f, 0.96078431372f);
        return dripping;
    }

    public static BlockLeakParticle.ContinuousFalling createFallingSoulTear(@Nullable BlockLeakParticle.ContinuousFalling falling, DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        if (falling == null) falling = ContinuousFallingAccessor.newFalling(world, x, y, z, Fluids.EMPTY, ModParticleTypes.LANDING_SOUL_TEAR);
        falling.obsidianTear = true;
        falling.gravityStrength = 0.01F;
        falling.setColor(0.396078431f, 0.988235294f, 0.96078431372f);
        return falling;
    }

    public static BlockLeakParticle.Landing createLandingSoulTear(@Nullable BlockLeakParticle.Landing landing, DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        if (landing == null) landing = LandingAccessor.newLanding(world, x, y, z, Fluids.EMPTY);
        landing.obsidianTear = true;
        landing.maxAge = (int)(28.0 / (Math.random() * 0.8 + 0.2));
        landing.setColor(0.396078431f, 0.988235294f, 0.96078431372f);
        return landing;
    }

    public static class LandingSoulTearFactory implements ParticleFactory<DefaultParticleType> {
        protected final SpriteProvider spriteProvider;

        public LandingSoulTearFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            BlockLeakParticle.Landing landing = LandingAccessor.newLanding(world, x, y, z, Fluids.EMPTY);
            landing.setSprite(this.spriteProvider);
            landing = ModParticleFactories.createLandingSoulTear(landing, defaultParticleType, world, x, y, z, velocityX, velocityY, velocityZ);
            return landing;
        }
    }

    public static class FallingSoulTearFactory implements ParticleFactory<DefaultParticleType> {
        protected final SpriteProvider spriteProvider;
        public FallingSoulTearFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            BlockLeakParticle.ContinuousFalling falling = ModParticleFactories.createFallingSoulTear(null, defaultParticleType, world, x, y, z, velocityX, velocityY, velocityZ);
            falling.setSprite(this.spriteProvider);
            return falling;
        }
    }

    public static class DrippingSoulTearFactory implements ParticleFactory<DefaultParticleType> {
        protected final SpriteProvider spriteProvider;
        public DrippingSoulTearFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            BlockLeakParticle.Dripping dripping = ModParticleFactories.createDrippingSoulTear(null, defaultParticleType, world, x, y, z, velocityX, velocityY, velocityZ);
            dripping.setSprite(this.spriteProvider);
            return dripping;
        }
    }
}
