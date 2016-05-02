package com.github.forgeadmin.forgeadmin.common.command.overwrite;

import com.github.forgeadmin.forgeadmin.api.permissions.Permissible;
import net.minecraft.command.CommandBlockData;

public class CommandBlockDataOverwrite extends CommandBlockData implements Permissible {

  @Override
  public int getRequiredPermissionLevel() {
    return 0;
  }

  @Override
  public String getPermissionNode() {
    return "minecraft.command." + getCommandName();
  }
}
