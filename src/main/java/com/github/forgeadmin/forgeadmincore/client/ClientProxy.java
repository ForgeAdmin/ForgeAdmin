package com.github.forgeadmin.forgeadmincore.client;

import com.github.forgeadmin.forgeadmincore.common.CommonProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

public class ClientProxy extends CommonProxy {

  @Override
  public void preload(FMLPreInitializationEvent event) {
    super.preload(event);
  }

  @Override
  public void load(FMLInitializationEvent event) {
    super.load(event);
  }

  @Override
  public void postload(FMLPostInitializationEvent event) {
    super.postload(event);
  }

  @Override
  public void serverStarted(FMLServerStartedEvent event) {
    super.serverStarted(event);
  }
}