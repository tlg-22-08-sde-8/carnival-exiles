package com.carnivalexiles.view;

public class WelcomeScreen {
  public static final String GREEN = "\033[0;32m";   // GREEN
  public static final String RESET = "\033[0m";  // Text Reset

  public static void displayTitle(){
    // TODO 12/11/2022: ASCII Title Text: Sprint 2
    System.out.println(GREEN + "\nWelcome to Carnival Exiles!\n" + RESET);
  }

  public static void displayIntroduction() {
    System.out.println("Taking a vacation to celebrate your recent promotion, " +
            "you found yourself on the biggest Carnival cruise ship in the world! \n" +
            "\tHankering for some pankering, you went to the port-side buffet. \n" +
            "\tAs you reached for the last piece of bacon, after stuffing a dozen in " +
            "your trusty waterproof fanny pack, \n" +
            "\ta hungover ruffian fights you for the piece and throws you overboard. \n" +
            "\tAs you plummet to the unseen depths below, you quickly munch on the crispy " +
            "applewood smoked bacon and feel victorious. \n\n" +
            "... Sometime later, you wake up to a monkey bonking you on the head with a " +
            "bottle on a mysterious Island all while its eating your fanny pack bacon… \n");
    //Check to see if user would like to play the game
    //System.out.println("Would you like to start your true vacation adventure? (Any Key or 'Quit')" );
  }

  public static void displayObjective() {
    System.out.println("To escape the island and beat the game, you must survive for seven days!\n"
        + "Explore the lands! Interact with the wildlife! Eat some interesting food!\n"
        + "Do not let your health points or HP fall below zero!\n\n"
        + "P.S. Watch out for traps!\n");

    System.out.println("Would you like to start your true vacation adventure? (Any Key or 'Quit')" );
  }

}
