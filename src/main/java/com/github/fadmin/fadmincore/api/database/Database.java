package com.github.fadmin.fadmincore.api.database;

import com.github.fadmin.fadmincore.common.FALog;

public class Database {

  private static IDatabase database = null;

  public static IDatabase getDatabase() {
    return database;
  }

  /**
   * Used by fAdmin database extensions to set the database
   * during preInitialization.
   *
   * @param db IDatabase to be used for storage
   * @throws Exception
   */
  public static void setDatabase(IDatabase db) throws Exception {
    if (database != null) {
      FALog.getLogger().error("Tried to set database to " + db.toString() +
          " while database was alread set to " + database.toString());
      throw new Exception();
    } else {
      database = db;
    }
  }
}
