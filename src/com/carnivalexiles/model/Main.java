package com.carnivalexiles.model;

import com.carnivalexiles.view.WelcomeScreen;

public class Main {
  public static void main(String[] args) {
    //Print opening dialogue
    WelcomeScreen.displayTitle();
    WelcomeScreen.displayIntroduction();
    //Prompt user for input to play the game (Y/N)
    WelcomeScreen.playGame();
  }
}