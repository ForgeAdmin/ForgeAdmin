package com.github.forgeadmin.forgeadmin.common.command;

import com.github.forgeadmin.forgeadmin.api.permissions.Permissible;
import com.github.forgeadmin.forgeadmin.common.command.overwrite.*;
import com.github.forgeadmin.forgeadmin.common.command.overwrite.server.*;
import net.minecraft.command.*;
import net.minecraft.command.server.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.Map;
import java.util.Set;

import static com.github.forgeadmin.forgeadmin.common.FALog.getLogger;
import static net.minecraft.server.MinecraftServer.getServer;

public class CommandManager {
  private static final String[] FIELDNAME = {"commandSet", "c", "field_71561_b", "z/c"};

  public static void overwriteDefaultCommands() {
    replaceCommand(new CommandTime(), new CommandTimeOverwrite());
    replaceCommand(new CommandGameMode(), new CommandGameModeOverwrite());
    replaceCommand(new CommandDifficulty(), new CommandDifficultyOverwrite());
    replaceCommand(new CommandDefaultGameMode(), new CommandDefaultGameModeOverwrite());
    replaceCommand(new CommandKill(), new CommandKillOverwrite());
    replaceCommand(new CommandToggleDownfall(), new CommandToggleDownfallOverwrite());
    replaceCommand(new CommandWeather(), new CommandWeatherOverwrite());
    replaceCommand(new CommandXP(), new CommandXPOverwrite());
    replaceCommand(new CommandTeleport(), new CommandTeleportOverwrite());
    replaceCommand(new CommandGive(), new CommandGiveOverwrite());
    replaceCommand(new CommandReplaceItem(), new CommandReplaceItemOverwrite());
    replaceCommand(new CommandStats(), new CommandStatsOverwrite());
    replaceCommand(new CommandEffect(), new CommandEffectOverwrite());
    replaceCommand(new CommandEnchant(), new CommandEnchantOverwrite());
    replaceCommand(new CommandParticle(), new CommandParticleOverwrite());
    replaceCommand(new CommandEmote(), new CommandEmoteOverwrite());
    replaceCommand(new CommandShowSeed(), new CommandShowSeedOverwrite());
    replaceCommand(new CommandHelp(), new CommandHelpOverwrite());
    replaceCommand(new CommandDebug(), new CommandDebugOverwrite());
    replaceCommand(new CommandMessage(), new CommandMessageOverwrite());
    replaceCommand(new CommandBroadcast(), new CommandBroadcastOverwrite());
    replaceCommand(new CommandSetSpawnpoint(), new CommandSetSpawnpointOverwrite());
    replaceCommand(new CommandSetDefaultSpawnpoint(), new CommandSetDefaultSpawnpointOverwrite());
    replaceCommand(new CommandGameRule(), new CommandGameRuleOverwrite());
    replaceCommand(new CommandClearInventory(), new CommandClearInventoryOverwrite());
    replaceCommand(new CommandTestFor(), new CommandTestForOverwrite());
    replaceCommand(new CommandSpreadPlayers(), new CommandSpreadPlayersOverwrite());
    replaceCommand(new CommandPlaySound(), new CommandPlaySoundOverwrite());
    replaceCommand(new CommandScoreboard(), new CommandScoreboardOverwrite());
    replaceCommand(new CommandExecuteAt(), new CommandExecuteAtOverwrite());
    replaceCommand(new CommandTrigger(), new CommandTriggerOverwrite());
    replaceCommand(new CommandAchievement(), new CommandAchievementOverwrite());
    replaceCommand(new CommandSummon(), new CommandSummonOverwrite());
    replaceCommand(new CommandSetBlock(), new CommandSetBlockOverwrite());
    replaceCommand(new CommandFill(), new CommandFillOverwrite());
    replaceCommand(new CommandClone(), new CommandCloneOverwrite());
    replaceCommand(new CommandCompare(), new CommandCompareOverwrite());
    replaceCommand(new CommandBlockData(), new CommandBlockDataOverwrite());
    replaceCommand(new CommandTestForBlock(), new CommandTestForBlockOverwrite());
    replaceCommand(new CommandMessageRaw(), new CommandMessageRawOverwrite());
    replaceCommand(new CommandWorldBorder(), new CommandWorldBorderOverwrite());
    replaceCommand(new CommandTitle(), new CommandTitleOverwrite());
    replaceCommand(new CommandEntityData(), new CommandEntityDataOverwrite());
    if (MinecraftServer.getServer().isDedicatedServer()) {
      replaceCommand(new CommandOp(), new CommandOpOverwrite());
      replaceCommand(new CommandDeOp(), new CommandDeOpOverwrite());
      replaceCommand(new CommandStop(), new CommandStopOverwrite());
      replaceCommand(new CommandSaveAll(), new CommandSaveAllOverwrite());
      replaceCommand(new CommandSaveOff(), new CommandSaveOffOverwrite());
      replaceCommand(new CommandSaveOn(), new CommandSaveOnOverwrite());
      replaceCommand(new CommandBanIp(), new CommandBanIpOverwrite());
      replaceCommand(new CommandPardonIp(), new CommandPardonIpOverwrite());
      replaceCommand(new CommandBanPlayer(), new CommandBanPlayerOverwrite());
      replaceCommand(new CommandListBans(), new CommandListBansOverwrite());
      replaceCommand(new CommandPardonPlayer(), new CommandPardonPlayerOverwrite());
      replaceCommand(new CommandServerKick(), new CommandServerKickOverwrite());
      replaceCommand(new CommandListPlayers(), new CommandListPlayersOverwrite());
      replaceCommand(new CommandWhitelist(), new CommandWhitelistOverwrite());
      replaceCommand(new CommandSetPlayerTimeout(), new CommandSetPlayerTimeoutOverwrite());
    } else {
      replaceCommand(new CommandPublishLocalServer(), new CommandPublishLocalServerOverwrite());
    }
  }

  private static void replaceCommand(Class<CommandMessage> clazz, ICommand newCommand) {
    try {
      CommandHandler commandHandler = (CommandHandler) getServer().getCommandManager();
      Map<String, ICommand> commandMap = ReflectionHelper.getPrivateValue(CommandHandler.class, commandHandler, "commandMap", "a", "field_71562_a");
      Set<ICommand> commandSet = ReflectionHelper.getPrivateValue(CommandHandler.class, commandHandler, FIELDNAME);
      for (Map.Entry<String, ICommand> command : commandMap.entrySet()) {
        if (clazz.isAssignableFrom(command.getValue().getClass())) {
          commandSet.remove(command.getValue());
          commandSet.add(newCommand);
          command.setValue(newCommand);
        }
      }
    } catch (Exception e) {
      getLogger().error(String.format("Error replacing command /%s", clazz.getClass().getName()));
      e.printStackTrace();
    }
  }

  private static void replaceCommand(ICommand oldCommand, ICommand newCommand) {
    try {
      CommandHandler commandHandler = (CommandHandler) getServer().getCommandManager();
      Map<String, ICommand> commandMap = ReflectionHelper.getPrivateValue(CommandHandler.class, commandHandler, "commandMap", "a", "field_71562_a");
      Set<ICommand> commandSet = ReflectionHelper.getPrivateValue(CommandHandler.class, commandHandler, FIELDNAME);
      for (Map.Entry<String, ICommand> command : commandMap.entrySet()) {
        if (command.getValue() == oldCommand) {
          commandSet.remove(command.getValue());
          commandSet.add(newCommand);
          command.setValue(newCommand);
        }
      }
    } catch (Exception e) {
      getLogger().error(String.format("Error replacing command /%s", oldCommand.getCommandName()));
      e.printStackTrace();
    }
  }

  private static void replaceCommand(String command, ICommand newCommand) {
    ICommand oldCommand = getServer().getCommandManager().getCommands().get(command);
    if (oldCommand != null) {
      replaceCommand(oldCommand, newCommand);
    } else {
      getLogger().error(String.format("Could not find command /%s to replace", command));
    }
  }
}
