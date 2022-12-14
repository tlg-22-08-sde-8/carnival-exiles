package com.carnivalexiles.model;

import java.util.Arrays;

public class User {

  //Fields
  private int healthPoints;
  private String[] inventory;

  public User(int healthPoints, String[] inventory) {
    setHealthPoints(healthPoints);
    setInventory(inventory);
  }

  public void increaseHealthPoints(int increasePoints) {
    healthPoints = getHealthPoints() + increasePoints;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  public String[] getInventory() {
    return inventory;
  }

  public String getInventoryAsString() {
    // TODO: 12/12/22 Modify the output to come out cleaner, i.e., reading from the array
    // TODO: will create funky output.
    return Arrays.toString(inventory);
  }

  public void setInventory(String[] inventory) {
    this.inventory = inventory;
  }
}
