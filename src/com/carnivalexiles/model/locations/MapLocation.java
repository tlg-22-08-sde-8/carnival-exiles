package com.carnivalexiles.model.locations;

import com.carnivalexiles.controller.JsonLocationParser;
import java.util.Arrays;
import java.util.List;

public class MapLocation {
    public static final String[] ALL_LOCATIONS = {"START", "SANDY BEACH", "COCO FOREST", "MOIST MARSHLAND", "SUS MOUNTAIN",
            "LOGARITHMIC LAKE", "LUMINOUS LAGOON"};

    public static final List<String> ALL_ITEMS = Arrays.asList("stick", "sea shells", "coconut", "magical herbs",
            "copper", "water", "fish", "frog", "brown water", "clay");

    public static final List<String> CONSUMABLE_ITEMS = Arrays.asList("coconut", "magical herbs",
            "bottled water", "bottled brown water", "fish", "berries");

    public Location locationHandler(String userInput) {
        switch (userInput) {
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
                return JsonLocationParser.allMapLocations.get(0);
        }
    }
}
