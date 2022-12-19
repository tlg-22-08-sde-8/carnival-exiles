package com.carnivalexiles.controller;

import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.MapLocation;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JsonLocationParser {

  //Method takes in a location entered by the user.
  public static ArrayList<Location> allMapLocations = new ArrayList<>();
  private static String description;
  private static String name;
  private static String[] itemList;
  private static String visibleLocations;


  private static InputStream getFileFromResourceAsStream(String fileName) {
    ClassLoader classLoader = JsonLocationParser.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(fileName);
    if (inputStream == null) {
      throw new IllegalArgumentException("file not found! " + fileName);
    } else {
      return inputStream;
    }
  }


  public static void locationParser() {

    //try {
    //Create a Gson
    Gson gson = new Gson();

    InputStream locationJson = getFileFromResourceAsStream("LocationData.json");
    Map<String,String> map = null;
    try (
        BufferedReader newReader = new BufferedReader(
            new InputStreamReader(locationJson, "UTF-8"))) {
      map = gson.fromJson(newReader, Map.class);
    } catch (IOException ioe) {
      System.out.println("Unable to read file" + ioe);
    }

    Object value = null;
    Set<Entry<String, String>> entries = map.entrySet();
    for (Map.Entry<?, ?> entry : entries) {
      value = entry.getValue();
      System.out.println(value);

    }


    for (String places : MapLocation.ALL_LOCATIONS) {



      //allMapLocations.add(location);
    }


  }

//  public static void itemParser() throws IOException {
//
//    try {
//
//      // create Gson instance
//      Gson gson = new Gson();
//
//      // create a reader
//      Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/Item.json"));
//
//      // convert JSON file to map
//      Map<?, ?> map = gson.fromJson(reader, Map.class);
//
//      // print map entries
//      for (Map.Entry<?, ?> entry : map.entrySet()) {
//        System.out.println(entry.getKey() + "=" + entry.getValue());
//      }
//
//      // close reader
//      reader.close();
//    } catch (IOException ex) {
//      throw new RuntimeException(ex);
//    }
//  }


}


