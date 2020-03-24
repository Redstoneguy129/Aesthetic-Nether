package me.cameronwhyte.mods.aestheticnether.common.objects.types;

import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import me.cameronwhyte.mods.aestheticnether.common.RegUtil;
import me.cameronwhyte.mods.aestheticnether.common.world.features.structure.BloodwoodTreeStructure;
import me.cameronwhyte.mods.aestheticnether.common.world.features.structure.HangingVineStructure;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(AestheticNether.MODID)
public class ANFeatures {

    public static final Feature<NoFeatureConfig> BLOODWOODTREE = new BloodwoodTreeStructure(NoFeatureConfig::deserialize);
    public static final Feature<NoFeatureConfig> HANGINGVINES = new HangingVineStructure(NoFeatureConfig::deserialize);

    @SubscribeEvent
    public static void registerFeatures(IForgeRegistry<Feature<?>> event) {
        RegUtil.generic(event).add("bloodwood_tree", BLOODWOODTREE);
        RegUtil.generic(event).add("hanging_thornvines", HANGINGVINES);
    }

}
