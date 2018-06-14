package com.deflatedpickle.survivalimprovement

import com.deflatedpickle.survivalimprovement.events.ForgeEventHandler
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.registry.GameRegistry
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, modLanguageAdapter = Reference.ADAPTER)
object SurvivalImprovement {
  val log: Logger = LogManager.getLogger(Reference.MOD_ID)

  @EventHandler
  fun init(event: FMLInitializationEvent) {
    log.info("Starting Init.")
    MinecraftForge.EVENT_BUS.register(ForgeEventHandler())

    GameRegistry.addSmelting(Blocks.SAPLING, ItemStack(Blocks.DEADBUSH), 0f)
    log.info("Finished Init.")
  }
}
