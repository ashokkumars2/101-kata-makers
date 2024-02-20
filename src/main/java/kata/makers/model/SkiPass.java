package kata.makers.model;

import lombok.Getter;

@Getter
public enum SkiPass {
  NORMAL(1),
  UNIQUE(5);

  private int noOfRides;

  SkiPass(int numberOfRides) {
    noOfRides = numberOfRides;
  }
}
