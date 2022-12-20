package com.carnivalexiles.view;

import com.carnivalexiles.model.Day;
import com.carnivalexiles.model.User;
import com.carnivalexiles.model.locations.Location;

import java.io.IOException;
import java.util.Arrays;

public class ConsoleView {

  private String gameView;
  private Location currentLocation;
  private Day currentDay;

  public ConsoleView(User user, Location location, Day day) throws IOException, InterruptedException {
    this.currentLocation = location;
    this.currentDay = day;
    this.gameView = String.format(""
            + "----------------------------------------------------------------------------------\n"
            + "Hp: %d                  Location: %s                 Day %d: %s\n"
            + "Inventory: %s\n"
            + "----------------------------------------------------------------------------------\n\n"
            + "%s\n"
            + "Local Items: %s\n\n"
        , user.getHealthPoints(), location.getName(), day.getDay(), day.getTimeOfDay(),
        user.getInventoryAsString(), location.getDescription(), Arrays.toString(location.getItems()));
  }

  public Location getCurrentLocation() {
    return currentLocation;
  }

  public Day getCurrentDay() {
    return currentDay;
  }

  public String getGameView() {
    return gameView;
  }
}