package com.github.forgeadmin.forgeadmincore.common.permissions;

import com.github.forgeadmin.forgeadmincore.api.permissions.IPermission;
import com.github.forgeadmin.forgeadmincore.api.permissions.Permissible;
import net.minecraft.entity.player.EntityPlayer;

import java.util.UUID;

public class DefaultPermission implements IPermission {
  @Override
  public String handlerId() {
    return "forgeadmin-default";
  }

  @Override
  public boolean hasPermission(UUID player, String permission) {
    return true;
  }

  @Override
  public boolean hasPermission(UUID player, Permissible permissable) {
    return true;
  }

  @Override
  public boolean hasPermission(EntityPlayer entityPlayer, String permission) {
    return true;
  }

  @Override
  public boolean hasPermission(EntityPlayer entityPlayer, Permissible permissable) {
    return true;
  }
}
