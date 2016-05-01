package com.github.forgeadmin.forgeadmincore.api.permissions;

import net.minecraft.entity.player.EntityPlayer;

public interface IPermissionHandler {
  boolean hasPermission(EntityPlayer entityPlayer, String permission);
  boolean hasPermission(EntityPlayer entityPlayer, Permissable permissable);
}
