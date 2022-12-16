package com.carnivalexiles.model.locations;

public class Location {

    //Fields
    private String description;
    private String name;
    private String[] items;
    private String visibleLocations;

    //Ctor
    public Location(String description, String name, String[] items, String visibleLocations) {
        setDescription(description);
        setName(name);
        setItems(items);
        setVisibleLocations(visibleLocations);
    }

    //Methods


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
        if (this.items.length == 0) {
            return new String[]{};
        }
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
