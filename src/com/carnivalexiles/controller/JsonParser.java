package com.carnivalexiles.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JsonParser {

  public static void main(String[] args) {

    try {

      //Create a Gson
      Gson gson = new Gson();

      //Create a reader to access LocationData.json
      BufferedReader reader = new BufferedReader(new FileReader("resources/LocationData.json"));

      //Pull the json data and place it into a map.
      Map<?,?> locationData = gson.fromJson(reader, new TypeToken<Map<?,?>>(){}.getType());
      //Map<?, ?> locationData = gson.fromJson(reader, Map.class);

      //Print it out
      for (Map.Entry<?, ?> entry : locationData.entrySet()) {
        System.out.println("Key:" + entry.getKey() + "  Value:" + entry.getValue());
      }

      try {
        reader.close();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
