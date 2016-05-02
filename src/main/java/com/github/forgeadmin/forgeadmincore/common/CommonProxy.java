package com.github.forgeadmin.forgeadmincore.common;

import com.github.forgeadmin.forgeadmincore.api.database.DatabaseHandler;
import com.github.forgeadmin.forgeadmincore.api.permissions.PermissonHandler;
import com.github.forgeadmin.forgeadmincore.common.database.JsonDatabase;
import com.github.forgeadmin.forgeadmincore.common.permissions.DefaultPermission;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy {

  public void preload(FMLPreInitializationEvent event) {
  }

  public void load(FMLInitializationEvent event) {
  }

  public void postload(FMLPostInitializationEvent event) {
  }

  public void serverAboutToStart(FMLServerAboutToStartEvent event) {
    Config.init(event);
    DatabaseHandler.addDatabase(new JsonDatabase());
    DatabaseHandler.getDatabase().initDatabase(event);
    PermissonHandler.addPermissonHandler(new DefaultPermission());
  }

  public void serverStarted(FMLServerStartedEvent event) {
  }

  public void serverStopped(FMLServerStoppedEvent event) {
    DatabaseHandler.getDatabase().closeDatabase(event);
  }
}