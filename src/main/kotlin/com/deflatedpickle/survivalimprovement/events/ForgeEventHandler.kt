package com.deflatedpickle.survivalimprovement.events

import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.monster.EntitySkeleton
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.event.entity.living.LivingDropsEvent
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

    @SubscribeEvent
    fun onLivingDropsEvent(event: LivingDropsEvent) {
        if (event.source.damageType == "inWall") {
            if (event.entity is EntitySkeleton) {
                for (i in event.drops) {
                    if (i.item.unlocalizedName == "item.bone") {
                        var count = 0
                        event.drops.remove(i)

                        for (n in 0 until i.item.count) {
                            val num = random.nextInt(4)
                            count += num
                        }

                        event.drops.add(EntityItem(event.entity.world, event.entity.posX, event.entity.posY, event.entity.posZ, ItemStack(Items.DYE, count, 15)))
                    }
                }
            }
        }
    }
}
