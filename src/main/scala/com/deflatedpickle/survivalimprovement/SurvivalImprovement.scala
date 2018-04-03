package com.deflatedpickle.survivalimprovement

import com.deflatedpickle.survivalimprovement.events.ForgeEventHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, modLanguage = "scala")
object SurvivalImprovement {
  val log: Logger = LogManager.getLogger(Reference.NAME)

  @EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    log.info("Starting Init.")
    MinecraftForge.EVENT_BUS.register(new ForgeEventHandler)
    log.info("Finished Init.")
  }
}
