package spectraal.ores.to.the.nether.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import spectraal.ores.to.the.nether.OresToTheNether;
import spectraal.ores.to.the.nether.block.ModBlocks;

public class ModItems {
    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", new Item(new FabricItemSettings()));
    public static final Item EMERALD_NUGGET = registerItem("emerald_nugget", new Item(new FabricItemSettings()));
    
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Items.GOLD_NUGGET, DIAMOND_NUGGET);
        entries.addAfter(DIAMOND_NUGGET, EMERALD_NUGGET);
    }
    
    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries) {
    	entries.addAfter(Blocks.NETHER_GOLD_ORE, ModBlocks.NETHER_DIAMOND_ORE); //Block
    	entries.addAfter(ModBlocks.NETHER_DIAMOND_ORE, ModBlocks.NETHER_EMERALD_ORE); //Block
    	entries.addAfter(ModBlocks.NETHER_EMERALD_ORE, ModBlocks.NETHER_IRON_ORE); //Block
    }
    
/*
 * HELPERS
 */
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(OresToTheNether.MOD_ID, name), item);
    }

    public static void registerModItems() {
    	OresToTheNether.LOGGER.info(String.format("[%s] Registering items",OresToTheNether.MOD_ID));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalItemGroup);
    }
}