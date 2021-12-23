package kata.rock.paper.scissors;

import kata.rock.paper.scissors.Game.Choices;
import kata.rock.paper.scissors.exception.IsNotRockPaperScissorsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

  @Test
  public void playerOneWinsWithPaper() throws IsNotRockPaperScissorsException {
    String result = Game.play(Choices.PAPER, Choices.ROCK);
    Assertions.assertEquals("One", result);
  }

  @Test
  public void playerOneWinsWithScissors() throws IsNotRockPaperScissorsException {
    String result = Game.play(Choices.SCISSORS, Choices.PAPER);
    Assertions.assertEquals("One", result);
  }

  @Test
  public void playerOneWinsWithRock() throws IsNotRockPaperScissorsException {
    String result = Game.play(Choices.ROCK, Choices.SCISSORS);
    Assertions.assertEquals("One", result);
  }

  @Test
  public void playerTwoWinsWithPaper() throws IsNotRockPaperScissorsException {
    String result = Game.play(Choices.ROCK, Choices.PAPER);
    Assertions.assertEquals("Two", result);
  }

  @Test
  public void playerTwoWinsWithRock() throws IsNotRockPaperScissorsException {
    String result = Game.play(Choices.SCISSORS, Choices.ROCK);
    Assertions.assertEquals("Two", result);
  }

  @Test
  public void playerTwoWinsWithScissors() throws IsNotRockPaperScissorsException {
    String result = Game.play(Choices.PAPER, Choices.SCISSORS);
    Assertions.assertEquals("Two", result);
  }

  @Test
  public void draw() throws IsNotRockPaperScissorsException {
    String result = Game.play(Choices.PAPER, Choices.PAPER);
    Assertions.assertEquals("Draw", result);
  }
}