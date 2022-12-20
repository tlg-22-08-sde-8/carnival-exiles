package com.carnivalexiles.model;

import com.carnivalexiles.controller.TextParser;

import java.io.IOException;

public class Day {

    private int day;
    private int timeOfDayCounter;
    private static final String[] timeOfDay = {"dawn", "noon", "dusk", "night"};

    public Day() {
        this.day = 0;
    }

    public int getDay() throws IOException, InterruptedException {
        // If day reaches 7, end the game.
        if (day == 7) {
            // if user makes it to day 7 then bring up win scenario method.
            TextParser.printGameWin();
        }
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTimeOfDay() {
        return timeOfDay[timeOfDayCounter];
    }

    public void increaseTimeOfDay() {
        timeOfDayCounter++;
        if (timeOfDayCounter > timeOfDay.length - 1) {
            day++;
            timeOfDayCounter = 0;
        }
    }

    public void increaseTimeOfDay(int numberToIncrease) {
        if (numberToIncrease < 1 || numberToIncrease > 3) {
            throw new IllegalArgumentException("Invalid number to increase time of day");
        }
        int tempTimeOfDayCounter = timeOfDayCounter + numberToIncrease;
        if (tempTimeOfDayCounter > timeOfDay.length - 1) {
            day++;
            timeOfDayCounter = tempTimeOfDayCounter - (timeOfDay.length - 1);
        } else {
            timeOfDayCounter = tempTimeOfDayCounter;
        }
    }
}
