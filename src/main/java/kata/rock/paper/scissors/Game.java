package kata.rock.paper.scissors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Game {

  public List<String> threeRounds = new ArrayList<>();
  private final Computer computer;
  private final Input input;

  public Game(Computer computer, Input input) {
    this.computer = computer;
    this.input = input;
  }

  enum Choices {
    ROCK,
    PAPER,
    SCISSORS
  }

  public String play() {
    return checkWinner(input.getPlayerInput(), computer.generateMove());
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

  public void playThreeRounds() {
    for (int i = 0; i < 3; i++) {
      threeRounds.add(play());
    }
  }

  public String checkWinnerAfterThreeRounds() {
    playThreeRounds();
    if (Collections.frequency(threeRounds, "One") > Collections.frequency(threeRounds, "Two")) {
      System.out.println("Player One Wins");
      return "Player One Wins";
    } else if (Collections.frequency(threeRounds, "Two") > Collections.frequency(threeRounds, "One")) {
      System.out.println("Player Two Wins");
      return "Player Two Wins";
    } else {
      System.out.println("Draw");
      return "Draw";
    }
  }
}