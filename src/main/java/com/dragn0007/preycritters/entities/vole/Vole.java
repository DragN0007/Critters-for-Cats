package com.dragn0007.preycritters.entities.vole;

import com.dragn0007.preycritters.blocks.custom.VoleBurrow;
import com.dragn0007.preycritters.entities.coyote.Coyote;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

public class Vole extends Animal implements GeoEntity {

	public Vole(EntityType<? extends Vole> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 3.5D)
				.add(Attributes.MOVEMENT_SPEED, 0.20F);
	}

	public void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 2.0F));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

		this.goalSelector.addGoal(2, new Vole.VoleBurrowBackGoal(this));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Wolf.class, 15.0F, 1.8F, 1.8F));
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Fox.class, 15.0F, 1.8F, 1.8F));
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Cat.class, 15.0F, 1.8F, 1.8F));
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Ocelot.class, 15.0F, 1.8F, 1.8F));
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Villager.class, 15.0F, 1.8F, 1.8F));
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Coyote.class, 15.0F, 1.8F, 1.8F));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 15.0F, 2.0F, 2.0F, entity ->
				(entity instanceof Player && !entity.isCrouching())
		));
	}

	@Override
	public float getStepHeight() {
		return 1.0F;
	}

	public final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

	public <T extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<T> tAnimationState) {
		double currentSpeed = this.getDeltaMovement().lengthSqr();
		double speedThreshold = 0.01;

		AnimationController<T> controller = tAnimationState.getController();

		if (tAnimationState.isMoving()) {
			if (currentSpeed > speedThreshold) {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(4.0);
			} else {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(2.0);
			}
		} else {
			controller.setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
			controller.setAnimationSpeed(0.9);
		}

		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "controller", 2, this::predicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.geoCache;
	}

	public float getWalkTargetValue(BlockPos pos, LevelReader levelReader) {
		return VoleBurrow.isCompatibleBurrow(levelReader.getBlockState(pos.below())) ? 10.0F : super.getWalkTargetValue(pos, levelReader);
	}

	static class VoleBurrowBackGoal extends RandomStrollGoal {
		@Nullable
		public Direction selectedDirection;
		public boolean goBackToBurrow;

		public VoleBurrowBackGoal(Vole vole) {
			super(vole, 1.0D, 10);
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			if (this.mob.getTarget() != null) {
				return false;
			} else if (!this.mob.getNavigation().isDone()) {
				return false;
			} else {
				RandomSource randomsource = this.mob.getRandom();
				if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.mob.level(), this.mob) && randomsource.nextInt(reducedTickDelay(10)) == 0) {
					this.selectedDirection = Direction.getRandom(randomsource);
					BlockPos blockpos = BlockPos.containing(this.mob.getX(), this.mob.getY() + 0.5D, this.mob.getZ()).relative(this.selectedDirection);
					BlockState blockstate = this.mob.level().getBlockState(blockpos);
					if (InfestedBlock.isCompatibleHostBlock(blockstate)) {
						this.goBackToBurrow = true;
						return true;
					}
				}

				this.goBackToBurrow = false;
				return super.canUse();
			}
		}

		public boolean canContinueToUse() {
			return !this.goBackToBurrow && super.canContinueToUse();
		}

		public void start() {
			if (!this.goBackToBurrow) {
				super.start();
			} else {
				LevelAccessor levelaccessor = this.mob.level();
				BlockPos blockpos = BlockPos.containing(this.mob.getX(), this.mob.getY() + 0.5D, this.mob.getZ()).relative(this.selectedDirection);
				BlockState blockstate = levelaccessor.getBlockState(blockpos);
				if (VoleBurrow.isCompatibleBurrow(blockstate)) {
					levelaccessor.setBlock(blockpos, VoleBurrow.infestedStateByHost(blockstate), 3);
					this.mob.spawnAnim();
					this.mob.discard();
				}

			}
		}
	}

	public SoundEvent getAmbientSound() {
		super.getAmbientSound();
		return SoundEvents.RABBIT_AMBIENT;
	}

	public SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.RABBIT_DEATH;
	}

	public SoundEvent getHurtSound(DamageSource p_30720_) {
		super.getHurtSound(p_30720_);
		return SoundEvents.RABBIT_HURT;
	}

	public void playStepSound(BlockPos p_28254_, BlockState p_28255_) {
		this.playSound(SoundEvents.RABBIT_JUMP, 0.15F, 1.0F);
	}

	// Generates the base texture
	public ResourceLocation getTextureLocation() {
		return VoleModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Vole.class, EntityDataSerializers.INT);

	public int getVariant() {
		return this.entityData.get(VARIANT);
	}

	public void setVariant(int variant) {
		this.entityData.set(VARIANT, variant);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		if (tag.contains("Variant")) {
			setVariant(tag.getInt("Variant"));
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Variant", getVariant());
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance instance, MobSpawnType spawnType, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
		if (data == null) {
			data = new AgeableMobGroupData(0.2F);
		}

		if (this.level().getBiome(this.blockPosition()).is(Tags.Biomes.IS_SNOWY) || this.level().getBiome(this.blockPosition()).is(Tags.Biomes.IS_CONIFEROUS)) {
			this.setVariant(4);
		} else {
			Random random = new Random();
			setVariant(random.nextInt(VoleModel.Variant.values().length));
		}


		return super.finalizeSpawn(serverLevelAccessor, instance, spawnType, data, tag);
	}

	@org.jetbrains.annotations.Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VARIANT, 0);
	}

}
