package me.cameronwhyte.mods.aestheticnether.common.objects.items;

import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import me.cameronwhyte.mods.aestheticnether.common.objects.entities.ANEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ANItems {

    public static List<Item> ITEMS = new ArrayList<Item>();

    public static final Item BLOODWOODSTICK = register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)), "bloodwood_stick");
    public static final Item FLAMESTRING = register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)), "flame_string");
    public static final Item HEATSCARSPIDER_SPAWN_EGG = register(new SpawnEggItem(ANEntities.HEATSCAR_SPIDER, 0xE64D10, 0x57B1BD, (new Item.Properties()).group(ItemGroup.MISC)), "heatscarspider_spawn_egg");
    public static final Item BLOODWOODBOW = register(new BowItem(new Item.Properties().group(ItemGroup.COMBAT).maxDamage(1501)), "bloodwood_bow");

    public static Item register(Item item, String name) {
        item.setRegistryName(new ResourceLocation(AestheticNether.MODID, name));
        ITEMS.add(item);
        return item;
    }

}
