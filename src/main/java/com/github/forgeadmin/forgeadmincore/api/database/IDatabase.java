package com.github.forgeadmin.forgeadmincore.api.database;

import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;

import java.io.IOException;

public interface IDatabase {

  String databaseId();

  /**
   * Called at the end of PreInit. Init connections here?
   */
  void initDatabase(FMLServerAboutToStartEvent event);

  /**
   * Called at the end of server shutdown. End connections here?
   */
  void closeDatabase(FMLServerStoppedEvent event);

  <T> T fromDatabase(String collection, String key, Class<T> classOfT) throws IOException;

  void toDatabase(String collection, String key, Object object) throws IOException;
}
