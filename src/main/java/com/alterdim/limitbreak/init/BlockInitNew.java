package com.alterdim.limitbreak.init;

import com.alterdim.limitbreak.LimitBreak;
import com.alterdim.limitbreak.objects.blocks.GloriousStatue;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew 
{
public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, LimitBreak.MOD_ID);
	
	public static final RegistryObject<Block> GAYMING_BLOCK = BLOCKS.register("gayming_block", () -> 
	new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5, 6).harvestLevel(3).harvestTool(ToolType.PICKAXE)
			.sound(SoundType.METAL)));
	public static final RegistryObject<Block> GLORIOUS_STATUE = BLOCKS.register("glorious_statue", () -> 
	new GloriousStatue(Block.Properties.create(Material.GLASS).hardnessAndResistance(3).harvestLevel(0)
			.sound(SoundType.GLASS)));

}
