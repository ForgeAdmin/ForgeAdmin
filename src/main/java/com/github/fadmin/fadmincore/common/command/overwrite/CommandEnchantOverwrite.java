package com.github.fadmin.fadmincore.common.command.overwrite;

import com.github.fadmin.fadmincore.api.Permisson;
import com.github.fadmin.fadmincore.api.command.Permissable;
import net.minecraft.command.CommandEnchant;
import net.minecraft.command.ICommandSender;

public class CommandEnchantOverwrite extends CommandEnchant implements Permissable {

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
