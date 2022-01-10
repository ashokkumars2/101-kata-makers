package kata.rock.paper.scissors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kata.rock.paper.scissors.exception.IsNotRockPaperScissorsException;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Game {

  public List<String> threeRounds = new ArrayList<>();
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

  public List<String> playThreeRounds() {
    for (int i = 0; i < 3; i++) {
      threeRounds.add(play(Choices.ROCK));
    }
    return threeRounds;
  }

  public String checkWinnerAfterThreeRounds() {
    playThreeRounds();
    if (Collections.frequency(threeRounds, "One") >= 2) {
      return "Player One Wins";
    } else if (Collections.frequency(threeRounds, "Two") >= 2) {
      return "Player Two Wins";
    } else {
      return "Draw";
    }
  }
}