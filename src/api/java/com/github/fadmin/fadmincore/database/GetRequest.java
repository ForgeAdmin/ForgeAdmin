package com.github.fadmin.fadmincore.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetRequest {

  private final String table;
  private List<Where> wheres = new ArrayList<Where>();
  private boolean ascending;
  private boolean first;

  public GetRequest(String table) {
    this.table = table;
    ascending = false;
    first = false;
  }

  public GetRequest where(String column, EnumOperator operator, Object value) {
    wheres.add(new Where(column, operator, value));
    return this;
  }

  public GetRequest where(String column, EnumOperator operator, int value) {
    where(column, operator, value);
    return this;
  }

  public GetRequest where(String column, EnumOperator operator, String value) {
    where(column, operator, value);
    return this;
  }

  public HashMap<String, Object> des() {
    return Database.getDatabase().getRequest(this);
  }

  public HashMap<String, Object> asc() {
    this.ascending = true;
    return Database.getDatabase().getRequest(this);
  }

  public HashMap<String, Object> first() {
    this.first = true;
    return Database.getDatabase().getRequest(this);
  }


  public List<Where> getWheres() {
    return wheres;
  }

  public String getTable() {
    return table;
  }

  public boolean isAscending() {
    return ascending;
  }

  public boolean isFirst() {
    return first;
  }

}
