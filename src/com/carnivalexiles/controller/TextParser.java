package com.carnivalexiles.controller;

import com.carnivalexiles.model.locations.Beach;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextParser {

    //Check user input for Game Initiation
    public static void playGame() throws IOException {
        //TODO 12/11/2022 Retrieve user Input if they would like to play the game
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();
        System.out.println(userInput);
        //TODO 12/11/2022 Check user input for an affirmitive response to continue
        if (userInput == "Y" || userInput == "y") {
            System.out.println(userInput);
            System.out.println("Executing application");
            // TODO 12/11/2022 game initiation, Main()? Action()?
            //Call Beach method in the Beach location
            Beach.Beach();
        }
        //If user didn't type Y or y, then close the application
        else {
            System.out.println(userInput);
            System.out.println("Exiting application");
            //TODO 12/11/2022 Call exitGame() method;
        }
    }
    // TODO: 12/9/2022 Parse the initial text and see if its valid
    // TODO: 12/9/2022 If valid then send the match to its named method
    // TODO: 12/9/2022 if (UserAction != null) { }
    // TODO: 12/9/2022 Switch
    // TODO: 12/9/2022 is userAction == Consume?
    // TODO: 12/9/2022 is userAction == Go TO?
    // TODO: 12/9/2022 is userAction == PickUP?

    // TODO: 12/9/2022 Action method perform the action that's matched
    // TODO: 12/9/2022 Go To method will send the user to a location
    // TODO: 12/9/2022 Consume method
}
