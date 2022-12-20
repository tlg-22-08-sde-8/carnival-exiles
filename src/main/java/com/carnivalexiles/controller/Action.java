package com.carnivalexiles.controller;

public class Action {

    public static final String[] allActions = {"go", "travel", "walk", "trek", "navigate",
            "stroll", "dash", "skip", "crawl", "transit", "move", "consume", "cry",
            "rest", "get", "grab", "grasp", "collect", "pickup", "seize", "take", "hook",
            "grab", "catch", "acquire", "fetch", "snatch", "grip", "capture", "dominate",
            "clasp", "drop", "look", "examine", "stare", "scrutinize", "glance", "peep",
            "help", "music on", "music off","quit"};

    public static String printHelpMenu() {
        String result = "\n"
                + "----------- HELP MENU-------------\n"
                + "1. Go to a Location (Type \"Go\")\n"
                + "2. Consume (Type \"Consume\")\n"
                + "3. Cry (Type \"Cry\")\n"
                + "4. Rest (Type \"Rest\")\n"
                + "5. Grab an item (Type \"Grab\")\n"
                + "6. Drop an item (Type \"Drop\")\n"
                + "7. Look around (Type \"Look\")\n"
                + "8. Quit the game (Type \"Quit\")\n"
                + "-------------- END----------------\n";
        return result;
    }
}