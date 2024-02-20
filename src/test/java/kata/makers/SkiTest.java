package kata.makers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import kata.makers.exception.SkiPassExpiredException;
import kata.makers.model.SkiPass;
import kata.makers.model.SkiRider;
import kata.makers.model.SkiRiding;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SkiTest {

  private SkiRiding skiRiding;
  @BeforeEach
  void setUp(){
    skiRiding = new SkiRiding();
  }
  @Test
  void skiRiderBuysANormalSkiPass(){
      SkiRider skiRider = skiRiding.buyASkiPass(1, "Person1", SkiPass.NORMAL);
      assertEquals(1, skiRider.getNoOfRidesLeft());
  }

  @Test
  void skiRiderRideOnlyOnceWithNormalSkiPass() throws SkiPassExpiredException {
    SkiRider skiRider = skiRiding.buyASkiPass(1, "Person1", SkiPass.NORMAL);
    assertEquals(0, skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider));
  }

  @Test
  void throwExceptionWhenSkiRiderRidesMoreThanOnceWithNormalSkiPass()
      throws SkiPassExpiredException {
    SkiRider skiRider = skiRiding.buyASkiPass(1, "Person1", SkiPass.NORMAL);
    skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider);
    assertThrows(SkiPassExpiredException.class,
        () -> skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider));
  }

  @Test
  void skiRiderRideFiveTimesWithUniqueSkiPass() throws SkiPassExpiredException {
    SkiRider skiRider = skiRiding.buyASkiPass(1, "Person1", SkiPass.UNIQUE);
    assertEquals(4, skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider));
  }


  @Test
  void skiRiderRideOnlyFiveTimesWithUniqueSkiPass() throws SkiPassExpiredException {
    SkiRider skiRider = skiRiding.buyASkiPass(1, "Person1", SkiPass.UNIQUE);
    skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider);
    skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider);
    skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider);
    skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider);
    skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider);
    assertThrows(SkiPassExpiredException.class,
        () -> skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider));
  }

  @Test
  void twoSkiRidersRideWithTheirOwnSkiPass() throws SkiPassExpiredException {
    SkiRider skiRider = skiRiding.buyASkiPass(1, "Person1", SkiPass.UNIQUE);
    SkiRider secondRider = skiRiding.buyASkiPass(2, "Person2", SkiPass.NORMAL);
    assertEquals(4, skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider));
    assertEquals(0, skiRiding.rideTheSlopeWithDifferentSkiPasses(secondRider));
  }


}
