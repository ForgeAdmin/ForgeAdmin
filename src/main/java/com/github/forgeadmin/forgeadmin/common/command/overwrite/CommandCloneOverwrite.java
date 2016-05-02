package com.github.forgeadmin.forgeadmin.common.command.overwrite;

import com.github.forgeadmin.forgeadmin.api.permissions.PermissonHandler;
import com.github.forgeadmin.forgeadmin.api.permissions.Permissible;
import net.minecraft.command.CommandClone;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandCloneOverwrite extends CommandClone implements Permissible {

  @Override
  public int getRequiredPermissionLevel() {
    return 0;
  }

  @Override
  public String getPermissionNode() {
    return "minecraft.command." + getCommandName();
  }

  @Override
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    return !(sender instanceof EntityPlayer) || PermissonHandler.getPermissionHandler().hasPermission ((EntityPlayer) sender, this);
  }
}
