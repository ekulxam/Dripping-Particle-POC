package survivalblock.drippingparticle.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import survivalblock.drippingparticle.common.init.ModParticleFactories;
import survivalblock.drippingparticle.common.init.ModParticleTypes;

public class DrippingParticleClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerThroughParticleFactoryRegistry();
    }
    private void registerThroughParticleFactoryRegistry(){
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.DRIPPING_SOUL_TEAR, ModParticleFactories.DrippingSoulTearFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.FALLING_SOUL_TEAR, ModParticleFactories.FallingSoulTearFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.LANDING_SOUL_TEAR, ModParticleFactories.LandingSoulTearFactory::new);
    }
}
