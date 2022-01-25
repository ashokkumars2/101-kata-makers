package kata.rock.paper.scissors;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import kata.rock.paper.scissors.Game.Choices;

public class Computer {

  public Choices generateMove() {
    Random random = new Random();
    List<Choices> choices = Arrays.asList(Choices.ROCK, Choices.SCISSORS, Choices.PAPER);
    Choices computerChoice = choices.get(random.nextInt(choices.size()));
    System.out.println(computerChoice);
    return computerChoice;
  }

  public Integer greaterThanHundred(List<Integer> numbers) {

    return numbers.stream()
        .filter(number -> number > 100)
        .collect(Collectors.toList()).get(0);
  }


}
