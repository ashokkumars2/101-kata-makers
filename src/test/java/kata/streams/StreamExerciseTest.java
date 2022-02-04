package kata.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    assertEquals(101, streamExercise.greaterThanHundred(numbers));
  }

  @Test
  public void averageAge() {
    List<Pupil> pupils = new ArrayList<>();
    pupils.add(new Pupil(2));
    pupils.add(new Pupil(7));
    pupils.add(new Pupil(5));
    pupils.add(new Pupil(12));
    assertEquals(6.5, StreamExercise.averageAge(pupils));

  }

}