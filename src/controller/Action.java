package controller;

import model.locations.Location;
import model.User;

public enum Action {

  GO,
  CONSUME,
  SWIM,
  CRY,
  REST,
  GRAB,
  HUG,
  DROP,
  ATTACK,
  RETREAT,
  LOOK;

  public boolean travelToValid(Location current, Location destination) {
    // TODO: 12/9/2022 Return boolean as to whether the user can go to the next location.
    // TODO: 12/9/2022 Call visibleLocation(Current) and determine if the destination we are going to is a possible location.
    // TODO: 12/9/2022 Takes care of GO option.
    return false;
  }

  public boolean canConsumeValid(User player) {
    // TODO: 12/9/2022 Determine if the user has an edible item in the inventory bag.
    // TODO: 12/9/2022 Consume item and increase HP.
    // player.increaseHealthPoints();
    return false;
  }
  
  public boolean canSwim(Location originalLocation) {
    // TODO: 12/10/22 Checks to see if there is water at the location
    // TODO: 12/10/22 If there is, swim. 
    // TODO: 12/10/22 Else, not available
    return false;
  }
  
  public boolean cry() {
    // TODO: 12/10/22 Return True if called on 
    return false;
  }
  
  public boolean canRest() {
    // TODO: 12/10/22 Increase hp by a certain amount
    // TODO: 12/10/22 Increase day counter/time 
    return false;
  }

  public boolean canHug() {
    // TODO: 12/10/22 Troll feature, can hug monkey unlimited times. True
    return false;
  }
  
  public boolean canGrab(Location location) {
    // TODO: 12/10/22 Check to see if there is any items to grab at the location
    // TODO: 12/10/22 If so, determine what item the user wants to grab from list 
    // TODO: 12/10/22 Returns true if user can grab specified item. 
    // TODO: 12/10/22 Returns false otherwise 
    return false;
  }

  public boolean canDrop(User user) {
    // TODO: 12/10/22 Ensure user does not have an empty inventory
    // TODO: 12/10/22 If they do not, gather feedback from user as to which item to drop
    // TODO: 12/10/22 Return true if item can be removed from inventory. 
    // TODO: 12/10/22 Returns false otherwise 
    return false;
  }
  
  public boolean canAttack() {
    // TODO: 12/10/22 Determine if there is a confrontation with a NPC, e.g., snake, lion, gator, etc.
    // TODO: 12/10/22 return true if so. False otherwise.
    return false;
  }

  public boolean canRetreat() {
    // TODO: 12/10/22 Determine if there is a confrontation with a NPC, e.g., snake, lion, gator, etc.
    // TODO: 12/10/22 return true if so. False otherwise.
    return false;
  }
  
  public void look(Location location) {
    // TODO: 12/10/22 Determine where the user is.
    // TODO: 12/10/22 Provide more information as to what the user can see.
  }
}
