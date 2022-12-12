package com.carnivalexiles.model;

import com.carnivalexiles.controller.TextParser;
import com.carnivalexiles.view.WelcomeScreen;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Print opening dialogue
        System.out.println(System.lineSeparator().repeat(50));
        WelcomeScreen.displayTitle();
        WelcomeScreen.displayIntroduction();
        TextParser.enterGame();
    }

}