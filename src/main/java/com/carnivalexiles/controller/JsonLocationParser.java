package com.carnivalexiles.controller;

import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.MapLocation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

    //Create a Gson
    Gson gson = new Gson();

    try {

      InputStream locationJson = getFileFromResourceAsStream("LocationData.json");
      BufferedReader newReader = new BufferedReader(
          new InputStreamReader(locationJson, "UTF-8"));
      JsonObject countryObj = gson.fromJson(newReader, JsonObject.class);

      for (String places : MapLocation.ALL_LOCATIONS) {

        JsonArray jsonArrayOfLocation = countryObj.get(places.toLowerCase()).getAsJsonArray();

        for (JsonElement locationElement : jsonArrayOfLocation) {

          JsonObject locationJsonObject = locationElement.getAsJsonObject();

          //Extract Data
          var listOfItems = new ArrayList<String>();
          for (JsonElement items : locationJsonObject.get("items").getAsJsonArray()) {
            listOfItems.add(String.valueOf(items).replace("\"", ""));
          }
          itemList = listOfItems.toArray(new String[listOfItems.size()]);
          name = locationJsonObject.get("name").getAsString();
          visibleLocations = locationJsonObject.get("visibleLocations").getAsString();
          description = locationJsonObject.get("description").getAsString();
          allMapLocations.add(new Location(description, name, itemList, visibleLocations));

        }
      }


    } catch (IOException e) {
      e.printStackTrace();
    }
  }




  public static void itemParser() throws IOException {

    try {

      // create Gson instance
      Gson gson = new Gson();

      // create a reader
      InputStream locationJson = getFileFromResourceAsStream("Item.json");
      BufferedReader newReader = new BufferedReader(
          new InputStreamReader(locationJson, "UTF-8"));
      JsonObject countryObj = gson.fromJson(newReader, JsonObject.class);

      // convert JSON file to map
      for (int i = 0; i < countryObj.size(); i++) {
        String item = countryObj.keySet().toString();
        System.out.println(item);
        }


     //System.out.println(countryObj.get("stick"));


      // close reader
      newReader.close();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  public static void main(String[] args) throws IOException {
   JsonLocationParser.itemParser();
  }


}



