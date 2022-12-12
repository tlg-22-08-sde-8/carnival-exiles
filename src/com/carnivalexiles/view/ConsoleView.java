package com.carnivalexiles.view;

import com.carnivalexiles.model.Day;
import com.carnivalexiles.model.User;
import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.Start;

public class ConsoleView {

  String gameView;

  public ConsoleView(User user, Location location, Day day) {
    this.gameView = String.format(""
            + "-----------------------------------------------------------------------\n"
            + "Hp: %d                  Location: %s                 Day %d: %s\n"
            + "Inventory: %s\n"
            + "-----------------------------------------------------------------------\n\n"
            + "%s\n\n"
        , user.getHealthPoints(), location.getName(), day.getDay(), day.getTimeOfDay(),
        user.getInventoryAsString(), location.getDescription());
  }

  public String getGameView() {
    return gameView;
  }

  // TODO: 12/12/22 Finish Formatting the Console-View Class
  // MAIN METHOD ADDED HERE ONLY FOR TESTING THE CONSOLE-VIEW OUTPUT TO CONSOLE
  // WILL NEED TO REMOVED ONCE THIS CLASS IS FINAL
  public static void main(String[] args) {
    // Creating a user EXAMPLE ONLY
    User user = new User(100, new String[]{"Machete"});

    // Creating a start location EXAMPLE ONLY
    String description =
        "You look around and you see a beautiful sandy beach and a forest,\n"
            + " filled with coconuts, to your left. In the distance, you can see a large\n"
            + " Sus Mountain and more land beyond the beach.";
    String name = "START";
    String[] items = new String[4];
    String visibleLocations = "SANDY BEACH and COCO FOREST";
    Location start = new Start(description, name, items, visibleLocations);

    // Creating a new day EXAMPLE ONLY
    Day day = new Day();

    ConsoleView consoleView = new ConsoleView(user, start, day);
    System.out.println(consoleView.gameView);

    // At this point, provide textParser/scanner and read user input
    System.out.println("What do you want to do?\n>");
  }
}


