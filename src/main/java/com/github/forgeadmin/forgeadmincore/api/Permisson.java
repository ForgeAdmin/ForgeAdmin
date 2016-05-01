package com.github.forgeadmin.forgeadmincore.api;

import com.github.forgeadmin.forgeadmincore.api.command.Permissable;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class Permisson {

  public static boolean hasPermission(EntityPlayer entityPlayer, String permission) {
    return false;
  }

  public static boolean canCommandSenderUseCommand(ICommandSender sender, Permissable command) {
    return !(sender instanceof EntityPlayer) || hasPermission((EntityPlayer) sender, command.getPermissionNode());
  }

  public void setPermissonHandler() {

  }
}
