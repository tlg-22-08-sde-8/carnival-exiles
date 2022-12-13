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
import java.util.Scanner;

public class TextParser {
    static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

    static MapLocation mapLocations = new MapLocation();                              // All map locations obj
    static User user = new User(100, new String[]{"Empty Bottle"});       // Game user
    static Day day = new Day();                                                      // Game day

    private static ConsoleView consoleView;                                          // Game console

    public static void enterGame() throws IOException {
        String userInput;

        // Enter the game with any key or quit by typing "quit"
        System.out.print("> ");
        userInput = bufferReader.readLine().toLowerCase();

        if (!userInput.equals("quit")) {
            System.out.println(System.lineSeparator().repeat(50));
            playGame(user, mapLocations.getStartLocation(), day);
        }
        else {
            printGameOver();
        }
    }

    public static void printGameOver() throws IOException {
        System.out.println(System.lineSeparator().repeat(50));
        String enterMessage = "(Enter \"Yes\" or \"No\")\n> ";
        String[] validAnswers = {"yes", "no", "quit"};
        System.out.print("GAME OVER...play again? " + enterMessage);
        String userInput = bufferReader.readLine().toLowerCase();
        while (!Arrays.asList(validAnswers).contains(userInput)) {
            System.out.print(enterMessage);
            userInput = bufferReader.readLine().toLowerCase();
        }
        if (userInput.equals("yes")) {
            System.out.println(System.lineSeparator().repeat(50));
            WelcomeScreen.displayTitle();
            WelcomeScreen.displayIntroduction();
            TextParser.enterGame();
        }
    }

    public static void playGame(User user, Location location, Day day) throws IOException {
        consoleView = new ConsoleView(user, location, day);
        System.out.println(consoleView.getGameView());
        getUserInput();
    }

    public static void getUserInput() throws IOException {
        // At this point, provide textParser/scanner and read user input
        System.out.print("What do you want to do?\n> ");
        String userInput = bufferReader.readLine().toLowerCase();
        while (!Arrays.asList(Action.allActions).contains(userInput)) {
            System.out.println("Action not available, type \"Help\" for assistance");
            System.out.print("> ");
            userInput = bufferReader.readLine();
        }
        actionHandler(userInput);
    }

    public static void actionHandler(String userInput) throws IOException {
        switch (userInput) {
            case "go":
                goTo();
                break;
            case "consume":
                // TODO: 12/12/2022 Method to consume something.
                break;
            case "swim":
                // TODO: 12/12/2022 Method to swim.
                break;
            case "cry":
                cry();
                break;
            case "rest":
                // TODO: 12/12/2022 Method to rest and take time.
                break;
            case "grab":
                // TODO: 12/12/2022 Method to grab an item.
                break;
            case "hug":
                // TODO: 12/12/2022 Method to hug magic monkey.
                break;
            case "drop":
                // TODO: 12/12/2022 Method to select an item and drop it.
                break;
            case "attack":
                // TODO: 12/12/2022 Method to attack something.
                break;
            case "retreat":
                // TODO: 12/12/2022 Method to retreat.
                break;
            case "look":
                // TODO: 12/12/2022 Method to look around.
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

    private static void goTo() throws IOException {
        String visibleLocations = consoleView.getCurrentLocation().getVisibleLocations();
        String UpperCaseVisibleLocations = visibleLocations.toUpperCase();
        var visibleLocationsAsList = new ArrayList<String>();
        // Create a list of the available locations from the visible locations at this location
        for (String location : mapLocations.ALL_LOCATIONS) {
            if (UpperCaseVisibleLocations.contains(location)) {
                visibleLocationsAsList.add(location);
            }
        }
        System.out.printf("Where would you like to go? You can go to %s (pick one)\n> ", visibleLocations);
        String userInput = bufferReader.readLine();
        userInput = userInput.toUpperCase();
        while (!visibleLocationsAsList.contains(userInput)) {
            if (Arrays.asList(Action.allActions).contains(userInput.toLowerCase())) {
                actionHandler(userInput.toLowerCase());
                break;
            }
            System.out.printf("Location not available, enter one of the following %s\n", visibleLocationsAsList);
            System.out.print("> ");
            userInput = bufferReader.readLine();
        }
        System.out.println(System.lineSeparator().repeat(50));
        playGame(user, mapLocations.locationHandler(userInput),day);
    }

    private static void performHelp() {
        System.out.println((Action.printHelpMenu()));
    }

    public static void cry() {
        System.out.println("You spend a few hours crying because of your situation.");
    }

    public void look(Location location) {
        // TODO: 12/10/22 Determine where the user is.
        // TODO: 12/10/22 Provide more information as to what the user can see.
    }



}