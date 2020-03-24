package me.cameronwhyte.mods.aestheticnether.common.objects.entities;

import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class ANEntities {

    public static List<EntityType<?>> ENTITIES = new ArrayList<EntityType<?>>();

    public static EntityType<?> HEATSCAR_SPIDER = register(EntityType.Builder.create(HeatscarSpider::new, EntityClassification.MONSTER).size(1.4F, 0.9F).immuneToFire().build(AestheticNether.MODID+":heatscar_spider").setRegistryName(AestheticNether.MODID, "heatscar_spider"));

    public static EntityType<?> register(EntityType<?> entity) {
        ENTITIES.add(entity);
        return entity;
    }

}
