package com.github.fadmin.fadmincore.database;

import java.util.HashMap;

public class SetRequest {

  private final String table;
  private final Object failIfExists;
  private String key;
  private HashMap<String, Object> object;

  public SetRequest(String table, boolean failIfExists) {
    this.table = table;
    this.failIfExists = failIfExists;
  }

  public SetRequest(String table) {
    this(table, false);
  }

  public void object(String key, HashMap<String, Object> object) {
    this.key = key;
    this.object = object;
    Database.getDatabase().setRequest(this);
  }
}
