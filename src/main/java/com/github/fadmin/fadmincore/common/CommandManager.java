package com.github.fadmin.fadmincore.common;

import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.server.CommandMessage;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.Map;
import java.util.Set;

import static com.github.fadmin.fadmincore.common.FALog.getLogger;

public class CommandManager {
  private static final String[] FIELDNAME = { "commandSet", "c", "field_71561_b", "z/c" };

  private static void replaceCommand(Class<CommandMessage> clazz, ICommand newCommand)
  {
    try
    {
      CommandHandler commandHandler = (CommandHandler) MinecraftServer.getServer().getCommandManager();
      Map<String, ICommand> commandMap = ReflectionHelper.getPrivateValue(CommandHandler.class, commandHandler, "commandMap", "a", "field_71562_a");
      Set<ICommand> commandSet = ReflectionHelper.getPrivateValue(CommandHandler.class, commandHandler, FIELDNAME);
      for (Map.Entry<String, ICommand> command : commandMap.entrySet()) {
        if (clazz.isAssignableFrom(command.getValue().getClass())) {
          commandSet.remove(command.getValue());
          commandSet.add(newCommand);
          command.setValue(newCommand);
        }
      }
    }
    catch (Exception e)
    {
      getLogger().error(String.format("Error replacing command /%s", clazz.getClass().getName()));
      e.printStackTrace();
    }
  }

  private static void replaceCommand(ICommand oldCommand, ICommand newCommand)
  {
    try
    {
      CommandHandler commandHandler = (CommandHandler) MinecraftServer.getServer().getCommandManager();
      Map<String, ICommand> commandMap = ReflectionHelper.getPrivateValue(CommandHandler.class, commandHandler, "commandMap", "a", "field_71562_a");
      Set<ICommand> commandSet = ReflectionHelper.getPrivateValue(CommandHandler.class, commandHandler, FIELDNAME);
      for (Map.Entry<String, ICommand> command : commandMap.entrySet()) {
        if (command.getValue() == oldCommand) {
          commandSet.remove(command.getValue());
          commandSet.add(newCommand);
          command.setValue(newCommand);
        }
      }
    }
    catch (Exception e)
    {
      getLogger().error(String.format("Error replacing command /%s", oldCommand.getCommandName()));
      e.printStackTrace();
    }
  }

  private static void replaceCommand(String command, ICommand newCommand)
  {
    ICommand oldCommand = MinecraftServer.getServer().getCommandManager().getCommands().get(command);
    if (oldCommand != null) {
      replaceCommand(oldCommand, newCommand);
    }
    else {
      getLogger().error(String.format("Could not find command /%s to replace", command));
    }
  }
}
