package com.carnivalexiles.model.locations;

public abstract class Location {

    //Fields
    private String description;
    private String name;
    private String[] items = new String[10];
    private String visibleLocations;


    //Ctor
    public Location(String description, String name, String[] items, String visibleLocations) {
        setDescription(description);
        setName(name);
        setItems(items);
        setVisibleLocations(visibleLocations);
    }

    //Methods

    //Getters and Setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String getVisibleLocations() {
        return visibleLocations;
    }

    public void setVisibleLocations(String visibleLocations) {
        this.visibleLocations = visibleLocations;
    }
}
