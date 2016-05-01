package com.github.forgeadmin.forgeadmincore.api.permissions;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class Permisson {

  private static IPermissionHandler permissionHandler = null;

  public static IPermissionHandler getPermissionHandler() {
    return permissionHandler;
  }

  public static boolean hasPermission(EntityPlayer entityPlayer, String permission) {
    return getPermissionHandler().hasPermission(entityPlayer, permission);
  }

  public static boolean canCommandSenderUseCommand(ICommandSender sender, Permissable command) {
    return !(sender instanceof EntityPlayer) || hasPermission((EntityPlayer) sender, command.getPermissionNode());
  }

  public void setPermissonHandler(IPermissionHandler permissonHandler) {}
}
