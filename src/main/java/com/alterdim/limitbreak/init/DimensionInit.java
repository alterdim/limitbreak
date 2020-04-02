package com.alterdim.limitbreak.init;

import com.alterdim.limitbreak.LimitBreak;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit 
{
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, LimitBreak.MOD_ID);
	
	public static final RegistryObject<ModDimension> ASARI_DIMENSION = MOD_DIMENSIONS.register("asari_dimension", () -> new AsariDimension());
}
