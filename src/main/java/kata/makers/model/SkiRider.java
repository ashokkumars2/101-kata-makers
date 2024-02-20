package kata.makers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkiRider {

  private int id;
  private String name;
  private int noOfRidesLeft;


  public SkiRider(int id, String name, int noOfRidesLeft) {
    this.id = id;
    this.name = name;
    this.noOfRidesLeft = noOfRidesLeft;
  }
}
