package com.carnivalexiles.controller;

import com.carnivalexiles.model.Day;
import com.carnivalexiles.model.User;
import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.Start;
import com.carnivalexiles.view.ConsoleView;

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

//    //Check user input for Game Initiation
//    public static void playGame() throws IOException {
//        //Retrieve user Input to play the game until they type 'Quit'
//        BufferedReader br;
//        String userInput;
//        br = new BufferedReader(new InputStreamReader(System.in));
//        do {
//            // place game logic code here. When user types q, game quits
//            System.out.print("> ");
//            userInput = br.readLine();
//            System.out.println("You entered '" + userInput + "'");
//        } while (!"Quit".equals(userInput));
//    }

    public static void enterGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Enter the game with any key or quit by typing "quit"
        System.out.print("> ");
        userInput = scanner.nextLine().toLowerCase();
        scanner.close();


        if (!userInput.equals("quit")) {
            System.out.println(System.lineSeparator().repeat(50));
            playGame();
        }
        else {
            printGameOver();
        }

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
                // TODO: 12/12/2022 Method to quit the game.
                break;
        }
//Test message

    }

    public static void printGameOver() {
        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("GAME OVER");
    }


        // TODO: 12/9/2022 Parse the initial text and see if its valid
        // TODO: 12/9/2022 If valid then send the match to its named method
        // TODO: 12/9/2022 if (UserAction != null) { }
        // TODO: 12/9/2022 Switch
        // TODO: 12/9/2022 is userAction == Consume?
        // TODO: 12/9/2022 is userAction == Go TO?
        // TODO: 12/9/2022 is userAction == PickUP?

    public static void playGame() {
        ConsoleView consoleView = new ConsoleView(user, start, day);
        System.out.println(consoleView.getGameView());
        getUserInput();
    }

    public static void getUserInput() {
        // At this point, provide textParser/scanner and read user input
        System.out.print("What do you want to do?\n> ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        while (!Arrays.asList(Action.allActions).contains(userInput)) {
            System.out.println("Action not available, type \"Help\" for assistance");
            System.out.print("> ");
            userInput = scanner.nextLine();
        }
        System.out.println(userInput + " do something inside Action class");
        // Take user input and apply that within the logic switch
    }

}