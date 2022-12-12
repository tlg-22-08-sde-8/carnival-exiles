package model;

public class Day {
  private int day;
  private String timeOfDay;

  public Day() {
    this.day = 0;
    this.timeOfDay = "Morning";
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public String getTimeOfDay() {
    return timeOfDay;
  }

  public void setTimeOfDay(String timeOfDay) {
    this.timeOfDay = timeOfDay;
  }
}
