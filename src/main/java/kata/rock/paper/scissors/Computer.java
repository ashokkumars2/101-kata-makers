package kata.rock.paper.scissors;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import kata.rock.paper.scissors.Game.Choices;

public class Computer {

  public Choices generateMove() {
    Random random = new Random();
    List<Choices> choices = Arrays.asList(Choices.ROCK, Choices.SCISSORS, Choices.PAPER);
    return choices.get(random.nextInt(choices.size()));
  }
}
