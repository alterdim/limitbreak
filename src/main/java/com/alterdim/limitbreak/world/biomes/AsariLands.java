package com.alterdim.limitbreak.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class AsariLands extends Biome
{

	public AsariLands(Builder biomeBuilder) 
	{
		super(biomeBuilder);
		addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.COW, 20, 3, 6));
		DefaultBiomeFeatures.addOakTreesFlowersGrass(this);
		addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		DefaultBiomeFeatures.addOres(this);
		//BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(this, 10));
		
	}
	

}
