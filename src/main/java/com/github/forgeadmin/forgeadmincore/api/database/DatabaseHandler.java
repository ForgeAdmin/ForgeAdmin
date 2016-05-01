package com.github.forgeadmin.forgeadmincore.api.database;

import com.github.forgeadmin.forgeadmincore.common.FALog;

public class DatabaseHandler {

  private static IDatabase database = null;

  public static IDatabase getDatabase() {
    return database;
  }

  /**
   * Used by ForgeAdmin database extensions to set the database
   * during preInitialization.
   *
   * @param db {@link IDatabase} to be used for storage
   * @throws Exception
   */
  public static void setDatabase(IDatabase db) throws Exception {
    if (database != null) {
      FALog.getLogger().error("Tried to set database to " + db.toString() +
          " while database was already set to " + database.toString());
      throw new Exception();
    } else {
      database = db;
    }
  }
}
