package kata.makers;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  void skiRiderRideOnlyOnceWithNormalSkiPass(){
    SkiRider skiRider = skiRiding.buyASkiPass(1, "Person1", SkiPass.NORMAL);
    assertEquals(0, skiRiding.rideTheSlopeWithDifferentSkiPasses(skiRider));
  }



}
