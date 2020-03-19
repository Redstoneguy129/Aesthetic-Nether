package me.cameronwhyte.mods.aestheticnether.common.objects;

import me.cameronwhyte.mods.aestheticnether.common.objects.blocks.ANBlocks;
import me.cameronwhyte.mods.aestheticnether.common.objects.items.ANItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterObjects {

    @SubscribeEvent
    public static void onItemRegister(final RegistryEvent.Register<Item> event) {
        for(Item item : ANItems.ITEMS) {
            event.getRegistry().register(item);
        }
    }

    @SubscribeEvent
    public static void onBlockRegister(final RegistryEvent.Register<Block> event) {
        for(Block block : ANBlocks.BLOCKS) {
            event.getRegistry().register(block);
        }
    }

}
