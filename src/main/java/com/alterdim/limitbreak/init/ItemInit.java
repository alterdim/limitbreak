package com.alterdim.limitbreak.init;

import java.util.function.Supplier;

import com.alterdim.limitbreak.LimitBreak;
import com.alterdim.limitbreak.LimitBreak.LimitBreakItemGroup;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = LimitBreak.MOD_ID, bus = Bus.MOD)
@ObjectHolder(LimitBreak.MOD_ID)
public class ItemInit 
{
	public static final Item gayming_ingot = null;
	
	public static final Item gayming_sword = null;
	public static final Item gayming_pickaxe = null;
	public static final Item gayming_shovel = null;
	public static final Item gayming_axe = null;
	public static final Item gayming_hoe = null;
	
	@SubscribeEvent
	public static void registerItem(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new Item(new Item.Properties().group(LimitBreakItemGroup.instance)).setRegistryName("gayming_ingot"));
		
		event.getRegistry().register(new SwordItem(LimitBreakItemTier.GAYMING, 7, 1.6f, 
				new Item.Properties().group(LimitBreakItemGroup.instance)).setRegistryName("gayming_sword"));
		
		event.getRegistry().register(new PickaxeItem(LimitBreakItemTier.GAYMING, 5, 1.2f, 
				new Item.Properties().group(LimitBreakItemGroup.instance)).setRegistryName("gayming_pickaxe"));
		
		event.getRegistry().register(new ShovelItem(LimitBreakItemTier.GAYMING, 5, 1f, 
				new Item.Properties().group(LimitBreakItemGroup.instance)).setRegistryName("gayming_shovel"));
		
		event.getRegistry().register(new AxeItem(LimitBreakItemTier.GAYMING, 9, 1.0f, 
				new Item.Properties().group(LimitBreakItemGroup.instance)).setRegistryName("gayming_axe"));
		
		event.getRegistry().register(new HoeItem(LimitBreakItemTier.GAYMING, 1, 
				new Item.Properties().group(LimitBreakItemGroup.instance)).setRegistryName("gayming_hoe"));
	}
	
	public enum LimitBreakItemTier implements IItemTier
	{
		@ObjectHolder(value = "limitbreak")
		GAYMING(4, 2000, 13.0F, 7.0F, 25, () -> {
			return Ingredient.fromItems(ItemInit.gayming_ingot);
		});
		
		private final int harvestLevel;
		private final int durability;
		private final float efficiency;
		private final float damage;
		private final int echantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private LimitBreakItemTier(int harvestLevel, int durability, float efficiency, float damage, int enchantability, Supplier<Ingredient> repairMaterial)
		{
			this.harvestLevel = harvestLevel;
			this.durability = durability;
			this.efficiency = efficiency;
			this.damage = damage;
			this.echantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
			
		}

		@Override
		public int getMaxUses() {
			return durability;
		}

		@Override
		public float getEfficiency() {
			return efficiency;
		}

		@Override
		public float getAttackDamage() {
			return damage;
		}

		@Override
		public int getHarvestLevel() {
			return harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return echantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return repairMaterial.getValue();
		}
		
	}

}
