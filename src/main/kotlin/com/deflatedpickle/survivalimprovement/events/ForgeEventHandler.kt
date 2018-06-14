package com.deflatedpickle.survivalimprovement.events

import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import java.util.*

class ForgeEventHandler {
    private val random = Random()

    @SubscribeEvent
    fun onHarvestDropsEvent(event: HarvestDropsEvent) {
        if (event.state.block == Blocks.MELON_BLOCK) {
            val mainHand = event.harvester.heldItemMainhand

            if (mainHand.isEmpty || mainHand.item.getToolClasses(mainHand).contains("shovel")) {
                event.drops.clear()
                event.drops.add(ItemStack(Blocks.MELON_BLOCK))
            }
        } else if (event.state.block == Blocks.LEAVES) {
            if (random.nextInt(4) == 1) {
                event.drops.add(ItemStack(Items.STICK, random.nextInt(4)))
            }
        }
    }
}
