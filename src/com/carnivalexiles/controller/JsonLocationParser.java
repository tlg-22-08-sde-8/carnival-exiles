package com.carnivalexiles.controller;

import static com.google.gson.JsonParser.parseReader;

import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.MapLocation;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.util.ArrayList;

public class JsonLocationParser {

  public static ArrayList<Location> allMapLocations = new ArrayList<>();
  private static String description;
  private static String name;
  private static String[] itemList;
  private static String visibleLocations;

  public static void locationParser() {
    try {
      //Accessing the json file
      JsonElement fileElement = parseReader(new FileReader("resources/LocationData.json"));
      JsonObject fileObject = fileElement.getAsJsonObject();

      //Iterate through all places and store them in allMapLocations
      for (String places : MapLocation.ALL_LOCATIONS) {

        //Takes in a user input location and chooses a location to pull data from LocationData.json
        JsonArray jsonArrayOfLocation = fileObject.get(places.toLowerCase()).getAsJsonArray();

        for (JsonElement locationElement : jsonArrayOfLocation) {
          //Get the JsonObject:
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
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("CHECK JSON LOCATION, PATH IS STILL NOT READABLE BY JAR FILE");
      Thread.currentThread().stop();
    }
  }
}
