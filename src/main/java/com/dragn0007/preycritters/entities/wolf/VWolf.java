package com.dragn0007.preycritters.entities.wolf;

import com.dragn0007.preycritters.entities.ai.WolfFollowLeaderGoal;
import com.dragn0007.preycritters.entities.coyote.Coyote;
import com.dragn0007.preycritters.entities.fox.VFox;
import com.dragn0007.preycritters.entities.frog.SmallFrog;
import com.dragn0007.preycritters.entities.mouse.Mouse;
import com.dragn0007.preycritters.entities.squirrel.Squirrel;
import com.dragn0007.preycritters.entities.vole.Vole;
import com.dragn0007.preycritters.util.CrittersForCatsCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
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
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class VWolf extends Animal implements GeoEntity {

	public VWolf(EntityType<? extends VWolf> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 100.0D)
				.add(Attributes.ATTACK_DAMAGE, 4.5D)
				.add(Attributes.MOVEMENT_SPEED, 0.18F)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0F);
	}

	public void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(1, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Llama.class, 15.0F, 1.8F, 1.8F));

		this.goalSelector.addGoal(1, new WolfPanicGoal(1.8D, this));
		this.goalSelector.addGoal(3, new WolfFollowLeaderGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Cat.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Sheep.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Goat.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Fox.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Chicken.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Rabbit.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mouse.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SmallFrog.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Squirrel.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Vole.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Coyote.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, VFox.class, false));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.8D, true));
	}

	public int regenHealthCounter = 0;

	public int particleCounter = 0;

	public void tick() {
		super.tick();
		if (this.hasFollowers() && this.level().random.nextInt(200) == 1) {
			List<? extends VWolf> list = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (list.size() <= 1) {
				this.packSize = 1;
			}
		}

		//if im in a group with other wolves, give me a strength buff
		if (this.hasFollowers() || this.isFollower()) {
			if (!this.hasStrengthEffect()) {
				this.applyStrengthEffect();
			}
		} else {
			if (this.hasStrengthEffect()) {
				this.removeStrengthEffect();
			}
		}

		//if im in a group with other wolves, regen a heart every 400 ticks as long as im hurt
		regenHealthCounter++;

		if (this.getHealth() < this.getMaxHealth() && regenHealthCounter >= 400 && this.isAlive() && (this.isFollower() || this.hasFollowers())) {
			this.setHealth(this.getHealth() + 2);
			regenHealthCounter = 0;
			this.level().addParticle(ParticleTypes.HEART, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.6D), 0.7D, 0.7D, 0.7D);
		}

		//if im a leader, give me absorption
		if (this.hasFollowers()) {
			if (!this.hasAbsorptionEffect()) {
				this.applyAbsorptionEffect();
			}
			if (!this.hasResistanceEffect()) {
				this.applyResistanceEffect();
			}
		} else {
			if (this.hasAbsorptionEffect()) {
				this.removeAbsorptionEffect();
			}
			if (this.hasResistanceEffect()) {
				this.removeResistanceEffect();
			}
		}

		particleCounter++;

		if (this.hasFollowers()) {
			this.level().addAlwaysVisibleParticle(ParticleTypes.SOUL, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.6D), 0.7D, 0.7D, 0.7D);
			particleCounter = 0;
		}

	}

	public void applyStrengthEffect() {
		MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1, false, false);
		this.addEffect(effectInstance);
	}
	public boolean hasStrengthEffect() {
		return this.hasEffect(MobEffects.DAMAGE_BOOST);
	}
	public void removeStrengthEffect() {
		this.removeEffect(MobEffects.DAMAGE_BOOST);
	}

	public void applyAbsorptionEffect() {
		MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.ABSORPTION, 200, 2, false, false);
		this.addEffect(effectInstance);
	}
	public boolean hasAbsorptionEffect() {
		return this.hasEffect(MobEffects.ABSORPTION);
	}
	public void removeAbsorptionEffect() {
		this.removeEffect(MobEffects.ABSORPTION);
	}

	public void applyResistanceEffect() {
		MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1, false, false);
		this.addEffect(effectInstance);
	}
	public boolean hasResistanceEffect() {
		return this.hasEffect(MobEffects.DAMAGE_RESISTANCE);
	}
	public void removeResistanceEffect() {
		this.removeEffect(MobEffects.DAMAGE_RESISTANCE);
	}

	public VWolf leader;
	public int packSize = 1;

	public boolean isFollower() {
		return this.leader != null && this.leader.isAlive();
	}

	public VWolf startFollowing(VWolf wolf) {
		this.leader = wolf;
		wolf.addFollower();
		return wolf;
	}

	public void stopFollowing() {
		this.leader.removeFollower();
		this.leader = null;
	}

	public void addFollower() {
		++this.packSize;
	}

	public void removeFollower() {
		--this.packSize;
	}

	public boolean canBeFollowed() {
		return this.hasFollowers() && this.packSize < this.getMaxHerdSize();
	}

	public int getMaxHerdSize() {
		return CrittersForCatsCommonConfig.MAX_WOLF_GROUP.get();
	}

	public boolean hasFollowers() {
		return this.packSize > 1;
	}

	public boolean inRangeOfLeader() {
		return this.distanceToSqr(this.leader) <= 121.0D;
	}

	public void pathToLeader() {
		if (this.isFollower()) {
			this.getNavigation().moveTo(this.leader, 1.0D);
		}

	}

	public void addFollowers(Stream<? extends VWolf> p_27534_) {
		p_27534_.limit((long)(this.getMaxHerdSize() - this.packSize)).filter((wolf) -> {
			return wolf != this;
		}).forEach((wolf) -> {
			wolf.startFollowing(this);
		});
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
				controller.setAnimation(RawAnimation.begin().then("run", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(2.4);
			} else {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(1.2);
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

	public SoundEvent getAmbientSound() {
		super.getAmbientSound();
		return SoundEvents.WOLF_AMBIENT;
	}

	public SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.WOLF_DEATH;
	}

	public SoundEvent getHurtSound(DamageSource p_30720_) {
		super.getHurtSound(p_30720_);
		return SoundEvents.WOLF_GROWL;
	}

	public void playStepSound(BlockPos p_28254_, BlockState p_28255_) {
		this.playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
	}

	// Generates the base texture
	public ResourceLocation getTextureLocation() {
		return VWolfModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(VWolf.class, EntityDataSerializers.INT);

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

		if (tag.contains("Panicking")) {
			this.setPanicking(tag.getBoolean("Panicking"));
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Variant", getVariant());
		tag.putBoolean("Panicking", this.getPanicking());
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance instance, MobSpawnType spawnType, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
		if (data == null) {
			data = new AgeableMobGroupData(0.2F);
		}
		Random random = new Random();
		setVariant(random.nextInt(VWolfModel.Variant.values().length));

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

	public boolean isPanicking = false;

	public boolean isPanicking() {
		return this.getHealth() < this.getMaxHealth() / 3 && this.isAlive() && !this.hasFollowers() && !this.isFollower();
	}

	public boolean getPanicking() {
		return this.isPanicking;
	}

	public void setPanicking(boolean panicking) {
		this.isPanicking = panicking;
	}

	//panic and run away if im at or under 33% health, unless im in a group
	class WolfPanicGoal extends PanicGoal {
		public WolfPanicGoal(double v, VWolf mob) {
			super(VWolf.this, v);
			this.mob = mob;
		}

		public final VWolf mob;

		public boolean shouldPanic() {
			return this.mob.isFreezing() || this.mob.isOnFire() || (this.mob.getHealth() < this.mob.getMaxHealth() / 3 && this.mob.isAlive() && !this.mob.hasFollowers() && !this.mob.isFollower());
		}
	}

}
