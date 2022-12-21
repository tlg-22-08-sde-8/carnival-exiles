package com.carnivalexiles.controller;

import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.MapLocation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JsonLocationParser {

    //Method takes in a location entered by the user.
    public static ArrayList<Location> allMapLocations = new ArrayList<>();
    private static String description;
    private static String name;
    private static String[] itemList;
    private static String visibleLocations;

    //Load file as a stream and include an IllegalArgumentException to catch invalid file names.
    private static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = JsonLocationParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    //Method loads and creates location objects for every location and stores them in allMapLocations
    public static void locationParser() {
        //Create a Gson
        Gson gson = new Gson();

        //Opening the file as a stream with the getFileFromResourceAsStream method,
        InputStream locationJson = getFileFromResourceAsStream("LocationData.json");
        BufferedReader newReader = new BufferedReader(
                new InputStreamReader(locationJson, StandardCharsets.UTF_8));

        //Save the object in a way that is accessible to the method.
        JsonObject countryObj = gson.fromJson(newReader, JsonObject.class);

        //Iterate through all locations and store the location objects in allMapLocations
        for (String places : MapLocation.ALL_LOCATIONS) {

            //use each place in MapLocation.ALL_LOCATIONS to get the json information.
            JsonArray jsonArrayOfLocation = countryObj.get(places.toLowerCase()).getAsJsonArray();

            //Iterate through every element within a single place and parse out the information to create a location object.
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

                //Use extracted data to create a new location object and add it to an ArrayList of locations.
                allMapLocations.add(new Location(description, name, itemList, visibleLocations));
            }
        }
    }
}



