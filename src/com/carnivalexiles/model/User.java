package com.carnivalexiles.model;

public class User {

    //Fields
    private int healthPoints;
    private String[] inventory = new String[4];

  public User(int healthPoints, String[] inventory) {
    setHealthPoints(healthPoints);
    setInventory(inventory);
  }

  //Methods
    public String requestedAction() {
      // TODO: 12/9/2022 Capture the action the user wants to take and send it to the controller.

      return null;
    }
    
    public String travelToLocation() {
      // TODO: 12/9/2022 Capture the go to "Location" phrase and send it to the controller.
      // TODO: 12/9/2022 Calls on Action travelToValid to determine if feasible.
      return null;
    }

    public void increaseHealthPoints(int increasePoints) {
    healthPoints = getHealthPoints() + increasePoints;
    }

    //Getters and Setters

  public int getHealthPoints() {
    return healthPoints;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  public String[] getInventory() {
    return inventory;
  }

  public void setInventory(String[] inventory) {
    this.inventory = inventory;
  }
}
