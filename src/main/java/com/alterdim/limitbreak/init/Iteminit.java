package com.alterdim.limitbreak.init;

import com.alterdim.limitbreak.LimitBreak;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = LimitBreak.MOD_ID, bus = Bus.MOD)
@ObjectHolder(LimitBreak.MOD_ID)
public class Iteminit 
{
	@ObjectHolder(LimitBreak.MOD_ID + "gayming_ingot")
	public static Item gayming_ingot = null;
	
	@SubscribeEvent
	public static void registerItem(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("Gayming Ingot"));
	}

}
