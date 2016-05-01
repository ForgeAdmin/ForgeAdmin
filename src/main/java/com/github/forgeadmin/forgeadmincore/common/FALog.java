package com.github.forgeadmin.forgeadmincore.common;

import com.github.forgeadmin.forgeadmincore.ForgeAdmin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FALog {

  private static final Logger logger = LogManager.getLogger(ForgeAdmin.class);

  public static Logger getLogger() {
    return logger;
  }
}
