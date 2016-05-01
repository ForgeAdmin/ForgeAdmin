package com.github.forgeadmin.forgeadmincore.common.command.overwrite;

import com.github.forgeadmin.forgeadmincore.api.permissions.PermissonHandler;
import com.github.forgeadmin.forgeadmincore.api.permissions.Permissible;
import net.minecraft.command.CommandCompare;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandCompareOverwrite extends CommandCompare implements Permissible {

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
