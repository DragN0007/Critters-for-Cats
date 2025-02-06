package com.dragn0007.preycritters.items.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class MouseBileItem extends Item {

   public MouseBileItem(Item.Properties p_42921_) {
      super(p_42921_);
   }

   public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
      if (!level.isClientSide) entity.curePotionEffects(stack);
      if (entity instanceof ServerPlayer serverplayer) {
         CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
         serverplayer.awardStat(Stats.ITEM_USED.get(this));
      }

      if (entity instanceof Player && !((Player)entity).getAbilities().instabuild) {
         stack.shrink(1);
      }

      return stack;
   }

   public int getUseDuration(ItemStack p_42933_) {
      return 32;
   }

   public UseAnim getUseAnimation(ItemStack p_42931_) {
      return UseAnim.DRINK;
   }

   public InteractionResultHolder<ItemStack> use(Level p_42927_, Player p_42928_, InteractionHand p_42929_) {
      return ItemUtils.startUsingInstantly(p_42927_, p_42928_, p_42929_);
   }
}