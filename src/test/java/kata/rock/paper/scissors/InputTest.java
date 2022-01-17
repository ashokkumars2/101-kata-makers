package kata.rock.paper.scissors;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kata.rock.paper.scissors.Game.Choices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputTest {

  @Test
  public void testPlayerInput() {
    Input playerOneInput = new Input();
    String input = "ROCK";
    Choices stringToEnum = Choices.valueOf(input);
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Assertions.assertEquals(input, playerOneInput.getPlayerInput());
    Assertions.assertSame(stringToEnum, Choices.ROCK);
  }

}