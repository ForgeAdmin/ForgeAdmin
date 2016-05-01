package com.github.forgeadmin.forgeadmincore.api.permissions;

import net.minecraft.entity.player.EntityPlayer;

import java.util.UUID;

public interface IPermission {
  String handlerId();
  boolean hasPermission(UUID player, String permission);
  boolean hasPermission(UUID player, Permissible permissable);
  boolean hasPermission(EntityPlayer entityPlayer, String permission);
  boolean hasPermission(EntityPlayer entityPlayer, Permissible permissable);
}
