package me.cameronwhyte.mods.aestheticnether.client.entities.heatscar_spider;

import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import me.cameronwhyte.mods.aestheticnether.common.objects.entities.HeatscarSpider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderHeatscarSpider extends SpiderRenderer<HeatscarSpider> {

    public static final ResourceLocation heatscartexture = new ResourceLocation(AestheticNether.MODID, "textures/entity/heatscarspider.png");

    public RenderHeatscarSpider(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    @Override
    protected ResourceLocation getEntityTexture(HeatscarSpider p_110775_1_) {
        return heatscartexture;
    }

    @Override
    protected void preRenderCallback(HeatscarSpider p_77041_1_, float p_77041_2_) {
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        super.preRenderCallback(p_77041_1_, p_77041_2_);
    }

    public static class RenderFactory implements IRenderFactory<HeatscarSpider> {
        @Override
        public EntityRenderer<? super HeatscarSpider> createRenderFor(EntityRendererManager manager) {
            return new RenderHeatscarSpider(manager);
        }
    }


}
