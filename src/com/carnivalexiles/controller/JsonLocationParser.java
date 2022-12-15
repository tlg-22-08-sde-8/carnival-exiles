package com.carnivalexiles.controller;

import com.carnivalexiles.model.locations.Location;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class JsonLocationParser {


  //Method takes in a location entered by the user.
  public static Location locationParser(String enteredLocation) {
    // TODO: 12/14/2022 Attempted Null and this dummy location object and neither have worked. 
    Location location = new Location("asdf", "placeholder", null,"Something");
    try {

      //Create a Gson
      Gson gson = new Gson();

      //Method 1
      //Create a reader to access LocationData.json
      BufferedReader reader = new BufferedReader(new FileReader("resources/LocationData.json"));

      //Pull the json data and place it into a map.
      Map<?, ?> locationData = gson.fromJson(reader, new TypeToken<Map<?, ?>>() {
      }.getType());
      //Map<?, ?> locationData = gson.fromJson(reader, Map.class);

      //Print it out
//      for (Map.Entry<?, ?> entry : locationData.entrySet()) {
//        System.out.println("Key:" + entry.getKey() + "  Value:" + entry.getValue());
//      }

//      String userInput = "String";
//      if(userInput.equals("String")) {
//        System.out.println(locationData.get("start"));
//
//      }

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

        location = new Location(description, name, itemList, visibleLocations);
        System.out.println(location.getVisibleLocations());
        System.out.println(location.getName());
        System.out.println(Arrays.toString(location.getItems()));
        System.out.println(location.getDescription());
        System.out.println(location);
      }

      try {
        reader.close();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return location;
  }



//  public static void main(String[] args) {
//
//  locationParser("Start");
//
//  }
}
