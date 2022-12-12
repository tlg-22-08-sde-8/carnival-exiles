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
        if (!userInput.equals("quit")) {
            System.out.println(System.lineSeparator().repeat(50));
            playGame();
        }
        else {
            printGameOver();
        }
    }

    public static void printGameOver() {
        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("GAME OVER");
    }

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