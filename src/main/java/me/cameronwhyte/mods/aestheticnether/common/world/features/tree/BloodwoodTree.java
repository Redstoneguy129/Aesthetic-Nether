package me.cameronwhyte.mods.aestheticnether.common.world.features.tree;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class BloodwoodTree extends Tree {
    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return new BloodwoodTreeFeature(NoFeatureConfig::deserialize, true, false);
    }
}
