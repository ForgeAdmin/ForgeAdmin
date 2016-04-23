package com.github.fadmin.fadmincore.common;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

public class CommonProxy {
  public void preload(FMLPreInitializationEvent event) {}

  public void load(FMLInitializationEvent event) {}

  public void postload(FMLPostInitializationEvent event) {}

  public void serverStarted(FMLServerStartedEvent event) {}
}