package spectraal.ores.to.the.nether.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import spectraal.ores.to.the.nether.OresToTheNether;

public class OresGen {
	public static final RegistryKey<PlacedFeature> ORE_NETHER_DIAMOND = registerOre("ore_nether_diamond");
	public static final RegistryKey<PlacedFeature> ORE_NETHER_EMERALD = registerOre("ore_nether_emerald");
	public static final RegistryKey<PlacedFeature> ORE_NETHER_IRON = registerOre("ore_nether_iron");

	private static RegistryKey<PlacedFeature> registerOre(String name){
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(OresToTheNether.MOD_ID,name));
	}
	
	public static void init() {
		OresToTheNether.LOGGER.info(String.format("[%s] Altering world gen",OresToTheNether.MOD_ID));
		
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_NETHER_DIAMOND);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_NETHER_EMERALD);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_NETHER_IRON);
	}
}
