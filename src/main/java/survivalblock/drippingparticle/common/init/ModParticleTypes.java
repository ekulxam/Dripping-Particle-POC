package survivalblock.drippingparticle.common.init;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import survivalblock.drippingparticle.common.DrippingParticle;

public class ModParticleTypes {

    public static final DefaultParticleType DRIPPING_SOUL_TEAR = register("dripping_soul_tear", false);
    public static final DefaultParticleType FALLING_SOUL_TEAR = register("falling_soul_tear", false);
    public static final DefaultParticleType LANDING_SOUL_TEAR = register("landing_soul_tear", false);

    @SuppressWarnings("SameParameterValue")
    private static DefaultParticleType register(String name, boolean alwaysShow) {
        return Registry.register(Registries.PARTICLE_TYPE, DrippingParticle.id(name), FabricParticleTypes.simple(alwaysShow));
    }

    public static void init(){

    }
}
