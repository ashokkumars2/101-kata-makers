package kata.rock.paper.scissors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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

  // Get me the first number greater than 100 from my List<Integer>

  @Test
  public void firstNumberGreaterThanHundred() {
    Computer computer = new Computer();
    List<Integer> numbers = new ArrayList<>();
    numbers.add(20);
    numbers.add(100);
    numbers.add(101);
    numbers.add(133);
    Assertions.assertEquals(101, computer.greaterThanHundred(numbers));
  }
}
