package com.github.forgeadmin.forgeadmincore.api.permissions;

import com.github.forgeadmin.forgeadmincore.common.Config;

import java.util.HashMap;

public class PermissonHandler {

  private static HashMap<String, IPermission> permissionHandlers = new HashMap<>();

  public static IPermission getPermissionHandler() {
    return permissionHandlers.get(Config.permissionHandler);
  }

  public static IPermission getPermissionHandler(String handlerId) {
    return permissionHandlers.get(handlerId);
  }

  /**
   * Used by ForgeAdmin permission extensions to add a permission handler
   * during preInitialization.
   *
   * @param handler {@link IPermission} IPermission to be added for permissions
   */
  public static void addPermissonHandler(IPermission handler) {
    permissionHandlers.put(handler.handlerId(), handler);
  }
}
