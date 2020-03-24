package me.cameronwhyte.mods.aestheticnether.common.objects.types;

import me.cameronwhyte.mods.aestheticnether.common.RegUtil;
import me.cameronwhyte.mods.aestheticnether.common.world.placement.ChanceSurfacePlacement;
import me.cameronwhyte.mods.aestheticnether.common.world.placement.SurfacePlacementLevel;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.IForgeRegistry;

public class ANPlacements {

    public static final Placement<ChanceConfig> CHANCE_SURFACE = new ChanceSurfacePlacement(ChanceConfig::deserialize, SurfacePlacementLevel.INSTANCE);

    public static void registerPlacements(IForgeRegistry<Placement<?>> registry) {
        RegUtil.generic(registry).add("chance_surface", CHANCE_SURFACE);
    }

}
