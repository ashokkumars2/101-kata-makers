package kata.rock.paper.scissors;

import static org.mockito.Mockito.when;

import java.util.List;
import kata.rock.paper.scissors.Game.Choices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GameTest {

  Computer computer = Mockito.mock(Computer.class);
  Input input = Mockito.mock(Input.class);
  Game game = new Game(computer, input);

  @Test
  public void playerOneWinsWithPaper() {
    when(computer.generateMove()).thenReturn(Choices.ROCK);
    when(input.getPlayerInput()).thenReturn(Choices.PAPER);
    String result = game.play();
    Assertions.assertEquals("One", result);
  }

  @Test
  public void playerOneWinsWithScissors() {
    when(computer.generateMove()).thenReturn(Choices.PAPER);
    when(input.getPlayerInput()).thenReturn(Choices.SCISSORS);
    String result = game.play();
    Assertions.assertEquals("One", result);
  }

  @Test
  public void playerOneWinsWithRock() {
    when(computer.generateMove()).thenReturn(Choices.SCISSORS);
    when(input.getPlayerInput()).thenReturn(Choices.ROCK);
    String result = game.play();
    Assertions.assertEquals("One", result);
  }

  @Test
  public void playerTwoWinsWithPaper() {
    when(computer.generateMove()).thenReturn(Choices.PAPER);
    when(input.getPlayerInput()).thenReturn(Choices.ROCK);
    String result = game.play();
    Assertions.assertEquals("Two", result);
  }

  @Test
  public void playerTwoWinsWithRock() {
    when(computer.generateMove()).thenReturn(Choices.ROCK);
    when(input.getPlayerInput()).thenReturn(Choices.SCISSORS);
    String result = game.play();
    Assertions.assertEquals("Two", result);
  }

  @Test
  public void playerTwoWinsWithScissors() {
    when(computer.generateMove()).thenReturn(Choices.SCISSORS);
    when(input.getPlayerInput()).thenReturn(Choices.PAPER);
    String result = game.play();
    Assertions.assertEquals("Two", result);
  }

  @Test
  public void draw() {
    when(computer.generateMove()).thenReturn(Choices.PAPER);
    when(input.getPlayerInput()).thenReturn(Choices.PAPER);
    String result = game.play();
    Assertions.assertEquals("Draw", result);
  }

  @Test
  public void threeRoundsHasThreeElementsAfterPlayingThreeRounds() {
    when(computer.generateMove())
        .thenReturn(Choices.ROCK)
        .thenReturn(Choices.PAPER)
        .thenReturn(Choices.SCISSORS);
    when(input.getPlayerInput())
        .thenReturn(Choices.ROCK)
        .thenReturn(Choices.SCISSORS)
        .thenReturn(Choices.PAPER);
    game.playThreeRounds();
    System.out.println(game.threeRounds);
    Assertions.assertEquals(3, game.threeRounds.size());
    Assertions.assertEquals("Draw", game.threeRounds.get(0));
    Assertions.assertEquals("One", game.threeRounds.get(1));
    Assertions.assertEquals("Two", game.threeRounds.get(2));
  }

  @Test
  public void shouldReturnPlayerTwoWinsIfPlayerTwoHasWonMoreRounds() {
    when(computer.generateMove())
        .thenReturn(Choices.SCISSORS)
        .thenReturn(Choices.PAPER)
        .thenReturn(Choices.SCISSORS);
    when(input.getPlayerInput())
        .thenReturn(Choices.PAPER)
        .thenReturn(Choices.ROCK)
        .thenReturn(Choices.SCISSORS);
    String result = game.checkWinnerAfterThreeRounds();
    Assertions.assertEquals("Player Two Wins", result);
  }

  @Test
  public void shouldReturnDrawIfNoPlayerHasWonMoreRoundsThanTheOther() {
    when(computer.generateMove())
        .thenReturn(Choices.ROCK)
        .thenReturn(Choices.ROCK)
        .thenReturn(Choices.ROCK);
    when(input.getPlayerInput())
        .thenReturn(Choices.ROCK)
        .thenReturn(Choices.ROCK)
        .thenReturn(Choices.ROCK);
    game.playThreeRounds();
    String result = game.checkWinnerAfterThreeRounds();
    Assertions.assertEquals("Draw", result);
  }

  @Test
  public void shouldReturnPlayerOneWinsIfPlayerOneHasWonMoreRounds() {
    when(computer.generateMove())
        .thenReturn(Choices.ROCK)
        .thenReturn(Choices.PAPER)
        .thenReturn(Choices.PAPER);
    when(input.getPlayerInput())
        .thenReturn(Choices.PAPER)
        .thenReturn(Choices.SCISSORS)
        .thenReturn(Choices.ROCK);
    String result = game.checkWinnerAfterThreeRounds();
    Assertions.assertEquals("Player One Wins", result);
  }
}