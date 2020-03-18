package me.cameronwhyte.mods.aestheticnether;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("aesthetic-nether")
public class AestheticNether {

    public static final String MODID = "aesthetic-nether";
    private static final Logger LOGGER = LogManager.getLogger();

    public AestheticNether() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info(MODID+": is setup!");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info(MODID+": client is setup!");
    }

}
