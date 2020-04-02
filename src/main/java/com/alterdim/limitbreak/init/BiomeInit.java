package com.alterdim.limitbreak.init;

import com.alterdim.limitbreak.LimitBreak;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit 
{
	
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, LimitBreak.MOD_ID);
	
	public static final RegistryObject<Biome> ASARI_LANDS = BIOMES.register("asari_lands", () ->  {
		
		new GayLands();
		
	});
}
