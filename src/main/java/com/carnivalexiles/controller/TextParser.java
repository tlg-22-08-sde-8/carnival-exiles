package com.carnivalexiles.controller;

import com.carnivalexiles.model.Day;
import com.carnivalexiles.model.User;
import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.locations.MapLocation;
import com.carnivalexiles.view.ConsoleView;
import com.carnivalexiles.view.ArtText;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import javax.sound.sampled.LineUnavailableException;
import java.util.LinkedList;

public class TextParser {

    public static final int LAST_DAY_IN_GAME = 8;
    static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
    static MapLocation mapLocations = new MapLocation();                              // All map locations obj
    static User user = new User(100, new String[]{"empty bottle"});       // Game user
    static Day day = new Day();                                                      // Game day

    private static ConsoleView consoleView;                                          // Game console

    public static void enterGame() throws IOException, InterruptedException {
        String userInput;
        // Enter the game with any key or quit by typing "quit"
        System.out.print("> ");
        userInput = bufferReader.readLine().toLowerCase().trim();
        if (!userInput.equals("quit")) {
            clearScreen();
            playGame(user, JsonLocationParser.allMapLocations.get(0), day);
        } else {
            printGameOver();
        }
    }

    public static void newGame() {
        mapLocations = new MapLocation();                              // All map locations obj
        user = new User(100, new String[]{"empty bottle"});       // Game user
        day = new Day();
        JsonLocationParser.allMapLocations.get(0).setItems(new String[]{"stick"});
        JsonLocationParser.allMapLocations.get(1).setItems(new String[]{"sea shells"});
        JsonLocationParser.allMapLocations.get(2)
                .setItems(new String[]{"coconut", "magical herbs"});
        JsonLocationParser.allMapLocations.get(3).setItems(new String[]{"frog", "brown water"});
        JsonLocationParser.allMapLocations.get(4).setItems(new String[]{"copper"});
        JsonLocationParser.allMapLocations.get(5).setItems(new String[]{"water", "fish"});
        JsonLocationParser.allMapLocations.get(6).setItems(new String[]{"clay"});
    }

    public static void printGameWin() throws IOException, InterruptedException {
        clearScreen();
        ArtText.displaySuccess();
        String enterMessage = "(Enter \"Yes\" or \"No\")\n> ";
        String[] validAnswers = {"yes", "no", "quit"};
        System.out.print("You Won!!...play again? " + enterMessage);
        String userInput = bufferReader.readLine().toLowerCase().trim();
        while (!Arrays.asList(validAnswers).contains(userInput)) {
            System.out.print(enterMessage);
            userInput = bufferReader.readLine().toLowerCase().trim();
        }
        if (userInput.equals("yes")) {
            clearScreen();
            newGame();
            startGame();
        } else {
            stopGame();
        }
    }

    public static void printGameOver() throws IOException, InterruptedException {
        clearScreen();
        ArtText.displayFail();
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
            newGame();
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
        try {
            MusicHandler.music();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        JsonLocationParser.locationParser();
        ArtText.displayTitle();
        ArtText.displayIntroduction();
        TextParser.enterGame();
    }

    public static void playGame(User user, Location location, Day day)
            throws IOException, InterruptedException {
        consoleView = new ConsoleView(user, location, day);
        if (user.getHealthPoints() > 0 && day.getDay() < LAST_DAY_IN_GAME) {
            System.out.println(consoleView.getGameView());
            getUserInput();
        } else {
            printGameOver();
        }
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
            pauseTheGame();
            clearScreen();
            playGame(user, consoleView.getCurrentLocation(), day);
            getUserInput();
        }
        actionHandler(requestedAction, userInput);
    }

    public static void actionHandler(String requestedAction, String userInput)
            throws IOException, InterruptedException {
        switch (requestedAction) {
            case "go":
            case "travel":
            case "walk":
            case "trek":
            case "navigate":
            case "stroll":
            case "dash":
            case "skip":
            case "crawl":
            case "transit":
            case "move":
                goTo(userInput);
                break;
            case "consume":
                consumeItem(userInput);
                break;
            case "cry":
                cry();
                break;
            case "rest":
                rest();
                break;
            case "get":
            case "grab":
            case "grasp":
            case "collect":
            case "pickup":
            case "seize":
            case "take":
            case "hook":
            case "catch":
            case "acquire":
            case "fetch":
            case "snatch":
            case "grip":
            case "capture":
            case "dominate":
            case "clasp":
                grabItem(userInput);
                break;
            case "drop":
                dropItem(userInput);
                break;
            case "look":
            case "examine":
            case "stare":
            case "scrutinize":
            case "glance":
            case "peep":
                lookAtItems();
                break;
//                attempting to music off/on with user input
//            case "music on":
//                if (userInput.equals("music on")){
//                    MusicHandler.setMusic(true);
//                }
//                playGame(user, consoleView.getCurrentLocation(), day);
//                break;
//            case "music off":
//                if (userInput.equals("music off")){
//                    MusicHandler.setMusic(false);
//                }
//                playGame(user, consoleView.getCurrentLocation(), day);
//                break;
            case "quit":
                printGameOver();
                break;
            case "help":
                performHelp();
                TextParser.getUserInput();
                break;
            case "speak":
            case "talk":
            case "chat":
                talkToNPC();
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
        } else {
            clearScreen();
            day.increaseTimeOfDay(2);
            user.modifyHealthPoints(-20);
            clearScreen();
            System.out.println((printGoToScreen(userRequestedLocation)));
            pauseTheGame();
            clearScreen();
            playGame(user, mapLocations.locationHandler(userRequestedLocation), day);
        }
    }

    private static void pauseTheGame() throws InterruptedException {
        Thread.sleep(2500);
    }

    private static void lookAtItems() throws IOException, InterruptedException {
        System.out.println("\nThis is your current inventory:");
        for (Object inventory : user.getInventory()) {
            System.out.println(inventory);
        }
        System.out.print("\nWhat do you want to do?\n> ");
        String userInput = bufferReader.readLine().trim();
        userInput = "[" + userInput.toLowerCase() + "]";

        while (userInput.equals(user.getInventoryAsString().toLowerCase()) || (userInput.equals(
                "[cancel]"))) {
            if (userInput.equals(user.getInventoryAsString().toLowerCase())) {

                System.out.printf("You are looking at %s", user.getInventoryAsString());
                pauseTheGame();
            }
            clearScreen();
            playGame(user, mapLocations.locationHandler(userInput), day);
        }
        System.out.println("Sorry that item is not available");
        pauseTheGame();
        clearScreen();
        playGame(user, mapLocations.locationHandler(userInput), day);
    }

    private static void performHelp() {
        System.out.println((Action.printHelpMenu()));
    }

    private static void consumeItem(String rawUserInput) throws IOException, InterruptedException {
        if (!user.getInventoryConsumableStatus()) {
            System.out.println("No consumable items in inventory.");
            getUserInput();
        } else {
            String lowerCaseRawUserInput = rawUserInput.toLowerCase();
            var currentUserInventory = user.getInventory();
            var currentUserInventoryAsList = new ArrayList<>(Arrays.asList(currentUserInventory));
            boolean rawUserInputContainsEdible = false;
            int pointsToIncreaseHp = 0;                     // Counter for points to increase user hp
            // For each item in users inventory
            for (String item : currentUserInventory) {
                // Check if input contains a valid item from inventory and if item is consumable
                if (lowerCaseRawUserInput.contains(item) && MapLocation.CONSUMABLE_ITEMS.contains(
                        item)) {
                    if (!rawUserInputContainsEdible) {
                        rawUserInputContainsEdible = true;
                    }
                    pointsToIncreaseHp += 20;
                    currentUserInventoryAsList.remove(item);
                    if (item.equals("bottled water") || item.equals("bottled brown water")) {
                        currentUserInventoryAsList.add("empty bottle");
                    }
                }
            }
            if (!rawUserInputContainsEdible) {
                var consumablesList = new LinkedList<String>();
                for (String item : currentUserInventory) {
                    if (MapLocation.CONSUMABLE_ITEMS.contains(item)) {
                        consumablesList.add(item);
                    }
                }
                System.out.printf("Please provide the item(s) to consume: %s\n",
                        consumablesList.toString());
                getUserInput();
            } else {
                user.setInventory(
                        currentUserInventoryAsList.toArray(
                                new String[currentUserInventoryAsList.size()]));
                user.modifyHealthPoints(pointsToIncreaseHp);
                System.out.println("You feel reinvigorated and slightly increased your HP!");
                System.out.println(ArtText.CONSUME_ART);
                pauseTheGame();
                clearScreen();
                playGame(user, consoleView.getCurrentLocation(), day);
            }
        }
    }

    private static void cry() throws IOException, InterruptedException {
        user.modifyHealthPoints(5);
        day.increaseTimeOfDay(1);
        System.out.println(
                "In a fit of despair, you spend part of the day having a good cry and feel slightly better");
        System.out.println(ArtText.CRY_ART);
        pauseTheGame();
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void talkToNPC() throws IOException, InterruptedException {
        if (!consoleView.getCurrentLocation().getName().trim().equals("LOGARITHMIC LAKE".trim())) {
            System.out.println("Talk not available at this location.");
            pauseTheGame();
            clearScreen();
            playGame(user, consoleView.getCurrentLocation(), day);
            TextParser.getUserInput();
        } else {
            riddle();
        }
    }

    private static void riddle() throws InterruptedException, IOException {
        System.out.println(
                " You must answer this riddle. If correct, you will be rewarded, if not, punished you will be!\n");
        System.out.println(
                "I am taken from a mine, and shut up in a wooden case,\n from which I am never released, and yet I am used. What am I?");
        System.out.print("> ");
        String userInput = bufferReader.readLine().toLowerCase().trim();
        if (userInput.equals("candle")) {
            user.modifyHealthPoints(100);
            System.out.println("Correct! You must be at least somewhat intelligent");
            System.out.println("You've been fully healed");
            pauseTheGame();
            clearScreen();
            playGame(user, consoleView.getCurrentLocation(), day);
        } else {
            user.modifyHealthPoints(-20);
            System.out.println("No, dum dum, into the Bog with you!");
            System.out.println("You lost some health and time!");
            pauseTheGame();
            clearScreen();
            playGame(user, consoleView.getCurrentLocation(), day);
        }
    }

    private static void rest() throws IOException, InterruptedException {
        user.modifyHealthPoints(10);
        day.increaseTimeOfDay(2);
        System.out.println("You rest for a half a day and regain 10 HP");
        System.out.println(ArtText.REST_ART);
        pauseTheGame();
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void grabItem(String rawUserInput) throws IOException, InterruptedException {
        String upperCaseRawUserInput = rawUserInput.toUpperCase();
        String[] currentLocationItems = consoleView.getCurrentLocation().getItems();
        String itemToGrab = "";
        Boolean attemptedToGrabWaterWithoutEmptyBottle = false;
        var itemsList = new ArrayList<>(Arrays.asList(currentLocationItems));
        var currentUserInventory = user.getInventory();
        var newUserInventoryAsList = new ArrayList<>(Arrays.asList(currentUserInventory));
        // For each item in the current location
        for (String currentLocationItem : currentLocationItems) {
            if (upperCaseRawUserInput.contains(currentLocationItem.toUpperCase().trim())) {
                if (currentLocationItem.contains("water") && !newUserInventoryAsList.contains(
                        "empty bottle")) {
                    attemptedToGrabWaterWithoutEmptyBottle = true;
                    continue;
                } else {
                    // Grab item, update item into user inventory, and remove from location items
                    itemToGrab = currentLocationItem;
                    itemsList.remove(currentLocationItem);
                    newUserInventoryAsList.add(itemToGrab);
                }
            }
        }
        if (itemToGrab.isEmpty()) {
            String noEmptyBottleMessage = "Cannot pick up water without an empty bottle.";
            if (attemptedToGrabWaterWithoutEmptyBottle) {
                System.out.printf("Item not available. %s\n", noEmptyBottleMessage);
            } else {
                System.out.println("Item not available");
            }
            getUserInput();
        } else {
            consoleView.getCurrentLocation()
                    .setItems(itemsList.toArray(new String[itemsList.size()]));
            user.setInventory(
                    newUserInventoryAsList.toArray(new String[newUserInventoryAsList.size()]));
            handleBottleInUserInventory();
            doesUserInventoryContainEdibles();
            clearScreen();
            playGame(user, consoleView.getCurrentLocation(), day);
        }
    }

    private static String printGoToScreen(String requestedLocation) {
        switch (requestedLocation) {
            case "LANDING ZONE":
                return ArtText.travelingLandingZone;
            case "SANDY BEACH":
                return ArtText.travelingSandyBeach;
            case "COCO FOREST":
                return ArtText.travelingCocoForest;
            case "MOIST MARSHLAND":
                return ArtText.travelingMoistMarshland;
            case "SUS MOUNTAIN":
                return ArtText.travelingSusMountain;
            case "LOGARITHMIC LAKE":
                return ArtText.travelingLogarithmicLake;
            case "LUMINOUS LAGOON":
                return ArtText.travelingLuminousLagoon;
            default:
                return "NOT VALID LOCATION";
        }
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
            var locationItemsList = new ArrayList<>(
                    Arrays.asList(consoleView.getCurrentLocation().getItems()));
            // For every item to drop, remove it from the user inventory and it to the location items
            for (String item : itemsToDrop) {
                userInventoryList.remove(item);
                locationItemsList.add(item);
            }
            user.setInventory(userInventoryList.toArray(new String[userInventoryList.size()]));
            consoleView.getCurrentLocation()
                    .setItems(locationItemsList.toArray(new String[locationItemsList.size()]));
            doesUserInventoryContainEdibles();  // Update if there are still consumables in inventory
        }
        clearScreen();
        playGame(user, consoleView.getCurrentLocation(), day);
    }

    private static void doesUserInventoryContainEdibles() {
        Boolean changedFlag = false;
        for (String item : user.getInventory()) {
            if (MapLocation.CONSUMABLE_ITEMS.contains(item)) {
                user.setInventoryInventoryConsumableStatus();
                changedFlag = true;
                break;
            }
        }
        if (!changedFlag) {
            user.changeInventoryConsumableItemsStatus();
        }
    }

    private static void handleBottleInUserInventory() {
        var currentUserInventory = user.getInventory();
        var currentUserInventoryAsList = new ArrayList<>(Arrays.asList(currentUserInventory));
        if (currentUserInventoryAsList.contains("empty bottle")
                && currentUserInventoryAsList.contains(
                "water")) {
            currentUserInventoryAsList.remove("empty bottle");
            currentUserInventoryAsList.remove("water");
            currentUserInventoryAsList.add("bottled water");
        } else if (currentUserInventoryAsList.contains("empty bottle")
                && currentUserInventoryAsList.contains("brown water")) {
            currentUserInventoryAsList.remove("empty bottle");
            currentUserInventoryAsList.remove("brown water");
            currentUserInventoryAsList.add("bottled brown water");
        }
        user.setInventory(
                currentUserInventoryAsList.toArray(new String[currentUserInventoryAsList.size()]));
    }
}
