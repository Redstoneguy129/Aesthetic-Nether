package me.cameronwhyte.mods.aestheticnether;

import me.cameronwhyte.mods.aestheticnether.common.objects.RegisterRenders;
import me.cameronwhyte.mods.aestheticnether.common.objects.types.ANFeatures;
import me.cameronwhyte.mods.aestheticnether.common.objects.types.ANPlacements;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("aesthetic-nether")
public class AestheticNether {

    public static final String MODID = "aesthetic-nether";
    public static final Logger LOGGER = LogManager.getLogger();

    public AestheticNether() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

        Biomes.NETHER.addFeature(
                GenerationStage.Decoration.UNDERGROUND_DECORATION,
                Biome.createDecoratedFeature(ANFeatures.BLOODWOODTREE,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.COUNT_RANGE, new CountRangeConfig(15, 0, 0, 128))
        );
        Biomes.NETHER.addFeature(
                GenerationStage.Decoration.UNDERGROUND_DECORATION,
                Biome.createDecoratedFeature(ANFeatures.HANGINGVINES,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.COUNT_RANGE, new CountRangeConfig(70, 0, 0, 128))
        );

        LOGGER.info(MODID+": is setup!");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RegisterRenders.registerEntityRenders();
        LOGGER.info(MODID+": client is setup!");
    }

}
