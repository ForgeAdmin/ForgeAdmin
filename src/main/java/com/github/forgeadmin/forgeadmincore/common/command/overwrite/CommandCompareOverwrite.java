package com.github.forgeadmin.forgeadmincore.common.command.overwrite;

import com.github.forgeadmin.forgeadmincore.api.permissions.Permisson;
import com.github.forgeadmin.forgeadmincore.api.permissions.Permissable;
import net.minecraft.command.CommandCompare;
import net.minecraft.command.ICommandSender;

public class CommandCompareOverwrite extends CommandCompare implements Permissable {

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
    return Permisson.canCommandSenderUseCommand(sender, this);
  }
}
