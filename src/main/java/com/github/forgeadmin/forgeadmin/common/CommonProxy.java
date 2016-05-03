package com.github.forgeadmin.forgeadmin.common;

import com.github.forgeadmin.forgeadmin.api.database.DatabaseHandler;
import com.github.forgeadmin.forgeadmin.api.permissions.PermissonHandler;
import com.github.forgeadmin.forgeadmin.common.database.JsonDatabase;
import com.github.forgeadmin.forgeadmin.common.permissions.DefaultPermission;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy {

  public void preload(FMLPreInitializationEvent event) {
    Config.init(event);
    DatabaseHandler.addDatabase(new JsonDatabase());
    DatabaseHandler.getDatabase().initDatabase(event);
    PermissonHandler.addPermissonHandler(new DefaultPermission());
  }

  public void load(FMLInitializationEvent event) {
  }

  public void postload(FMLPostInitializationEvent event) {
  }

  public void serverAboutToStart(FMLServerAboutToStartEvent event) {
  }

  public void serverStarted(FMLServerStartedEvent event) {
  }

  public void serverStopped(FMLServerStoppedEvent event) {
    DatabaseHandler.getDatabase().closeDatabase(event);
  }
}