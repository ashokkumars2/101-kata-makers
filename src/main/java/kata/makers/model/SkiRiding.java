package kata.makers.model;

import kata.makers.exception.SkiPassExpiredException;

public class SkiRiding {

  private SkiRider skiRider;

  public SkiRider buyASkiPass(int id, String name, SkiPass skiPass){
    return new SkiRider(id, name, skiPass.getNoOfRides());
  }

  public int rideTheSlopeWithDifferentSkiPasses(SkiRider skiRider) throws SkiPassExpiredException {
    int noOfRidesLeftForTheRider = skiRider.getNoOfRidesLeft();
    if (noOfRidesLeftForTheRider < 1) {
      throw new SkiPassExpiredException("Ski pass is expired.");
    }
    skiRider.setNoOfRidesLeft(noOfRidesLeftForTheRider - 1);
    return noOfRidesLeftForTheRider;
  }
}
