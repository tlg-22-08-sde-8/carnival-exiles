package com.carnivalexiles.model;

import com.carnivalexiles.controller.TextParser;
import com.carnivalexiles.view.WelcomeScreen;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Print opening dialogue


        TextParser.clearScreen();
        TextParser.startGame();
    }
}