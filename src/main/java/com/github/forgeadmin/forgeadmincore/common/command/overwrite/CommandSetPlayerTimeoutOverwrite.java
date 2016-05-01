package com.github.forgeadmin.forgeadmincore.common.command.overwrite;

import com.github.forgeadmin.forgeadmincore.api.Permisson;
import com.github.forgeadmin.forgeadmincore.api.command.Permissable;
import net.minecraft.command.CommandSetPlayerTimeout;
import net.minecraft.command.ICommandSender;

public class CommandSetPlayerTimeoutOverwrite extends CommandSetPlayerTimeout implements Permissable {

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
