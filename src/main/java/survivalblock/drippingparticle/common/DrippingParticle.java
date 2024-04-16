package survivalblock.drippingparticle.common;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import survivalblock.drippingparticle.common.init.ModParticles;

public class DrippingParticle implements ModInitializer {
	public static final String MOD_ID = "dripping_particle";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModParticles.init();
	}

	public static Identifier id(String value){
		return new Identifier(MOD_ID, value);
	}
}