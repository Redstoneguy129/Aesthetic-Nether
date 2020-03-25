package me.cameronwhyte.mods.aestheticnether.common.objects.entities;

import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SpiderEntity;

import java.util.ArrayList;
import java.util.List;

public class ANEntities {

    public static List<EntityType<SpiderEntity>> ENTITIES = new ArrayList<EntityType<SpiderEntity>>();

    public static EntityType<SpiderEntity> HEATSCAR_SPIDER = register((EntityType<SpiderEntity>) EntityType.Builder.create(HeatscarSpider::new, EntityClassification.MONSTER).size(1.4F, 0.9F).immuneToFire().build(AestheticNether.MODID+":heatscar_spider").setRegistryName(AestheticNether.MODID, "heatscar_spider"));
    public static EntityType<SpiderEntity> BABY_HEATSCAR_SPIDER = register((EntityType<SpiderEntity>) EntityType.Builder.create(BabyHeatscarSpider::new, EntityClassification.MONSTER).size(1.2F, 0.8F).immuneToFire().build(AestheticNether.MODID+":baby_heatscar_spider").setRegistryName(AestheticNether.MODID, "baby_heatscar_spider"));

    public static EntityType<SpiderEntity> register(EntityType<SpiderEntity> entity) {
        ENTITIES.add(entity);
        return entity;
    }

}
