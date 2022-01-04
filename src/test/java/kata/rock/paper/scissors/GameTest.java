package kata.rock.paper.scissors;

import static org.mockito.Mockito.when;

import kata.rock.paper.scissors.Game.Choices;
import kata.rock.paper.scissors.exception.IsNotRockPaperScissorsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GameTest {

  Computer computer = Mockito.mock(Computer.class);
  Game game = new Game(computer);

  @Test
  public void playerOneWinsWithPaper() {
    when(computer.generateMove()).thenReturn(Choices.ROCK);
    String result = game.play(Choices.PAPER);
    Assertions.assertEquals("One", result);
  }

  @Test
  public void playerOneWinsWithScissors() {
    when(computer.generateMove()).thenReturn(Choices.PAPER);
    String result = game.play(Choices.SCISSORS);
    Assertions.assertEquals("One", result);
  }

  @Test
  public void playerOneWinsWithRock() {
    when(computer.generateMove()).thenReturn(Choices.SCISSORS);
    String result = game.play(Choices.ROCK);
    Assertions.assertEquals("One", result);
  }

  @Test
  public void playerTwoWinsWithPaper() {
    when(computer.generateMove()).thenReturn(Choices.PAPER);
    String result = game.play(Choices.ROCK);
    Assertions.assertEquals("Two", result);
  }

  @Test
  public void playerTwoWinsWithRock() {
    when(computer.generateMove()).thenReturn(Choices.ROCK);
    String result = game.play(Choices.SCISSORS);
    Assertions.assertEquals("Two", result);
  }

  @Test
  public void playerTwoWinsWithScissors() {
    when(computer.generateMove()).thenReturn(Choices.SCISSORS);
    String result = game.play(Choices.PAPER);
    Assertions.assertEquals("Two", result);
  }

  @Test
  public void draw() {
    when(computer.generateMove()).thenReturn(Choices.PAPER);
    String result = game.play(Choices.PAPER);
    Assertions.assertEquals("Draw", result);
  }

//  @Test
//  public void bestOfThree() {
//
//    Assertions.assertEquals();
//  }
}