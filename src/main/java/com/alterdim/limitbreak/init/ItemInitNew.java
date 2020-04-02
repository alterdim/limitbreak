package com.alterdim.limitbreak.init;

import java.util.function.Supplier;

import com.alterdim.limitbreak.LimitBreak;
import com.alterdim.limitbreak.LimitBreak.LimitBreakItemGroup;
import com.alterdim.limitbreak.objects.items.MalevolentEye;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew 
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, LimitBreak.MOD_ID);
	
	public static final RegistryObject<Item> GAYMING_INGOT = ITEMS.register("gayming_ingot", () -> 
	new Item(new Item.Properties().group(LimitBreakItemGroup.instance)));
	public static final RegistryObject<Item> ULTRA_DIAMOND = ITEMS.register("ultra_diamond", () -> 
	new Item(new Item.Properties().group(LimitBreakItemGroup.instance)));
	public static final RegistryObject<Item> MALEVOLENT_EYE = ITEMS.register("malevolent_eye", () -> 
	new MalevolentEye(new Item.Properties().group(LimitBreakItemGroup.instance).maxDamage(5)));
	
	
	public static final RegistryObject<Item> GAYMING_PICKAXE = ITEMS.register("gayming_pickaxe", () -> new PickaxeItem(LimitBreakItemTier.GAYMING, 5, 1.2f, 
			new Item.Properties().group(LimitBreakItemGroup.instance)));
	public static final RegistryObject<Item> GAYMING_SWORD = ITEMS.register("gayming_sword", () -> new SwordItem(LimitBreakItemTier.GAYMING, 7, -2.0f, 
			new Item.Properties().group(LimitBreakItemGroup.instance)));
	public static final RegistryObject<Item> GAYMING_AXE = ITEMS.register("gayming_axe", () -> new AxeItem(LimitBreakItemTier.GAYMING, 9, 1.0f, 
			new Item.Properties().group(LimitBreakItemGroup.instance)));
	public static final RegistryObject<Item> GAYMING_SHOVEL = ITEMS.register("gayming_shovel", () -> new ShovelItem(LimitBreakItemTier.GAYMING, 5, 1f, 
			new Item.Properties().group(LimitBreakItemGroup.instance)));
	public static final RegistryObject<Item> GAYMING_HOE = ITEMS.register("gayming_hoe", () -> new HoeItem(LimitBreakItemTier.GAYMING, 1, 
			new Item.Properties().group(LimitBreakItemGroup.instance)));
	
	public static final RegistryObject<Item> GAYMING_HELMET = ITEMS.register("gayming_helmet", () -> new ArmorItem(LimitBreakMaterial.GAYMING, 
			EquipmentSlotType.HEAD, new Item.Properties().group(LimitBreakItemGroup.instance)));
	public static final RegistryObject<Item> GAYMING_CHESTPLATE = ITEMS.register("gayming_chestplate", () -> new ArmorItem(LimitBreakMaterial.GAYMING, 
			EquipmentSlotType.CHEST, new Item.Properties().group(LimitBreakItemGroup.instance)));
	public static final RegistryObject<Item> GAYMING_LEGGINGS = ITEMS.register("gayming_leggings", () -> new ArmorItem(LimitBreakMaterial.GAYMING, 
			EquipmentSlotType.LEGS, new Item.Properties().group(LimitBreakItemGroup.instance)));
	public static final RegistryObject<Item> GAYMING_BOOTS = ITEMS.register("gayming_boots", () -> new ArmorItem(LimitBreakMaterial.GAYMING, 
			EquipmentSlotType.FEET, new Item.Properties().group(LimitBreakItemGroup.instance)));
	
	public enum LimitBreakItemTier implements IItemTier
	{
		GAYMING(4, 2000, 13.0F, 17F, 25, () -> {
			return Ingredient.fromItems(ItemInitNew.gayming_ingot);
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
	
	public enum LimitBreakMaterial implements IArmorMaterial
	{
		GAYMING(LimitBreak.MOD_ID + ":gayming", 5, new int[] {7, 9, 11, 7}, 400, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.9F, () -> {
			return Ingredient.fromItems(ItemInit.gayming_ingot);
		});
		
		private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private LimitBreakMaterial(String name, int maxDamageFactor, 
				int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial)
		{
			this.name = name;
			this.maxDamageFactor = maxDamageFactor;
			this.damageReductionAmountArray = damageReductionAmountArray;
			this.enchantability = enchantability;
			this.soundEvent = soundEvent;
			this.toughness = toughness;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}
		

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()]*this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}
		
	}
}