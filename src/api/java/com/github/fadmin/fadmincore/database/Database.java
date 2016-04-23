package com.github.fadmin.fadmincore.database;

public class Database {

  private static IDatabase database = null;

  protected static IDatabase getDatabase() {
    return null;
  }

  /**
   * Used by fAdmin database extensions to set the database
   * during preInitialization.
   * @param database IDatabase to be used for storage
   * @throws Exception
   */
  public void setDatabase(IDatabase database) throws Exception {
    if (database != null) {
      throw new Exception();
    } else {
      Database.database = database;
    }
  }
}
