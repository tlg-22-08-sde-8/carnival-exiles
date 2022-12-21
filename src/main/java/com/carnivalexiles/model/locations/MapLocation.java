package com.carnivalexiles.model.locations;

import com.carnivalexiles.controller.JsonLocationParser;
import java.util.Arrays;
import java.util.List;

public class MapLocation {

    //Final
    public static final String[] ALL_LOCATIONS = {"LANDING ZONE", "SANDY BEACH", "COCO FOREST",
            "MOIST MARSHLAND", "SUS MOUNTAIN", "LOGARITHMIC LAKE", "LUMINOUS LAGOON"};

    public static final List<String> ALL_ITEMS = Arrays.asList("stick", "sea shells", "coconut",
            "magical herbs", "copper", "water", "fish", "frog", "brown water", "clay");

    public static final List<String> CONSUMABLE_ITEMS = Arrays.asList("coconut", "magical herbs",
            "bottled water", "bottled brown water", "fish", "berries");

    //(Comment Line 1) locationHandler method takes the user input and loads a specific location according to its index in
    //(Comment Line 2) the ALL_LOCATIONS variable. Ex: "LANDING ZONE" = 0, "SANDY BEACH" = 1, ... "LUMINOUS LAGOON" = 6.
    public Location locationHandler(String userInput) {
        switch (userInput) {
            case "LANDING ZONE":
                return JsonLocationParser.allMapLocations.get(0);
            case "SANDY BEACH":
                return JsonLocationParser.allMapLocations.get(1);
            case "COCO FOREST":
                return JsonLocationParser.allMapLocations.get(2);
            case "SUS MOUNTAIN":
                return JsonLocationParser.allMapLocations.get(4);
            case "MOIST MARSHLAND":
                return JsonLocationParser.allMapLocations.get(3);
            case "LOGARITHMIC LAKE":
                return JsonLocationParser.allMapLocations.get(5);
            case "LUMINOUS LAGOON":
                return JsonLocationParser.allMapLocations.get(6);
            default:
                return null;
        }
    }
}
