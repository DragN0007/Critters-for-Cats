package com.dragn0007.preycritters.items.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.Random;

public class MouseBileItem extends Item {

   public MouseBileItem(Properties properties) {
      super(properties);
   }

   @Override
   public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
      if (!level.isClientSide) {
         livingEntity.removeAllEffects();
         int i = level.getRandom().nextInt(4);
         if (i <= 2) {
            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false);
            livingEntity.addEffect(effectInstance);
         }
      }

      if (livingEntity instanceof ServerPlayer serverPlayer) {
         CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
         serverPlayer.awardStat(Stats.ITEM_USED.get(this));
      }

      if (livingEntity instanceof Player && !((Player) livingEntity).getAbilities().instabuild) {
         stack.shrink(1);
      }

      return stack.isEmpty() ? new ItemStack(Items.AIR) : stack;
   }

   public int getUseDuration(ItemStack p_42933_) {
      return 32;
   }

   public UseAnim getUseAnimation(ItemStack p_42931_) {
      return UseAnim.BRUSH;
   }

   public InteractionResultHolder<ItemStack> use(Level p_42927_, Player p_42928_, InteractionHand p_42929_) {
      return ItemUtils.startUsingInstantly(p_42927_, p_42928_, p_42929_);
   }
}