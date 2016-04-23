package com.github.fadmin.fadmincore.database;

import java.util.HashMap;

public interface IDatabase {

  /**
   * Called at the end of PreInit. Init connections here?
   */
  void initDatabase();

  /**
   * Called at the end of server shutdown. End connections here?
   */
  void closeDatabase();
  
  HashMap<String, Object> getRequest(GetRequest request);

  void setRequest(SetRequest request);

  void putRequest(PutRequest request);
}
