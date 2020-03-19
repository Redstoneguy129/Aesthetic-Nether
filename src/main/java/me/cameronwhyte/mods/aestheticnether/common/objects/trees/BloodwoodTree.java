package me.cameronwhyte.mods.aestheticnether.common.objects.trees;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.*;

import javax.annotation.Nullable;
import java.util.Random;

public class BloodwoodTree extends Tree {
    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return new BloodwoodTreeFeature(NoFeatureConfig::deserialize, true, false);
    }
}
