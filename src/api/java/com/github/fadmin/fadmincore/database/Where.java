package com.github.fadmin.fadmincore.database;

public class Where {
  private String column;
  private EnumOperator operator;
  private Object value;

  public Where(String column, EnumOperator operator, Object value) {
    this.column = column;
    this.operator = operator;
    this.value = value;
  }
}