package com.carnivalexiles.controller;

public class Action {

    public static final String[] allActions = {"go", "travel", "walk", "trek", "navigate",
            "stroll", "dash", "skip", "crawl", "transit", "move", "consume", "swim", "cry",
            "rest", "get", "grab", "grasp", "collect", "pickup", "seize", "take", "hook",
            "grab", "catch", "acquire", "fetch", "snatch", "grip", "capture", "dominate",
            "clasp", "hug", "drop", "attack", "retreat", "run", "skedaddle", "zonk",
            "scamper", "look", "examine", "stare", "scrutinize", "glance", "peep",
            "help", "quit"};

    public static String printHelpMenu() {
        String result = "\n"
                + "----------- HELP MENU-------------\n"
                + "1. Go to a Location (Type \"Go\")\n"
                + "2. Consume (Type \"Consume\")\n"
                + "3. Swim (Type \"Swim\")\n"
                + "4. Cry (Type \"Cry\")\n"
                + "5. Rest (Type \"Swim\")\n"
                + "6. Grab an item (Type \"Grab\")\n"
                + "7. Hug Monkey (Type \"Hug\")\n"
                + "8. Drop an item (Type \"Drop\")\n"
                + "9. Attack (Type \"Attack\")\n"
                + "10. Retreat (Type \"Retreat\")\n"
                + "11. Look around (Type \"Look\")\n"
                + "12. Quit the game (Type \"Quit\")\n"
                + "-------------- END----------------\n"
                ;
        return result;
    }
}