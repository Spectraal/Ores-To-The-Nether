package spectraal.ores.to.the.nether;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import spectraal.ores.to.the.nether.block.ModBlocks;
import spectraal.ores.to.the.nether.item.ModItems;
import spectraal.ores.to.the.nether.world.gen.OresGen;

public class OresToTheNether implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID =  "ores-to-the-nether";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		try {
			ModItems.registerModItems();
			ModBlocks.registerModBlocks();
			OresGen.init();
		} catch (Exception e) {
			LOGGER.error(String.format("[%s] %s", MOD_ID, e.toString()));
		}
	}
}