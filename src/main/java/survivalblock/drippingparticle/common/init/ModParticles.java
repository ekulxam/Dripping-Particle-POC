package survivalblock.drippingparticle.common.init;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluids;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import survivalblock.drippingparticle.common.DrippingParticle;
import survivalblock.drippingparticle.mixin.ContinuousFallingAccessor;
import survivalblock.drippingparticle.mixin.DrippingAccessor;
import survivalblock.drippingparticle.mixin.LandingAccessor;


@SuppressWarnings("unused")
public class ModParticles {

    public static final DefaultParticleType DRIPPING_SOUL_TEAR = FabricParticleTypes.simple();
    public static final DefaultParticleType FALLING_SOUL_TEAR = FabricParticleTypes.simple();
    public static final DefaultParticleType LANDING_SOUL_TEAR = FabricParticleTypes.simple();


    public static void init(){
        Registry.register(Registries.PARTICLE_TYPE, DrippingParticle.id("dripping_soul_tear"), DRIPPING_SOUL_TEAR);
        Registry.register(Registries.PARTICLE_TYPE, DrippingParticle.id("falling_soul_tear"), FALLING_SOUL_TEAR);
        Registry.register(Registries.PARTICLE_TYPE, DrippingParticle.id("landing_soul_tear"), LANDING_SOUL_TEAR);
    }

    public static SpriteBillboardParticle createDrippingSoulTear(DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        BlockLeakParticle.Dripping dripping = new BlockLeakParticle.Dripping(world, x, y, z, Fluids.EMPTY, FALLING_SOUL_TEAR);
        dripping.obsidianTear = true;
        dripping.gravityStrength *= 0.01F;
        dripping.maxAge = 100;
        dripping.setColor(0.396078431f, 0.988235294f, 0.96078431372f);
        return dripping;
    }

    public static SpriteBillboardParticle createFallingSoulTear(DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        BlockLeakParticle blockLeakParticle = new BlockLeakParticle.ContinuousFalling(world, x, y, z, Fluids.EMPTY, LANDING_SOUL_TEAR);
        blockLeakParticle.obsidianTear = true;
        blockLeakParticle.gravityStrength = 0.01F;
        blockLeakParticle.setColor(0.396078431f, 0.988235294f, 0.96078431372f);
        return blockLeakParticle;
    }

    public static SpriteBillboardParticle createLandingSoulTear(DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        BlockLeakParticle blockLeakParticle = new BlockLeakParticle.Landing(world, x, y, z, Fluids.EMPTY);
        blockLeakParticle.obsidianTear = true;
        blockLeakParticle.maxAge = (int)(28.0 / (Math.random() * 0.8 + 0.2));
        blockLeakParticle.setColor(0.396078431f, 0.988235294f, 0.96078431372f);
        return blockLeakParticle;
    }
}
