package com.alterdim.limitbreak.objects.items;

import java.util.List;

import com.alterdim.limitbreak.util.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class MalevolentEye extends Item
{

	public MalevolentEye(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		if (KeyboardHelper.isHoldingShift())
		{
			tooltip.add(new StringTextComponent("Test"));
		}
		else
		{
			tooltip.add(new StringTextComponent("Hold SHIFT for more information."));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		playerIn.attackEntityFrom(DamageSource.FALL, 4);
		playerIn.getHeldItemMainhand().damageItem(1, playerIn, null);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean isDamageable() {
		return true;
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		this.setDamage(stack, 100);
		super.onCreated(stack, worldIn, playerIn);
	}
}
