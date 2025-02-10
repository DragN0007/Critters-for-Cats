package com.dragn0007.preycritters.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BugLog extends Block {
    public static final VoxelShape AABB = Shapes.or(Block.box(5, 0, 0, 11, 6, 16));

    public BugLog() {
        super (Properties.copy(Blocks.OAK_PLANKS).strength(0.2f, 0.2f).noOcclusion());
    }

    public VoxelShape getShape(BlockState p_153474_, BlockGetter p_153475_, BlockPos p_153476_, CollisionContext p_153477_) {
        return AABB;
    }

    public boolean mayPlaceOn(BlockState blockState, BlockGetter p_51043_, BlockPos p_51044_) {
        return !blockState.is(Blocks.WATER);
    }
}
