package me.cameronwhyte.mods.aestheticnether.client.entities.heatscar_spider;

import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import me.cameronwhyte.mods.aestheticnether.common.objects.entities.BabyHeatscarSpider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderBabyHeatscarSpider extends SpiderRenderer<BabyHeatscarSpider> {

    public static final ResourceLocation heatscartexture = new ResourceLocation(AestheticNether.MODID, "textures/entity/heatscarspider.png");

    public RenderBabyHeatscarSpider(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    @Override
    protected ResourceLocation getEntityTexture(BabyHeatscarSpider p_110775_1_) {
        return heatscartexture;
    }

    @Override
    protected void preRenderCallback(BabyHeatscarSpider p_77041_1_, float p_77041_2_) {
        GL11.glScalef(0.85f, 0.85f, 0.85f);
        super.preRenderCallback(p_77041_1_, p_77041_2_);
    }

    public static class RenderFactory implements IRenderFactory<BabyHeatscarSpider> {
        @Override
        public EntityRenderer<? super BabyHeatscarSpider> createRenderFor(EntityRendererManager manager) {
            return new RenderBabyHeatscarSpider(manager);
        }
    }

}
