package com.carnivalexiles.view;

import com.carnivalexiles.model.Day;
import com.carnivalexiles.model.User;
import com.carnivalexiles.model.locations.Location;

import java.io.IOException;
import java.util.Arrays;

public class ConsoleView {

    private String gameView;
    private Location currentLocation;
    public static final String GREEN = "\033[0;32m";
    public static final String RED = "\033[0;31m";
    public static final String YELLOW = "\033[0;33m";
    public static final String RESET = "\033[0m";                   // Text Reset

    public ConsoleView(User user, Location location, Day day)
            throws IOException, InterruptedException {
        this.currentLocation = location;
        String hp = String.valueOf(user.getHealthPoints());

        if (user.getHealthPoints() >= 50){
            hp = GREEN + hp + RESET;
        }

        else if (user.getHealthPoints() <= 20){
            hp = RED + hp + RESET;
        }

        else{
            hp = YELLOW + hp + RESET;
        }

        this.gameView = String.format(""
                        + "----------------------------------------------------------------------------------\n"
                        + "Hp: %s                  Location: %s                 Day %s: %s\n"
                        + "Inventory: %s\n"
                        + "----------------------------------------------------------------------------------\n\n"
                        + "%s\n"
                        + "Local Items: %s\n\n"
                , hp, location.getName(), day.getDay(), day.getTimeOfDay(),
                user.getInventoryAsString(), location.getDescription(),
                Arrays.toString(location.getItems()));
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public String getGameView() {
        return gameView;
    }
}