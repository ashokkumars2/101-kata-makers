package kata.makers.model;

public class SkiRiding {

  private SkiRider skiRider;

  public SkiRider buyASkiPass(int id, String name, SkiPass skiPass){
    return new SkiRider(id, name, skiPass.getNoOfRides());
  }

  public int rideTheSlopeWithDifferentSkiPasses(SkiRider skiRider){
    int noOfRidesLeftForTheRider = skiRider.getNoOfRidesLeft() - 1;
    skiRider.setNoOfRidesLeft(noOfRidesLeftForTheRider);
    return noOfRidesLeftForTheRider;
  }
}
