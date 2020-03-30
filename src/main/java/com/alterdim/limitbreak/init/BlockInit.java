package com.alterdim.limitbreak.init;

import com.alterdim.limitbreak.LimitBreak;
import com.alterdim.limitbreak.LimitBreak.LimitBreakItemGroup;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@ObjectHolder(LimitBreak.MOD_ID)
@Mod.EventBusSubscriber(modid = LimitBreak.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block gayming_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new 
				Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).harvestLevel(3)
						.sound(SoundType.METAL)).setRegistryName("gayming_block"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(gayming_block, new Item.Properties().group(LimitBreakItemGroup.instance)).setRegistryName("gayming_block"));
	}
}
