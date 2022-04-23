package net.saltayjek004.stepsmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.saltayjek004.stepsmod.StepsMod;
import net.saltayjek004.stepsmod.block.custom.ModStepsBlock;
import net.saltayjek004.stepsmod.item.ModItemGroup;

public class ModBlocks {

    public static final Block OAK_STEPS = registerBlock("oak_steps",
        new ModStepsBlock(Blocks.OAK_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).nonOpaque()), ModItemGroup.STEPS);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StepsMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(StepsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        StepsMod.LOGGER.info("Registering ModBlocks for "+ StepsMod.MOD_ID);
    }
}
