package com.github.forgeadmin.forgeadmincore.common;

import com.github.forgeadmin.forgeadmincore.api.database.DatabaseHandler;
import com.github.forgeadmin.forgeadmincore.common.database.JsonDatabase;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy {

  public void preload(FMLPreInitializationEvent event) {
  }

  public void load(FMLInitializationEvent event) {
  }

  public void postload(FMLPostInitializationEvent event) {
  }

  public void serverAboutToStart(FMLServerAboutToStartEvent event) {
    if (DatabaseHandler.getDatabase() == null) {
      try {
        DatabaseHandler.setDatabase(new JsonDatabase());
      } catch (Exception ignored) {
      }
    }
    DatabaseHandler.getDatabase().initDatabase(event);
  }

  public void serverStarted(FMLServerStartedEvent event) {
  }

  public void serverStopped(FMLServerStoppedEvent event) {
    DatabaseHandler.getDatabase().closeDatabase(event);
  }
}