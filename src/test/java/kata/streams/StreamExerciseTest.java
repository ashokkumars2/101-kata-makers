package kata.streams;

import java.util.ArrayList;
import java.util.List;
import kata.streams.StreamExercise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamExerciseTest {


  // Get me the first number greater than 100 from my List<Integer>

  @Test
  public void firstNumberGreaterThanHundred() {
    StreamExercise streamExercise = new StreamExercise();
    List<Integer> numbers = new ArrayList<>();
    numbers.add(20);
    numbers.add(100);
    numbers.add(101);
    numbers.add(133);
    Assertions.assertEquals(101, streamExercise.greaterThanHundred(numbers));
  }

}