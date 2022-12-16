package com.carnivalexiles.controller;

import com.carnivalexiles.model.locations.Beach;
import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.MapLocation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonLocationParser {

  //public Location location;
  //Method takes in a location entered by the user.
  public static ArrayList<Location> allMapLocations = new ArrayList<>();
  private static String description;
  private static String name;
  private static String[] itemList;
  private static String visibleLocations;

  public static void locationParser() {

    try {
      //Create a Gson
      Gson gson = new Gson();

      //Create a reader to access LocationData.json
      BufferedReader reader = new BufferedReader(
          new FileReader("resources/LocationData.json"));

      //Accessing the json file
      JsonElement fileElement = com.google.gson.JsonParser.parseReader(
          new FileReader("resources/LocationData.json"));
      JsonObject fileObject = fileElement.getAsJsonObject();

      //Iterate through all places and store them in allMapLocations
      for (String places : MapLocation.ALL_LOCATIONS) {

        //Takes in a user input location and chooses a location to pull data from LocationData.json
        JsonArray jsonArrayOfLocation = fileObject.get(places.toLowerCase()).getAsJsonArray();

        for (JsonElement locationElement : jsonArrayOfLocation) {
          //Get the JsonObject:
          JsonObject locationJsonObject = locationElement.getAsJsonObject();

          // TODO: 12/14/2022 ArrayofLocations as a string.

          //Extract Data

          var listOfItems = new ArrayList<String>();
          for (JsonElement items : locationJsonObject.get("items").getAsJsonArray()) {
            listOfItems.add(String.valueOf(items));
          }
          itemList = listOfItems.toArray(new String[listOfItems.size()]);
          name = locationJsonObject.get("name").getAsString();
          visibleLocations = locationJsonObject.get("visibleLocations").getAsString();
          description = locationJsonObject.get("description").getAsString();

          Location location = new Location(description, name, itemList, visibleLocations);
          //System.out.println(location.getDescription() + location.getName());
          allMapLocations.add(location);
        }
      }
//            switch (enteredLocation) {
//                case "SANDY BEACH":
//                    location = new Beach(description, name, itemList,
//                        visibleLocations);
//                    break;
//                case "COCO FOREST":
//                    return new Forest(description, name, itemList, visibleLocations);
//                case "MOIST MARSHLAND":
//                    return new MarshLand(description, name, itemList, visibleLocations);
//                case "SUS MOUNTAIN":
//                    return new Mountain(description, name, itemList, visibleLocations);
//                case "LOGARITHMIC LAKE":
//                    return new Lake(description, name, itemList, visibleLocations);
//                case "LUMINOUS LAGOON":
//                    return new Lagoon(description, name, itemList, visibleLocations);
//            }
      try {
        reader.close();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    //return location;
  }

  public static void locationParser(String enteredLocation) {
    // TODO: 12/14/2022 Attempted Null and this dummy location object and neither have worked. 
    //Location location = null;
    try {

      //Create a Gson
      Gson gson = new Gson();

      //Method 1
      //Create a reader to access LocationData.json
      BufferedReader reader = new BufferedReader(new FileReader("resources/LocationData.json"));

      //Pull the json data and place it into a map.
//      Map<?, ?> locationData = gson.fromJson(reader, new TypeToken<Map<?, ?>>() {
//      }.getType());

      //Method 2
      //Accessing the json file
      JsonElement fileElement = com.google.gson.JsonParser.parseReader(
          new FileReader("resources/LocationData.json"));
      JsonObject fileObject = fileElement.getAsJsonObject();

      //Takes in a user input location and chooses a location to pull data from LocationData.json
      JsonArray jsonArrayOfLocation = fileObject.get(enteredLocation).getAsJsonArray();

      for (JsonElement locationElement : jsonArrayOfLocation) {
        //Get the JsonObject:
        JsonObject locationJsonObject = locationElement.getAsJsonObject();

        // TODO: 12/14/2022 ArrayofLocations as a string.
        // TODO: 12/14/2022 Object to hold the array of locationobjects.

        //Extract Data

        var listOfItems = new ArrayList<String>();
        for (JsonElement items : locationJsonObject.get("items").getAsJsonArray()) {
          listOfItems.add(String.valueOf(items));
        }
        String[] itemList = listOfItems.toArray(new String[listOfItems.size()]);

        String name = locationJsonObject.get("name").getAsString();
        String visibleLocations = locationJsonObject.get("visibleLocations").getAsString();
        String description = locationJsonObject.get("description").getAsString();

//        location = new Location(description, name, itemList, visibleLocations);
//        System.out.println(location.getVisibleLocations());
//        System.out.println(location.getName());
//        System.out.println(Arrays.toString(location.getItems()));
//        System.out.println(location.getDescription());
//        System.out.println(location);

        switch (enteredLocation) {
          case "SANDY BEACH":
            Location location = new Beach(description, name, itemList, visibleLocations);
            break;
          case "COCO FOREST":

          case "MOIST MARSHLAND":

          case "SUS MOUNTAIN":

          case "LOGARITHMIC LAKE":

          case "LUMINOUS LAGOON":

          default:

        }


      }

      try {
        reader.close();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    //return location;
    return;
  }
}
