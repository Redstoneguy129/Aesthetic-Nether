package me.cameronwhyte.mods.aestheticnether.common.objects.items;

import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ANItems {

    public static List<Item> ITEMS = new ArrayList<Item>();

    public static Item register(Item item, String name) {
        item.setRegistryName(new ResourceLocation(AestheticNether.MODID, name));
        ITEMS.add(item);
        return item;
    }

}
