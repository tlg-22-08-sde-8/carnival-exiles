package com.carnivalexiles.controller;

import com.carnivalexiles.model.Day;
import com.carnivalexiles.model.Main;
import com.carnivalexiles.model.User;
import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.Start;
import com.carnivalexiles.view.ConsoleView;
import com.carnivalexiles.view.WelcomeScreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class TextParser {
    static User user = new User(100, new String[]{"Machete"});
    static Day day = new Day();

    // Creating a start location EXAMPLE ONLY
    static String description =
            "You look around and you see a beautiful sandy beach and a forest,\n"
                    + " filled with coconuts, to your left. In the distance, you can see a large\n"
                    + " Sus Mountain and more land beyond the beach.";
    static String name = "START";
    static String[] items = new String[4];
    static String visibleLocations = "SANDY BEACH and COCO FOREST";
    static Location start = new Start(description, name, items, visibleLocations);

    ConsoleView consoleView;

    public static void enterGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Enter the game with any key or quit by typing "quit"
        System.out.print("> ");
        userInput = scanner.nextLine().toLowerCase();

        if (!userInput.equals("quit")) {
            System.out.println(System.lineSeparator().repeat(50));
            playGame();
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
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().toLowerCase();
        while (!Arrays.asList(validAnswers).contains(userInput)) {
            System.out.print(enterMessage);
            userInput = scanner.nextLine().toLowerCase();
        }
        if (userInput.equals("yes")) {
            System.out.println(System.lineSeparator().repeat(50));
            WelcomeScreen.displayTitle();
            WelcomeScreen.displayIntroduction();
            TextParser.enterGame();
        }
    }

    public static void playGame() throws IOException {
        ConsoleView consoleView = new ConsoleView(user, start, day);
        System.out.println(consoleView.getGameView());
        getUserInput();
    }

    public static void getUserInput() throws IOException {
        // At this point, provide textParser/scanner and read user input
        System.out.print("What do you want to do?\n> ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        while (!Arrays.asList(Action.allActions).contains(userInput)) {
            System.out.println("Action not available, type \"Help\" for assistance");
            System.out.print("> ");
            userInput = scanner.nextLine();
        }
        actionHandler(userInput);
    }

    public static void actionHandler(String userInput) throws IOException {
        switch (userInput) {
            case "go":
                // TODO: 12/12/2022 Method to Go to location.
                break;
            case "consume":
                // TODO: 12/12/2022 Method to consume something.
                break;
            case "swim":
                // TODO: 12/12/2022 Method to swim.
                break;
            case "cry":
                Action.cry();
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

    private static void performHelp() {
        System.out.println((Action.printHelpMenu()));
    }



}