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
    static User user = new User(100, new String[]{"Empty Bottle"});
    static Day day = new Day();

    // Creating a start location
    static String startDescription =
            "You look around and you see a beautiful Sandy Beach that stretches \n"
                    + "beyond the horizon to your right and a luscious forest,\n"
                + "filled with coconuts, to your left.\n";
    static String startName = "START           ";
    static String[] startItems = new String[4];
    static String startVisibleLocations = "SANDY BEACH and COCO FOREST";
    static Location startLocation = new Start(startDescription, startName, startItems, startVisibleLocations);

    // Creating SANDY BEACH
    static String beachDescription =
        "You’ve arrived to Sandy Beach. Warm sand beneath your toes and \n"
            + "the sound of waves splashing. Coco Forest is on your left and nearby\n"
            + "to your right is a moist marshland.\n";
    static String beachName = "SANDY BEACH     ";
    static String[] beachItems = new String[4];
    static String beachVisibleLocations = "MOIST MARSHLAND and COCO FOREST";
    static Location beachLocation = new Start(beachDescription, beachName, beachItems, beachVisibleLocations);

    // Creating COCO FOREST
    static String forestDescription =
        "You’ve arrived at Coco Forest. An abundance of coconuts lie on the floor,\n"
            + "some that have been eaten. You realize your belly is rumbling \n"
            + "and you are quite parched from all your travels… Sandy Beach\n"
            + "is behind you, and you also see a mountain peaking over behind \n"
            + "the trees looking ominous.\n";
    static String forestName = "COCO FOREST     ";
    static String[] forestItems = new String[4];
    static String forestVisibleLocations = "SUS MOUNTAIN and SANDY BEACH";
    static Location forestLocation = new Start(forestDescription, forestName, forestItems, forestVisibleLocations);

    // Creating SUS MOUNTAIN
    static String mountainDescription =
        "Oh no! You’ve arrived at Sus Mountain and lava is slowly oozing out. \n"
            + "It seems that there are x days left until an eruption. You need to \n"
            + "get off of this island quickly!\n";
    static String mountainName = "SUS MOUNTAIN    ";
    static String[] mountainItems = new String[4];
    static String mountainVisibleLocations = "LOGARITHMIC LAKE and COCO FOREST";
    static Location mountainLocation = new Start(mountainDescription, mountainName, mountainItems, mountainVisibleLocations);

    // Creating LOGARITHMIC LAKE
    static String lakeDescription =
              "You arrive at a very beautiful and efficiently running lake. A Wizard\n"
            + "appears. He says “In order to quench your thirst with this water,\n"
            + "you must answer the following question”: \n\n"
            + "If you have 2 logs and you jump over 1, how many times\n"
            + "do you need to jump before you get tired? \n\n"
            + "If the Wizard’s question is too difficult of a riddle… \n"
            + "you can check out the moist marshland to quench your \n"
            + "thirst.\n";
    static String lakeName = "LOGARITHMIC LAKE\n";
    static String[] lakeItems = new String[4];
    static String lakeVisibleLocations = "MOIST MARSHLAND and SUS MOUNTAIN";
    static Location lakeLocation = new Start(lakeDescription, lakeName, lakeItems, lakeVisibleLocations);

    // Creating MOIST MARSHLAND
    static String marshlandDescription =
        "You have arrived at the Moist Marshland and it is just as humid as you\n"
            + "anticipated. The stickiness of the marsh is too much to bear. You look in all\n"
            + "directions and spot Luminous Lagoon ahead of you and Sandy Beach and Logarithmic\n"
            +"Lake in your rear.\n";
    static String marshlandName = "MOIST MARSHLAND ";
    static String[] marshlandItems = new String[4];
    static String marshlandVisibleLocations = " Sandy Beach and Logarithmic Lake and Luminous Lagoon";
    static Location marshlandLocation = new Start(marshlandDescription, marshlandName, marshlandItems, marshlandVisibleLocations);

    // Creating LUMINOUS LAGOON
    static String lagoonDescription =
        "You’ve arrived at Luminous Lagoon. The ripples shimmer with the reflection\n"
            +"of the sun.\n";
    static String lagoonName = "LUMINOUS LAGOON ";
    static String[] lagoonItems = new String[4];
    static String lagoonVisibleLocations = " Sandy Beach and Logarithmic Lake and Luminous Lagoon";
    static Location lagoonLocation = new Start(lagoonDescription, lagoonName, lagoonItems, lagoonVisibleLocations);
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
        ConsoleView consoleView = new ConsoleView(user, startLocation, day);
        System.out.println(consoleView.getGameView());
//beach
        ConsoleView consoleView1 = new ConsoleView(user, beachLocation, day);
        System.out.println(consoleView1.getGameView());
//forest
        ConsoleView consoleView2 = new ConsoleView(user, forestLocation, day);
        System.out.println(consoleView2.getGameView());
//mountain
        ConsoleView consoleView3 = new ConsoleView(user, mountainLocation, day);
        System.out.println(consoleView3.getGameView());
//lake
        ConsoleView consoleView4 = new ConsoleView(user, lakeLocation, day);
        System.out.println(consoleView4.getGameView());
//marshland
        ConsoleView consoleView5 = new ConsoleView(user, marshlandLocation, day);
        System.out.println(consoleView5.getGameView());

        //lagoon
        ConsoleView consoleView6 = new ConsoleView(user, lagoonLocation, day);
        System.out.println(consoleView6.getGameView());

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
        System.out.println(userInput.toLowerCase() + " do something inside Action class");
        // Take user input and apply that within the logic switch
    }

}