package kata.rock.paper.scissors;

import java.util.ArrayList;
import java.util.List;
import kata.rock.paper.scissors.Game.Choices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {

  @Test
  public void computerGeneratesRandomMove() {

    List<Choices> generatedList = new ArrayList<>();
    Computer computer = new Computer();

    for(int i=0; i < 100; i++) {
      generatedList.add(computer.generateMove());
    }
    Assertions.assertTrue(generatedList.contains(Choices.PAPER));
    Assertions.assertTrue(generatedList.contains(Choices.ROCK));
    Assertions.assertTrue(generatedList.contains(Choices.SCISSORS));


  }
}
