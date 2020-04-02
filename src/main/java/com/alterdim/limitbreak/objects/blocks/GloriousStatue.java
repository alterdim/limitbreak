package com.alterdim.limitbreak.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class GloriousStatue extends Block
{
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private boolean touched;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
			Block.makeCuboidShape(7, 9, 7, 9, 10, 9),
			Block.makeCuboidShape(7, 2, 7, 9, 6, 9),
			Block.makeCuboidShape(9, 1, 7, 11, 3, 9),
			Block.makeCuboidShape(7, 6, 7, 9, 9, 9),
			Block.makeCuboidShape(5, 1, 7, 7, 3, 9)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
			Block.makeCuboidShape(7, 1, 9, 9, 3, 11),
			Block.makeCuboidShape(7, 2, 7, 9, 6, 9),
			Block.makeCuboidShape(7, 6, 7, 9, 9, 9),
			Block.makeCuboidShape(7, 9, 7, 9, 10, 9),
			Block.makeCuboidShape(7, 1, 5, 9, 3, 7)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public GloriousStatue(Properties properties) 
	{
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(state.get(FACING))
		{
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_N;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_E;
		default:
			return SHAPE_N;
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		this.touched = false;
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) 
	{
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) 
	{
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) 
	{
		builder.add(FACING);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult p_225533_6_) 
	{
		if (!this.touched)
		{
			worldIn.playSound(player, pos, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.HOSTILE, 1, 1);
			worldIn.destroyBlock(pos, false);
			this.touched = true;
		}
		
		return ActionResultType.SUCCESS;
	}

}
