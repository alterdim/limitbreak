package com.alterdim.limitbreak.objects.items;

import java.util.List;

import com.alterdim.limitbreak.util.helpers.KeyboardHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.Position;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
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
		if (!playerIn.getCooldownTracker().hasCooldown(this) && !worldIn.isRemote)
		{
			
			
			List<Entity> entities = worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, playerIn.getBoundingBox().expand(50000.0D, 50000.0D, 50000.0D));
			double xPos = playerIn.getPosX();
			double yPos = playerIn.getPosY();
			double zPos = playerIn.getPosZ();
			double launcherXPos = playerIn.getPosX();
			double launcherYPos = playerIn.getPosY();
			double launcherZPos = playerIn.getPosZ();
			boolean found = false;
			for (Entity passed : entities)
			{
				if (passed  instanceof PlayerEntity)
				{
					xPos = passed.getPosX();
					yPos = passed.getPosY();
					zPos = passed.getPosZ();
					found = true;
					break;
				}
			}
			if (!found)
			{
				playerIn.sendMessage(new StringTextComponent("No player found"));
			}
			playerIn.attackEntityFrom(DamageSource.FALL, 4);
			playerIn.getHeldItemMainhand().damageItem(1, playerIn, null);
			SnowballEntity ball = new SnowballEntity(worldIn, playerIn);
			ball.addVelocity((xPos - launcherXPos)/10, (yPos - launcherYPos)/10, (zPos - launcherZPos)/10);
			worldIn.addEntity(ball);
			playerIn.getCooldownTracker().setCooldown(this, 20);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean isDamageable() {
		return true;
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return 1;
	}
}
