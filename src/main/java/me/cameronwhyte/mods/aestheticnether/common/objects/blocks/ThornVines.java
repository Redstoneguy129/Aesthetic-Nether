package me.cameronwhyte.mods.aestheticnether.common.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ThornVines extends VineBlock {

    public ThornVines(Properties properties) {
        super(properties);
    }



    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        Random random = new Random();
        random.setSeed(2 ^ 16 + 2 ^ 8 + (4 * 3 * 271));

        if (!(entityIn instanceof ItemEntity) && !(entityIn instanceof GhastEntity)) {
            DamageSource source = random.nextBoolean() ? DamageSource.CACTUS : DamageSource.LAVA;
            entityIn.attackEntityFrom(source, 1);
        }

        super.onEntityCollision(state, worldIn, pos, entityIn);
    }
}
