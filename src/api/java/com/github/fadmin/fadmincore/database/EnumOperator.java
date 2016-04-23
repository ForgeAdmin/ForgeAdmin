package com.github.fadmin.fadmincore.database;

public enum EnumOperator {

  LESS("<"),
  LESSOREQUAL("<="),
  EQUAL("="),
  GREATEREQUAL(">="),
  GREATER(">");

  private final String value;

  EnumOperator(String value) {
    this.value = value;
  }
}
