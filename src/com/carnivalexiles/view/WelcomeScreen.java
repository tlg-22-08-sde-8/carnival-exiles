package com.carnivalexiles.view;

import java.io.IOException;
import com.carnivalexiles.controller.TextParser;

public class WelcomeScreen {

    public static void displayTitle(){
        // TODO 12/11/2022: ASCII Title Text: Sprint 2
        System.out.println("\nWelcome to Carnival Exiles! \n");
    }

    public static void displayIntroduction() throws IOException {
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
        System.out.println("Would you like to start your true vacation adventure? (Y or Exit)" );
        //Parse the user's response, if they agree, play the game, if not, exit the application
        TextParser.playGame();
    }
}
