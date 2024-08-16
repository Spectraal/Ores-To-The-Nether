package spectraal.ores.to.the.nether.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import spectraal.ores.to.the.nether.OresToTheNether;

public class ModBlocks {
	/* Add new blocks here and register them in ModItems to select the group */
    public static final Block NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE), UniformIntProvider.create(0,1)));

    public static final Block NETHER_EMERALD_ORE = registerBlock("nether_emerald_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE), UniformIntProvider.create(0,1)));

    public static final Block NETHER_IRON_ORE = registerBlock("nether_iron_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE), UniformIntProvider.create(0,1)));
/*
 * HELPERS
 */
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(OresToTheNether.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(OresToTheNether.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
    	OresToTheNether.LOGGER.info(String.format("[%s] Registering blocks",OresToTheNether.MOD_ID));
    }
}