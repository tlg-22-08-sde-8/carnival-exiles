package com.carnivalexiles.controller;

import com.carnivalexiles.model.Day;
import com.carnivalexiles.model.User;
import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.MapLocation;
import com.carnivalexiles.view.ConsoleView;
import com.carnivalexiles.view.WelcomeScreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TextParser {
    static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

    static MapLocation mapLocations = new MapLocation();                              // All map locations obj
    static User user = new User(100, new String[]{"Empty Bottle"});       // Game user
    static Day day = new Day();                                                      // Game day

    private static ConsoleView consoleView;                                          // Game console

    public static void enterGame() throws IOException, InterruptedException {
        String userInput;

        // Enter the game with any key or quit by typing "quit"
        System.out.print("> ");
        userInput = bufferReader.readLine().toLowerCase().trim();

        if (!userInput.equals("quit")) {
            clearScreen();
            playGame(user, mapLocations.getStartLocation(), day);
        } else {
            printGameOver();
        }
    }

    public static void printGameOver() throws IOException, InterruptedException {
        clearScreen();
        String enterMessage = "(Enter \"Yes\" or \"No\")\n> ";
        String[] validAnswers = {"yes", "no", "quit"};
        System.out.print("GAME OVER...play again? " + enterMessage);
        String userInput = bufferReader.readLine().toLowerCase().trim();
        while (!Arrays.asList(validAnswers).contains(userInput)) {
            System.out.print(enterMessage);
            userInput = bufferReader.readLine().toLowerCase().trim();
        }
        if (userInput.equals("yes")) {
            clearScreen();
            startGame();
        } else {
            stopGame();
        }
    }

    private static void stopGame() {
        Thread.currentThread().stop();
    }

    public static void clearScreen() {
        System.out.println(System.lineSeparator().repeat(50));
    }

    public static void startGame() throws IOException, InterruptedException {
        WelcomeScreen.displayTitle();
        WelcomeScreen.displayIntroduction();
        TextParser.enterGame();
    }

    public static void playGame(User user, Location location, Day day) throws IOException, InterruptedException {
        consoleView = new ConsoleView(user, location, day);
        System.out.println(consoleView.getGameView());
        getUserInput();
    }

    public static void getUserInput() throws IOException, InterruptedException {
        // At this point, provide textParser/scanner and read user input
        System.out.print("What do you want to do?\n> ");
        String userInput = bufferReader.readLine().toLowerCase().trim();
        // Capture the requested action from the user's input
        String requestedAction = "";
        for (String action : Action.allActions) {
            if (userInput.contains(action)) {
                requestedAction = action;
                break;
            }
        }
        // If user's input does not contain a valid action, prompt again for input
        if (requestedAction.isEmpty()) {
            System.out.println("Action not available, type \"Help\" for assistance");
            Thread.sleep(3000);
            clearScreen();
            playGame(user, consoleView.getCurrentLocation(), day);
            getUserInput();
        }
        actionHandler(requestedAction, userInput);
    }

    public static void actionHandler(String requestedAction, String userInput) throws IOException, InterruptedException {
        switch (requestedAction) {
            case "go":
                goTo(userInput);
                break;
            case "consume":
                consumeItem();
                break;
            case "swim":
                swim();
                break;
            case "cry":
                cry();
                break;
            case "rest":
                rest();
                break;
            case "grab":
                grabItem(userInput);
                break;
            case "hug":
                hug();
                break;
            case "drop":
                dropItem(userInput);
                break;
            case "attack":
                attack();
                break;
            case "retreat":
                retreat();
                break;
            case "look":
                lookAtItems();
                break;
            case "quit":
                printGameOver();
                break;
            case "help":
                performHelp();
                TextParser.getUserInput();
                break;
        }
    }

    private static void goTo(String rawUserInput) throws IOException, InterruptedException {
        String visibleLocations = consoleView.getCurrentLocation().getVisibleLocations();
        String UpperCaseVisibleLocations = visibleLocations.toUpperCase();
        String userRequestedLocation = "";
        var visibleLocationsAsList = new ArrayList<String>();
        // Create a list of the available locations from the visible locations at this location
        for (String location : MapLocation.ALL_LOCATIONS) {
            if (UpperCaseVisibleLocations.contains(location)) {
                visibleLocationsAsList.add(location);
            }
        }
        // See if userInput contains an available location
        String upperCaseRawUserInput = rawUserInput.toUpperCase();
        for (String location : visibleLocationsAsList) {
            if (upperCaseRawUserInput.contains(location)) {
                userRequestedLocation = location;
                break;
            }
        }
        if (userRequestedLocation.isEmpty()) {
            System.out.printf("You can only go to %s (pick one)\n ", visibleLocations);
            getUserInput();
        }
        clearScreen();
        day.increaseTimeOfDay(2);
        playGame(user, mapLocations.locationHandler(userRequestedLocation), day);
    }

    private static void lookAtItems() throws IOException, InterruptedException {
        System.out.println("\nThis is your current inventory:");
        for (Object inventory : user.getInventory()) {
            System.out.println(inventory);
        }
        System.out.print("\nWhat do you want to do?\n> ");
        String userInput = bufferReader.readLine().trim();
        userInput = "[" + userInput.toLowerCase() + "]";

        while (userInput.equals(user.getInventoryAsString().toLowerCase()) || (userInput.equals("[cancel]"))) {
            if (userInput.equals(user.getInventoryAsString().toLowerCase())) {
                System.out.printf("You are looking at %s", user.getInventoryAsString());
                Thread.sleep(3000);
            }
            clearScreen();
            playGame(user, mapLocations.locationHandler(userInput), day);
        }
        System.out.println("Sorry that item is not available");
        Thread.sleep(3000);
        clearScreen();
        playGame(user, mapLocations.locationHandler(userInput), day);
    }

    private static void performHelp() {
        System.out.println((Action.printHelpMenu()));
    }

    private static void consumeItem() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void swim() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void cry() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void rest() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void grabItem(String rawUserInput) throws IOException, InterruptedException {
        String upperCaseRawUserInput = rawUserInput.toUpperCase();
        String[] currentLocationItems = consoleView.getCurrentLocation().getItems();
        String itemToGrab = "";
        for (int i = 0; i < currentLocationItems.length; i++) {
            if (upperCaseRawUserInput.contains(currentLocationItems[i].toUpperCase())) {
                // Grab item, update item into user inventory, and remove from location items
                itemToGrab = currentLocationItems[i];
                var itemsList = new ArrayList<>(Arrays.asList(currentLocationItems));
                itemsList.remove(i);
                consoleView.getCurrentLocation().setItems(itemsList.toArray(new String[itemsList.size()]));
                var currentUserInventory = user.getInventory();
                var currentUserInventoryAsList = new ArrayList<>(Arrays.asList(currentUserInventory));
                currentUserInventoryAsList.add(itemToGrab);
                user.setInventory(currentUserInventoryAsList.toArray(new String[currentUserInventoryAsList.size()]));
                break;
            }
        }
        if (itemToGrab.isEmpty()) {
            System.out.println("Item not available.");
            getUserInput();
        }
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void dropItem(String rawUserInput) throws IOException, InterruptedException {
        String upperCaseRawUserInput = rawUserInput.toUpperCase();
        var userInventory = user.getInventory();
        var itemsToDrop = new ArrayList<String>();
        // Identify items to drop from the user's input
        for (String item : userInventory) {
            if (upperCaseRawUserInput.contains(item.toUpperCase())) {
                itemsToDrop.add(item);
            }
        }
        // If no match, print error and try again
        if (itemsToDrop.isEmpty()) {
            System.out.println("Please provide a valid item(s) to drop.");
            getUserInput();
        } else {
            var userInventoryList = new ArrayList<>(Arrays.asList(userInventory));
            var locationItemsList = new ArrayList<>(Arrays.asList(consoleView.getCurrentLocation().getItems()));
            // For every item to drop, remove it from the user inventory and it to the location items
            for (String item : itemsToDrop) {
                userInventoryList.remove(item);
                locationItemsList.add(item);
            }
            user.setInventory(userInventoryList.toArray(new String[userInventoryList.size()]));
            consoleView.getCurrentLocation().setItems(locationItemsList.toArray(new String[locationItemsList.size()]));
        }
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void hug() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void attack() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void retreat() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }
}