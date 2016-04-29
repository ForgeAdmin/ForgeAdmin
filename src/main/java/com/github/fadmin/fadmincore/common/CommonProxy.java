package com.github.fadmin.fadmincore.common;

import com.github.fadmin.fadmincore.api.database.Database;
import com.github.fadmin.fadmincore.common.database.JsonDatabase;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy {

  public void preload(FMLPreInitializationEvent event) {
  }

  public void load(FMLInitializationEvent event) {
  }

  public void postload(FMLPostInitializationEvent event) {
  }

  public void serverAboutToStart(FMLServerAboutToStartEvent event) {
    if (Database.getDatabase() == null) {
      try {
        Database.setDatabase(new JsonDatabase());
      } catch (Exception ignored) {
      }
    }
    Database.getDatabase().initDatabase(event);
  }

  public void serverStarted(FMLServerStartedEvent event) {
  }

  public void serverStopped(FMLServerStoppedEvent event) {
    Database.getDatabase().closeDatabase(event);
  }
}