package com.github.fadmin.fadmincore.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PutRequest {

  private final String table;
  private List<Where> wheres = new ArrayList<Where>();
  private String key;
  private HashMap<String, Object> object;

  public PutRequest(String table) {
    this.table = table;
  }

  public PutRequest where(String column, EnumOperator operator, Object value) {
    wheres.add(new Where(column, operator, value));
    return this;
  }

  public PutRequest where(String column, EnumOperator operator, int value) {
    where(column, operator, value);
    return this;
  }

  public PutRequest where(String column, EnumOperator operator, String value) {
    where(column, operator, value);
    return this;
  }

  public void object(String key, HashMap<String, Object> object) {
    this.key = key;
    this.object = object;
    Database.getDatabase().putRequest(this);
  }
}
