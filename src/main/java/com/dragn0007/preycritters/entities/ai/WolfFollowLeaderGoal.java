package com.dragn0007.preycritters.entities.ai;

import com.dragn0007.preycritters.entities.wolf.VWolf;
import com.mojang.datafixers.DataFixUtils;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class WolfFollowLeaderGoal extends Goal {
   public static final int INTERVAL_TICKS = 200;
   public final VWolf mob;
   public int timeToRecalcPath;
   public int nextStartTick;

   public WolfFollowLeaderGoal(VWolf wolf) {
      this.mob = wolf;
      this.nextStartTick = this.nextStartTick(wolf);
   }

   public int nextStartTick(VWolf wolf) {
      return reducedTickDelay(200 + wolf.getRandom().nextInt(200) % 20);
   }

   public boolean canUse() {
      if (this.mob.hasFollowers()) {
         return false;
      } else if (this.mob.isFollower()) {
         return true;
      } else if (this.nextStartTick > 0) {
         --this.nextStartTick;
         return false;
      } else {
         this.nextStartTick = this.nextStartTick(this.mob);
         Predicate<VWolf> predicate = (follower) -> {
            return follower.canBeFollowed() || !follower.isFollower();
         };
         List<? extends VWolf> list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), this.mob.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), predicate);
         VWolf wolf = DataFixUtils.orElse(list.stream().filter(VWolf::canBeFollowed).findAny(), this.mob);
         wolf.addFollowers(list.stream().filter((wolf1) -> {
            return !wolf1.isFollower();
         }));
         return this.mob.isFollower();
      }
   }

   public boolean canContinueToUse() {
      return this.mob.isFollower() && this.mob.inRangeOfLeader();
   }

   public void start() {
      this.timeToRecalcPath = 0;
   }

   public void stop() {
      this.mob.stopFollowing();
   }

   public void tick() {
      if (--this.timeToRecalcPath <= 0) {
         this.timeToRecalcPath = this.adjustedTickDelay(10);
         this.mob.pathToLeader();
      }
   }
}