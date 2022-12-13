package com.carnivalexiles.controller;

import com.carnivalexiles.model.Day;
import com.carnivalexiles.model.User;
import com.carnivalexiles.model.locations.*;
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
            System.out.println(System.lineSeparator().repeat(50));
            playGame(user, mapLocations.getStartLocation(), day);
        }
        else {
            printGameOver();
        }
    }

    public static void printGameOver() throws IOException, InterruptedException {
        System.out.println(System.lineSeparator().repeat(50));
        String enterMessage = "(Enter \"Yes\" or \"No\")\n> ";
        String[] validAnswers = {"yes", "no", "quit"};
        System.out.print("GAME OVER...play again? " + enterMessage);
        String userInput = bufferReader.readLine().toLowerCase().trim();
        while (!Arrays.asList(validAnswers).contains(userInput)) {
            System.out.print(enterMessage);
            userInput = bufferReader.readLine().toLowerCase().trim();
        }
        if (userInput.equals("yes")) {
            System.out.println(System.lineSeparator().repeat(50));
            WelcomeScreen.displayTitle();
            WelcomeScreen.displayIntroduction();
            TextParser.enterGame();
        }
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
        while (!Arrays.asList(Action.allActions).contains(userInput)) {
            System.out.println("Action not available, type \"Help\" for assistance");
            System.out.print("> ");
            userInput = bufferReader.readLine().trim();
        }
        actionHandler(userInput);
    }

    public static void actionHandler(String userInput) throws IOException, InterruptedException {
        switch (userInput) {
            case "go":
                goTo();
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
                grab();
                break;
            case "hug":
                hug();
                break;
            case "drop":
                drop();
                break;
            case "attack":
                attack();
                break;
            case "retreat":
                retreat();
                break;
            case "look":
                lookAtItem();
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

    private static void goTo() throws IOException, InterruptedException {
        String visibleLocations = consoleView.getCurrentLocation().getVisibleLocations();
        String UpperCaseVisibleLocations = visibleLocations.toUpperCase();
        var visibleLocationsAsList = new ArrayList<String>();
        // Create a list of the available locations from the visible locations at this location
        for (String location : MapLocation.ALL_LOCATIONS) {
            if (UpperCaseVisibleLocations.contains(location)) {
                visibleLocationsAsList.add(location);
            }
        }
        System.out.printf("Where would you like to go? You can go to %s (pick one)\n> ", visibleLocations);
        String userInput = bufferReader.readLine().trim();
        userInput = userInput.toUpperCase().trim();
        while (!visibleLocationsAsList.contains(userInput)) {
            if (Arrays.asList(Action.allActions).contains(userInput.toLowerCase())) {
                actionHandler(userInput.toLowerCase().trim());
                break;
            }
            System.out.printf("Location not available, enter one of the following %s\n", visibleLocationsAsList);
            System.out.print("> ");
            userInput = bufferReader.readLine().trim();
        }
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, mapLocations.locationHandler(userInput),day);
    }

    private static void lookAtItem() throws IOException, InterruptedException {
        System.out.println("Choose an item from your inventory to examine or write \"Cancel\":\n");
        System.out.println("This is your current inventory:");
        for (Object inventory: user.getInventory()) {System.out.println(inventory);}
        System.out.print("\nWhat do you want to do?\n> ");
        String userInput = bufferReader.readLine().trim();
        userInput = "["+ userInput.toLowerCase() +"]";

        while (userInput.equals(user.getInventoryAsString().toLowerCase()) || (userInput.equals("[cancel]"))) {
            if (userInput.equals(user.getInventoryAsString().toLowerCase())) {
                System.out.printf("You are looking at %s", user.getInventoryAsString());
                Thread.sleep(3000);
            }
            System.out.println(System.lineSeparator().repeat(50));
            playGame(user, mapLocations.locationHandler(userInput), day);
        }

        System.out.println("Sorry that item is not available");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, mapLocations.locationHandler(userInput), day);
    }

    private static void performHelp() {
        System.out.println((Action.printHelpMenu()));
    }

    private static void consumeItem() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void swim() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void cry() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void rest() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void grab() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void hug() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void drop() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void attack() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void retreat() throws IOException, InterruptedException {
        System.out.println("STUB METHOD - IMPLEMENT DURING SPRINT 2");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, consoleView.getCurrentLocation(), day);
    }
}