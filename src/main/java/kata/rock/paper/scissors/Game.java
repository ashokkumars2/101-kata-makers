package kata.rock.paper.scissors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Game {

  public List<String> threeRounds = new ArrayList<>();
  private final Computer computer;

  public Game(Computer computer) {
    this.computer = computer;
  }

  enum Choices {
    ROCK,
    PAPER,
    SCISSORS
  }

  public String play(final Choices playerOneChoice) {
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

  public void playThreeRounds(List<Choices> playerOneChoices) {
    playerOneChoices.forEach(choices -> threeRounds.add(play(choices)));
  }

  public String checkWinnerAfterThreeRounds() {
    playThreeRounds(List.of(Choices.PAPER, Choices.ROCK, Choices.SCISSORS));
    if (Collections.frequency(threeRounds, "One") >= 2) {
      return "Player One Wins";
    } else if (Collections.frequency(threeRounds, "Two") >= 2) {
      return "Player Two Wins";
    } else {
      return "Draw";
    }
  }
}