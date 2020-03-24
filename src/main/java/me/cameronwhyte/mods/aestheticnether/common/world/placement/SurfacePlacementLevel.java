package me.cameronwhyte.mods.aestheticnether.common.world.placement;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;

public class SurfacePlacementLevel implements PlacementLevel {
    public static final PlacementLevel INSTANCE = new SurfacePlacementLevel();

    private SurfacePlacementLevel() {
    }

    @Override
    public BlockPos getSurfacePos(IWorld world, Heightmap.Type type, BlockPos pos) {
        return world.getHeight(type, pos);
    }

    @Override
    public boolean containsY(IWorld world, int y) {
        return true;
    }
}