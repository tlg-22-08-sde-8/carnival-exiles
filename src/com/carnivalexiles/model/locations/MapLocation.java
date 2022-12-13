package com.carnivalexiles.model.locations;

import java.util.Arrays;

public class MapLocation {
    public static final String[] ALL_LOCATIONS = {"SANDY BEACH", "COCO FOREST", "MOIST MARSHLAND", "SUS MOUNTAIN",
            "LOGARITHMIC LAKE", "LUMINOUS LAGOON"};

    // Creating a start location
    String[] startItems = {"stick"};
    String startDescription =
            "You look around and you see a beautiful Sandy Beach that stretches \n"
                    + "beyond the horizon to your right and a luscious forest,\n"
                    + "filled with coconuts, to your left.\n"
                    + "\nLocal Items: " + Arrays.toString(startItems);
    String startName = "START           ";
    String startVisibleLocations = "SANDY BEACH and COCO FOREST";
    Location startLocation = new Start(startDescription, startName, startItems, startVisibleLocations);

    // Creating SANDY BEACH
    String[] beachItems = {"sea shells"};
    String beachDescription =
            "You’ve arrived to Sandy Beach. Warm sand beneath your toes and \n"
                    + "the sound of waves splashing. Coco Forest is on your left and nearby\n"
                    + "to your right is a moist marshland.\n"
                    + "\nLocal Items:" + Arrays.toString(beachItems);
    String beachName = "SANDY BEACH     ";
    String beachVisibleLocations = "MOIST MARSHLAND and COCO FOREST";
    Location beachLocation = new Beach(beachDescription, beachName, beachItems, beachVisibleLocations);

    // Creating COCO FOREST
    String[] forestItems = {"coconut", "plant"};
    String forestDescription =
            "You’ve arrived at Coco Forest. An abundance of coconuts lie on the floor,\n"
                    + "some that have been eaten. You realize your belly is rumbling \n"
                    + "and you are quite parched from all your travels… Sandy Beach\n"
                    + "is behind you, and you also see a mountain peaking over behind \n"
                    + "the trees looking ominous.\n"
                    + "\nLocal Items:" + Arrays.toString(forestItems);
    String forestName = "COCO FOREST     ";
    String forestVisibleLocations = "SUS MOUNTAIN and SANDY BEACH";
    Location forestLocation = new Forest(forestDescription, forestName, forestItems, forestVisibleLocations);

    // Creating SUS MOUNTAIN
    String[] mountainItems = {"copper"};
    String mountainDescription =
            "Oh no! You’ve arrived at Sus Mountain and lava is slowly oozing out. \n"
                    + "It seems that there are x days left until an eruption. You need to \n"
                    + "get off of this island quickly!\n"
                    + "\nLocal Items:" + Arrays.toString(mountainItems);
    String mountainName = "SUS MOUNTAIN    ";
    String mountainVisibleLocations = "LOGARITHMIC LAKE and COCO FOREST";
    Location mountainLocation = new Mountain(mountainDescription, mountainName, mountainItems, mountainVisibleLocations);

    // Creating LOGARITHMIC LAKE
    String[] lakeItems = {"water", "fish"};
    String lakeDescription =
            "You arrive at a very beautiful and efficiently running lake. A Wizard\n"
                    + "appears. He says “In order to quench your thirst with this water,\n"
                    + "you must answer the following question”: \n\n"
                    + "If you have 2 logs and you jump over 1, how many times\n"
                    + "do you need to jump before you get tired? \n\n"
                    + "If the Wizard’s question is too difficult of a riddle… \n"
                    + "you can check out the moist marshland to quench your \n"
                    + "thirst. Along the shoreline that contain patches of\n"
                    + "aquatic vegetation are largemouth bass.\n"
                    + "\nLocal Items:" + Arrays.toString(lakeItems);
    String lakeName = "LOGARITHMIC LAKE";
    String lakeVisibleLocations = "MOIST MARSHLAND and SUS MOUNTAIN";
    Location lakeLocation = new Lake(lakeDescription, lakeName, lakeItems, lakeVisibleLocations);

    // Creating MOIST MARSHLAND
    String[] marshlandItems = new String[4];
    String marshlandDescription =
            "You have arrived at the Moist Marshland and it is just as humid as you\n"
                    + "anticipated. The stickiness of the marsh is too much to bear. You look in all\n"
                    + "directions and spot Luminous Lagoon ahead of you and Sandy Beach and Logarithmic\n"
                    + "Lake in your rear.\n"
                    + "\nLocal Items:" + Arrays.toString(marshlandItems);
    String marshlandName = "MOIST MARSHLAND ";
    String marshlandVisibleLocations = "SANDY BEACH, LOGARITHMIC LAKE, and LUMINOUS LAGOON";
    Location marshlandLocation = new MarshLand(marshlandDescription, marshlandName, marshlandItems, marshlandVisibleLocations);

    // Creating LUMINOUS LAGOON
    String[] lagoonItems = new String[4];
    String lagoonDescription =
            "You’ve arrived at Luminous Lagoon. The ripples shimmer with the reflection\n"
                    + "of the sun.\n"
                    + "\nLocal Items:" + Arrays.toString(lagoonItems);
    String lagoonName = "LUMINOUS LAGOON ";
    String lagoonVisibleLocations = "SANDY BEACH, LOGARITHMIC LAKE, and LUMINOUS LAGOON";
    Location lagoonLocation = new Lagoon(lagoonDescription, lagoonName, lagoonItems, lagoonVisibleLocations);

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getBeachLocation() {
        return beachLocation;
    }

    public Location getForestLocation() {
        return forestLocation;
    }

    public Location getMountainLocation() {
        return mountainLocation;
    }

    public Location getMarshlandLocation() {
        return marshlandLocation;
    }

    public Location getLakeLocation() {
        return lakeLocation;
    }

    public Location getLagoonLocation() {
        return lagoonLocation;
    }

    public Location locationHandler(String userInput) {
        switch (userInput) {
            case "SANDY BEACH":
                return getBeachLocation();
            case "COCO FOREST":
                return getForestLocation();
            case "MOIST MARSHLAND":
                return getMarshlandLocation();
            case "SUS MOUNTAIN":
                return getMountainLocation();
            case "LOGARITHMIC LAKE":
                return getLakeLocation();
            case "LUMINOUS LAGOON":
                return getLagoonLocation();
            default:
                return getStartLocation();
        }
    }
}
