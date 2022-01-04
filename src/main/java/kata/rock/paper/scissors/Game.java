package kata.rock.paper.scissors;

import java.util.List;
import java.util.Objects;
import kata.rock.paper.scissors.exception.IsNotRockPaperScissorsException;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Game {

  private Computer computer;

  public Game(Computer computer) {
    this.computer = computer;
  }

  enum Choices {
    ROCK,
    PAPER,
    SCISSORS
  }

  public String play(Choices playerOneChoice) {
    return checkWinner(playerOneChoice, computer.generateMove());
  }

  private static String checkWinner(Choices playerOneChoice, Choices playerTwoChoice) {
    if (playerOneChoice.equals(Choices.ROCK) && playerTwoChoice.equals(Choices.PAPER)) {
      return "Two";
    } else if (Objects.equals(playerOneChoice, Choices.SCISSORS) && Objects.equals(
        playerTwoChoice, Choices.PAPER)) {
      return "One";
    } else if (Objects.equals(playerOneChoice, Choices.PAPER) && Objects.equals(playerTwoChoice,
        Choices.ROCK)) {
      return "One";
    } else if (Objects.equals(playerOneChoice, Choices.PAPER) && Objects.equals(playerTwoChoice,
        Choices.SCISSORS)) {
      return "Two";
    } else if (Objects.equals(playerOneChoice, Choices.SCISSORS) && Objects.equals(
        playerTwoChoice, Choices.ROCK)) {
      return "Two";
    } else if (Objects.equals(playerOneChoice, Choices.ROCK) && Objects.equals(playerTwoChoice,
        Choices.SCISSORS)) {
      return "One";
    } else {
      return "Draw";
    }
  }
}