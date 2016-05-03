package com.github.forgeadmin.forgeadmin.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Config {

  public static String permissionHandler;
  public static String databaseHandler;

  static class ConfigItem {

    private final String description;
    private final Object value;

    ConfigItem(String description, Object value) {
      this.description = description;
      this.value = value;
    }

    public String getDescription() {
      return description;
    }

    public Object getValue() {
      return value;
    }
  }

  private static HashMap<String, ConfigItem> configItems;

  public static void init(FMLPreInitializationEvent event) {

    File configLocation = new File(event.getModConfigurationDirectory(), "forgeadmin/config.json");

    FileInputStream inputStream = null;
    try {
      inputStream = new FileInputStream(configLocation);
      Type type = new TypeToken<HashMap<String, ConfigItem>>(){}.getType();
      configItems = new Gson().fromJson(IOUtils.toString(inputStream), type);
      inputStream.close();
    } catch (FileNotFoundException e) {
      createNewConfig(event);
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
      createNewConfig(event);
    }

    permissionHandler = getString("permission-handler", "forgeadmin-default");
    databaseHandler = getString("database-handler", "json-database");
  }

  private static void createNewConfig(FMLPreInitializationEvent event) {
    configItems = new HashMap<>();

    configItems.put("permission-handler", new ConfigItem("ID of the permission handler", "forgeadmin-default"));
    configItems.put("database-handler", new ConfigItem("ID of the database handler", "json-database"));

    String config = new GsonBuilder().setPrettyPrinting().create().toJson(configItems);

    Writer writer = null;
    File configLocation = new File(event.getModConfigurationDirectory(), "forgeadmin");
    try {
      configLocation.mkdirs();
      writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(configLocation, "config.json")), "utf-8"));
      writer.write(config);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        writer.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static Object get(String key) {
    return configItems.get(key).getValue();
  }

  public static int getInt(String key, int defaultValue) {
    try {
      return Integer.parseInt(configItems.get(key).getValue().toString().replace(".0", ""));
    } catch (ClassCastException e) {
      e.printStackTrace();
    }
    return defaultValue;
  }

  public static boolean getBoolean(String key, boolean defaultValue) {
    try {
      return Boolean.parseBoolean(configItems.get(key).getValue().toString());
    } catch (ClassCastException e) {
      e.printStackTrace();
    }
    return defaultValue;
  }

  public static String getString(String key, String defaultValue) {
    try {
      return configItems.get(key).getValue().toString();
    } catch (ClassCastException e) {
      e.printStackTrace();
    }
    return defaultValue;
  }
}
