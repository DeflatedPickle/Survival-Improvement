package com.deflatedpickle.survivalimprovement.events

import java.util.Random

import net.minecraft.init.{Blocks, Items}
import net.minecraft.item.ItemStack
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class ForgeEventHandler {
  private val random = new Random()

  @SubscribeEvent
  def onHarvestDropsEvent(event: HarvestDropsEvent): Unit = {
    if (event.getState.getBlock == Blocks.MELON_BLOCK) {
      val mainHand = event.getHarvester.getHeldItemMainhand

      if (mainHand.isEmpty || mainHand.getItem.getToolClasses(mainHand).contains("shovel")) {
        event.getDrops.clear()
        event.getDrops.add(new ItemStack(Blocks.MELON_BLOCK))
      }
    }
    else if (event.getState.getBlock == Blocks.LEAVES) {
      if (random.nextInt(4) == 1) {
        event.getDrops.add(new ItemStack(Items.STICK, random.nextInt(4)))
      }
    }
  }
}
