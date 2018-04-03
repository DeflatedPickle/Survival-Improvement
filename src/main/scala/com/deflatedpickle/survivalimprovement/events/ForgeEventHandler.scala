package com.deflatedpickle.survivalimprovement.events

import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class ForgeEventHandler {
  @SubscribeEvent
  def onHarvestDropsEvent(event: HarvestDropsEvent): Unit = {
    if (event.getState.getBlock == Blocks.MELON_BLOCK) {
      val mainHand = event.getHarvester.getHeldItemMainhand

      if (mainHand.isEmpty || mainHand.getItem.getToolClasses(mainHand).contains("shovel")) {
        event.getDrops.clear()
        event.getDrops.add(new ItemStack(Blocks.MELON_BLOCK))
      }
    }
  }
}
