package com.carnivalexiles.controller;

import com.carnivalexiles.model.User;
import com.carnivalexiles.model.locations.Location;

public class Action {

    public static final String[] allActions = {"go", "consume", "swim", "cry", "rest",
            "grab", "hug", "drop", "attack", "retreat", "look", "help", "quit"};

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
