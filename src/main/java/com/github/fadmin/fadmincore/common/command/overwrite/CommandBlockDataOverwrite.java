package com.github.fadmin.fadmincore.common.command.overwrite;

import com.github.fadmin.fadmincore.api.command.Permissable;
import net.minecraft.command.CommandBlockData;

public class CommandBlockDataOverwrite extends CommandBlockData implements Permissable {

  @Override
  public int getRequiredPermissionLevel() {
    return 0;
  }

  @Override
  public String getPermissionNode() {
    return "minecraft.command." + getCommandName();
  }
}
