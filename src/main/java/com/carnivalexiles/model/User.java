package com.carnivalexiles.model;

import java.util.Arrays;

public class User {

    //Fields
    private int healthPoints;
    private String[] inventory;
    private boolean inventoryContainsConsumableItems;         // Tell me if user's inventory contains consumable item

    public User(int healthPoints, String[] inventory) {
        setHealthPoints(healthPoints);
        setInventory(inventory);
    }

    public void modifyHealthPoints(int hpPointsToModifyBy) {
        setHealthPoints(hpPointsToModifyBy);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (this.healthPoints + healthPoints >= 100) {
            this.healthPoints = 100;
        } else {
            this.healthPoints = this.healthPoints + healthPoints;
        }
    }

    public String[] getInventory() {
        return inventory;
    }

    public boolean getInventoryConsumableStatus() {
        return inventoryContainsConsumableItems;
    }

    public void setInventoryInventoryConsumableStatus() {
        this.inventoryContainsConsumableItems = true;
    }

    public void changeInventoryConsumableItemsStatus() {
        inventoryContainsConsumableItems = !inventoryContainsConsumableItems;
    }

    public String getInventoryAsString() {
        return Arrays.toString(inventory);
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

}
