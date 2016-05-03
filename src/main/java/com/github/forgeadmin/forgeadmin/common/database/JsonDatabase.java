package com.github.forgeadmin.forgeadmin.common.database;

import com.github.forgeadmin.forgeadmin.api.database.IDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.HashMap;

public class JsonDatabase implements IDatabase {

  private Gson gson;
  private File storageLocation;

  @Override
  public String databaseId() {
    return "json-database";
  }

  @Override
  public void initDatabase(FMLPreInitializationEvent event) {
    gson = new GsonBuilder().setPrettyPrinting().create();
    storageLocation = new File(event.getModConfigurationDirectory(), "forgeadmin/database");
  }

  @Override
  public void closeDatabase(FMLServerStoppedEvent event) {

  }

  @Override
  public <T> T fromDatabase(String collection, String key, Class<T> classOfT) throws IOException {
    //set folder to load JSONs for this collection
    File collectionFolder = new File(storageLocation, collection);
    //set inputstream for this specific JSON file
    FileInputStream inputStream = new FileInputStream(new File(collectionFolder, key.concat(".json")));
    //convert JSON file to object
    return new Gson().fromJson(IOUtils.toString(inputStream), classOfT);
  }

  @Override
  public <T> HashMap<String, T> fromDatabase(String collection, Class<T> classOfT) throws IOException {
    HashMap<String, T> results = new HashMap<>();
    //set folder to load JSONs for this collection
    File collectionFolder = new File(storageLocation, collection);
    if (collectionFolder.listFiles() != null) {
      //iterate through all files in collection
      for (File document : collectionFolder.listFiles()) {
        //set inputstream for this specific JSON file
        FileInputStream inputStream = new FileInputStream(new File(collectionFolder, document.getName()));
        //convert JSON file to object and add to results
        results.put(document.getName().replace(".json", ""), new Gson().fromJson(IOUtils.toString(inputStream), classOfT));
      }
    }
    return results;
  }

  @Override
  public void toDatabase(String collection, String key, Object object) throws IOException {
    //convert object to json string with pretty printing
    String objectJson = gson.toJson(object);
    //set folder to save JSONs for this collection
    File collectionFolder = new File(storageLocation, collection);
    Writer writer = null;
    //set file to save JSON for this document
    File document = new File(collectionFolder, key.concat(".json"));
    //write JSON and close writer
    collectionFolder.mkdirs();
    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(document), "utf-8"));
    writer.write(objectJson);
    writer.close();
  }
}
