package com.carnivalexiles.controller;

import com.carnivalexiles.model.locations.Location;
import com.carnivalexiles.model.User;

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
    // TODO: 12/9/2022  Return whether the user can go to the next location.
    // TODO: 12/9/2022 Call visibleLocation(Current) and determine if the destination we are going to is a possible location.
    // TODO: 12/9/2022 Takes care of GO option.
    return false;
  }

  public boolean canConsumeValid(User player) {
    // TODO: 12/9/2022 Determine if the user has an edible item in the inventory bag.
    // TODO: 12/9/2022 Consume item and increase HP.
    player.setHealthPoints(10);
    return false;
  }

}
