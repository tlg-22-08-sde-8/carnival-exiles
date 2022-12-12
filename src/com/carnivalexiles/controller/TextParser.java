package com.carnivalexiles.controller;

import com.carnivalexiles.model.locations.Beach;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextParser {

    //Check user input for Game Initiation
    public static void playGame() throws IOException {
        //Retrieve user Input to play the game until they type 'q'
        BufferedReader br;
        String input;
        br = new BufferedReader(new InputStreamReader(System.in));
        do {
            // place game logic code here. When user types q, game quits
            System.out.print("> ");
            input = br.readLine();
            System.out.println("You entered '" + input + "'");
        } while (!"Quit".equals(input));

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
}
