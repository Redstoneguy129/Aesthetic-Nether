package me.cameronwhyte.mods.aestheticnether.common.objects;

import me.cameronwhyte.mods.aestheticnether.common.objects.blocks.ANBlocks;
import me.cameronwhyte.mods.aestheticnether.common.objects.entities.ANEntities;
import me.cameronwhyte.mods.aestheticnether.common.objects.items.ANItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterObjects {

    @SubscribeEvent
    public static void onItemRegister(final RegistryEvent.Register<Item> event) {
        for(Item item : ANItems.ITEMS) {
            event.getRegistry().register(item);
        }
    }

    @SubscribeEvent
    public static void onBlockRegister(final RegistryEvent.Register<Block> event) {
        for(Block block : ANBlocks.BLOCKS) {
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        for(EntityType<SpiderEntity> entity : ANEntities.ENTITIES) {
            event.getRegistry().register(entity);
        }

        Biomes.NETHER.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ANEntities.HEATSCAR_SPIDER, 20, 1, 1));
        Biomes.NETHER.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ANEntities.BABY_HEATSCAR_SPIDER, 10, 1, 4));

        EntitySpawnPlacementRegistry.register(ANEntities.HEATSCAR_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RegisterObjects::monsterCondition);
        EntitySpawnPlacementRegistry.register(ANEntities.BABY_HEATSCAR_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RegisterObjects::monsterCondition);
    }

    private static boolean monsterCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return (world.getDifficulty() != Difficulty.PEACEFUL) && mobCondition(entityType, world, spawnReason, pos, random);
    }

    private static boolean mobCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        BlockPos blockpos = pos.down();
        return spawnReason == SpawnReason.SPAWNER || (world.getWorld().getBlockState(blockpos).canEntitySpawn(world, blockpos, entityType) && !(world.getBlockState(blockpos).getBlock().equals(Blocks.AIR) || world.getBlockState(blockpos).getMaterial().equals(Material.LAVA)));
    }

}
