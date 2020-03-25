package me.cameronwhyte.mods.aestheticnether.common.objects;

import me.cameronwhyte.mods.aestheticnether.client.entities.heatscar_spider.RenderBabyHeatscarSpider;
import me.cameronwhyte.mods.aestheticnether.client.entities.heatscar_spider.RenderHeatscarSpider;
import me.cameronwhyte.mods.aestheticnether.common.objects.entities.BabyHeatscarSpider;
import me.cameronwhyte.mods.aestheticnether.common.objects.entities.HeatscarSpider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RegisterRenders {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(HeatscarSpider.class, new RenderHeatscarSpider.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(BabyHeatscarSpider.class, new RenderBabyHeatscarSpider.RenderFactory());
    }

}
