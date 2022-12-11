package com.carnivalexiles.view;


public class WelcomeScreen {

  public static void displayTitle(){
    // TODO: ASCII Title Text: Sprint 2
    System.out.println("Welcome to Carnival Exiles! \n\n");
  }

  public static void displayIntroduction(){
    System.out.println("Taking a vacation to celebrate your recent promotion, " +
            "you found yourself on the biggest Carnival cruise ship in the world \n" +
            "Hankering for some pankering, you went to the port-side buffet. \n" +
            "As you reached for the last piece of bacon, after stuffing a dozen in " +
            "your trusty waterproof fanny pack, \n" +
            "a hungover ruffian fights you for the piece and throws you overboard. \n" +
            "As you plummet to the unseen depths below, you quickly munch on the crispy " +
            "applewood smoked bacon and feel victorious. \n\n\n" +
            "... Sometime later, you wake up to a monkey bonking you on the head with a " +
            "bottle on a mysterious Island all while its eating your fanny pack bacon… \n\n");
  }

  public static void playGame(){
    String userInput = "Y";
    System.out.println("Would you like to start your true vacation adventure?");
    //TODO Retrieve user Input if they would like to play the game
    if ((userInput.toUpperCase() != "Y") || (userInput.toUpperCase() != "YES")){
      //TODO exit game/close game
    }
    return;
  }
}
