package com.dragn0007.preycritters.blocks.custom;

import com.dragn0007.preycritters.entities.EntityTypes;
import com.dragn0007.preycritters.entities.vole.Vole;
import com.dragn0007.preycritters.entities.vole.VoleModel;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class VoleBurrow extends BurrowRotator {

    public static final VoxelShape NORTH = Stream.of(
            Block.box(0, 0, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape EAST = Stream.of(
            Block.box(0, 0, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape SOUTH = Stream.of(
            Block.box(0, 0, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape WEST = Stream.of(
            Block.box(0, 0, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    private static final Map<Block, Block> BLOCK_BY_BURROW = Maps.newIdentityHashMap();
    private static final Map<BlockState, BlockState> HOST_TO_BURROW = Maps.newIdentityHashMap();

    public static boolean isCompatibleBurrow(BlockState state) {
        return BLOCK_BY_BURROW.containsKey(state.getBlock());
    }

    public VoleBurrow(Block block) {
        super(NORTH, EAST, SOUTH, WEST);
        BLOCK_BY_BURROW.put(block, this);
    }

    public boolean mayPlaceOn(BlockState blockState, BlockGetter p_51043_, BlockPos p_51044_) {
        return !blockState.is(Blocks.WATER);
    }

    public void spawnVole(ServerLevel level, BlockPos pos) {
        Random random = new Random();
        int i = random.nextInt(3); //33% chance of vole spawn when broken
        Vole vole = EntityTypes.VOLE_ENTITY.get().create(level);
        if (vole != null) {
            if (i == 0) {
                vole.moveTo((double) pos.getX() + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D, 0.0F, 0.0F);
                vole.setVariant(random.nextInt(VoleModel.Variant.values().length));
                level.addFreshEntity(vole);
                level.addParticle(ParticleTypes.POOF, vole.getRandomX(0.6D), vole.getRandomY(), vole.getRandomZ(0.6D), 0.7D, 0.7D, 0.7D);
                vole.playSound(SoundEvents.BEEHIVE_EXIT, 0.5f, 1f);
                vole.level().broadcastEntityEvent(vole, (byte)20);
            } else {
                return; //don't do anything if the int doesn't match 0
            }
        }

    }

    @Override
    public void spawnAfterBreak(BlockState state, ServerLevel serverLevel, BlockPos pos, ItemStack stack, boolean b) {
        super.spawnAfterBreak(state, serverLevel, pos, stack, b);
        if (serverLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            this.spawnVole(serverLevel, pos);
        }

    }

    public static BlockState infestedStateByHost(BlockState state) {
        return getNewStateWithProperties(HOST_TO_BURROW, state, () -> {
            return BLOCK_BY_BURROW.get(state.getBlock()).defaultBlockState();
        });
    }

    private static BlockState getNewStateWithProperties(Map<BlockState, BlockState> stateMap, BlockState state, Supplier<BlockState> supplier) {
        return stateMap.computeIfAbsent(state, (p_153429_) -> {
            BlockState blockstate = supplier.get();

            for(Property property : p_153429_.getProperties()) {
                blockstate = blockstate.hasProperty(property) ? blockstate.setValue(property, p_153429_.getValue(property)) : blockstate;
            }

            return blockstate;
        });
    }
}
