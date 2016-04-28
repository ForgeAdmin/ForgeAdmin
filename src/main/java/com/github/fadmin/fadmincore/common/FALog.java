package com.github.fadmin.fadmincore.common;

import com.github.fadmin.fadmincore.FAdmin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FALog {

  private static final Logger logger = LogManager.getLogger(FAdmin.class);

  public static Logger getLogger() {
    return logger;
  }
}
