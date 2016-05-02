package com.github.forgeadmin.forgeadmin.api.database;

import com.github.forgeadmin.forgeadmin.common.Config;

import java.util.HashMap;

public class DatabaseHandler {

  private static HashMap<String, IDatabase> databases = new HashMap<>();

  public static IDatabase getDatabase() {
    return databases.get(Config.databaseHandler);
  }

  public static IDatabase getDatabase(String databaseId) {
    return databases.get(databaseId);
  }


  /**
   * Used by ForgeAdmin database extensions to add a database
   * during preInitialization.
   *
   * @param db {@link IDatabase} to be used for storage
   */
  public static void addDatabase(IDatabase db) {
    databases.put(db.databaseId(), db);
  }
}
