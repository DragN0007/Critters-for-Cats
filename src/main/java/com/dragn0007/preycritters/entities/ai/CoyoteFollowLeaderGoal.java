package com.dragn0007.preycritters.entities.ai;

import com.dragn0007.preycritters.entities.coyote.Coyote;
import com.mojang.datafixers.DataFixUtils;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class CoyoteFollowLeaderGoal extends Goal {
   public static final int INTERVAL_TICKS = 200;
   public final Coyote mob;
   public int timeToRecalcPath;
   public int nextStartTick;

   public CoyoteFollowLeaderGoal(Coyote coyote) {
      this.mob = coyote;
      this.nextStartTick = this.nextStartTick(coyote);
   }

   public int nextStartTick(Coyote coyote) {
      return reducedTickDelay(200 + coyote.getRandom().nextInt(200) % 20);
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
         Predicate<Coyote> predicate = (follower) -> {
            return follower.canBeFollowed() || !follower.isFollower();
         };
         List<? extends Coyote> list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), this.mob.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), predicate);
         Coyote coyote = DataFixUtils.orElse(list.stream().filter(Coyote::canBeFollowed).findAny(), this.mob);
         coyote.addFollowers(list.stream().filter((coyote1) -> {
            return !coyote1.isFollower();
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