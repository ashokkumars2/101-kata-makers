package kata.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise {

  // Get me the first number greater than 100 from my List<Integer>

  public Integer greaterThanHundred(List<Integer> numbers) {
    return numbers.stream()
        .filter(number -> number > 100)
        .collect(Collectors.toList()).get(0);
  }


}
