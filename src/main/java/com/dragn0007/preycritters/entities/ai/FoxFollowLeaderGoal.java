package com.dragn0007.preycritters.entities.ai;

import com.dragn0007.preycritters.entities.fox.VFox;
import com.mojang.datafixers.DataFixUtils;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class FoxFollowLeaderGoal extends Goal {
   public static final int INTERVAL_TICKS = 200;
   public final VFox mob;
   public int timeToRecalcPath;
   public int nextStartTick;

   public FoxFollowLeaderGoal(VFox fox) {
      this.mob = fox;
      this.nextStartTick = this.nextStartTick(fox);
   }

   public int nextStartTick(VFox fox) {
      return reducedTickDelay(200 + fox.getRandom().nextInt(200) % 20);
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
         Predicate<VFox> predicate = (follower) -> {
            return follower.canBeFollowed() || !follower.isFollower();
         };
         List<? extends VFox> list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), this.mob.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), predicate);
         VFox fox = DataFixUtils.orElse(list.stream().filter(VFox::canBeFollowed).findAny(), this.mob);
         fox.addFollowers(list.stream().filter((fox1) -> {
            return !fox1.isFollower();
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