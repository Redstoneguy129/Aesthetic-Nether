package me.cameronwhyte.mods.aestheticnether.common.objects.blocks;

import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import me.cameronwhyte.mods.aestheticnether.common.objects.items.ANItems;
import me.cameronwhyte.mods.aestheticnether.common.objects.trees.BloodwoodTree;
import me.cameronwhyte.mods.aestheticnether.common.objects.types.ANSapling;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ANBlocks {

    public static List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLOODWOOD = register(new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "bloodwood_log");
    public static final Block BLOODLEAVES = register(new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)), "bloodwood_leaves");
    public static final Block BLOODSAPLING = register(new ANSapling(new BloodwoodTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).tickRandomly().sound(SoundType.PLANT)), "bloodwood_sapling");

    public static Block register(Block block, String name) {
        block.setRegistryName(new ResourceLocation(AestheticNether.MODID, name));
        BLOCKS.add(block);
        ANItems.ITEMS.add(new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(new ResourceLocation(AestheticNether.MODID, name)));
        return block;
    }

}
