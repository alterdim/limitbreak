package com.alterdim.limitbreak.init;

import com.alterdim.limitbreak.LimitBreak;
import com.alterdim.limitbreak.world.biomes.AsariLands;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit 
{
	
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, LimitBreak.MOD_ID);
	
	public static final RegistryObject<Biome> ASARI_LANDS = BIOMES.register("asari_lands", () -> 
	new AsariLands(new Biome.Builder().precipitation(RainType.NONE).temperature(0.5f).waterColor(14215935)
	.waterFogColor(14215936).downfall(0.5f).depth(0.15f).parent(null).scale(1.5f)
	.surfaceBuilder(SurfaceBuilder.MOUNTAIN, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), 
	Blocks.STONE.getDefaultState(), Blocks.BEDROCK.getDefaultState())).category(Category.PLAINS)));
	
	public static void registerBiomes()
	{
		registerBiome(ASARI_LANDS.get(), Type.PLAINS, Type.OVERWORLD);
	}
	
	private static void registerBiome(Biome biome, Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
}
