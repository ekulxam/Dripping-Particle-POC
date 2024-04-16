package survivalblock.drippingparticle.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import survivalblock.drippingparticle.common.init.ModParticles;

public class DrippingParticleClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // ParticleFactoryRegistry.getInstance().register(ModParticles.DRIPPING_SOUL_TEAR, ModParticles::createDrippingSoulTear);
        // ParticleFactoryRegistry.getInstance().register(ModParticles.FALLING_SOUL_TEAR, ModParticles::createLandingSoulTear);
        // ParticleFactoryRegistry.getInstance().register(ModParticles.LANDING_SOUL_TEAR, ModParticles::createFallingSoulTear);
    }
}
