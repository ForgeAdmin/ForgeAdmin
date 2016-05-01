package com.github.forgeadmin.forgeadmincore.api.permissions;

import com.github.forgeadmin.forgeadmincore.common.FALog;
import com.github.forgeadmin.forgeadmincore.common.permissions.DefaultPermission;

public class PermissonHandler {

  private static IPermission permissionHandler = new DefaultPermission();

  public static IPermission getPermissionHandler() {
    return permissionHandler;
  }

  /**
   * Used by ForgeAdmin permission extensions to set the permission handler
   * during preInitialization.
   *
   * @param handler {@link IPermission} IPermission to be used for permissions
   * @throws Exception
   */
  public static void setPermissonHandler(IPermission handler) throws Exception {
    if (handler != null && !handler.handlerId().equals("forgeadmin-default") ) {
      FALog.getLogger().error("Tried to set permission handler to " + handler.handlerId() +
          " while handler was already set to " + handler.handlerId());
      throw new Exception();
    } else {
      permissionHandler = handler;
    }
  }
}
