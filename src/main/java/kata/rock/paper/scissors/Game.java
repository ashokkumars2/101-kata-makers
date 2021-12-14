package kata.rock.paper.scissors;

import kata.rock.paper.scissors.exception.IsNotRockPaperScissorsException;

import java.util.List;
import java.util.Objects;

public class Game {

    public static final String SCISSORS = "Scissors";
    public static final String PAPER = "Paper";
    public static final String ROCK = "Rock";

    public static String play(String playerOneChoice, String playerTwoChoice) throws IsNotRockPaperScissorsException {
        List<String> validInputs = List.of(ROCK, PAPER, SCISSORS);

        if (validInputs.contains(playerOneChoice) && (validInputs.contains(playerTwoChoice))) {
            return checkWinner(playerOneChoice, playerTwoChoice);
        } else {
            throw new IsNotRockPaperScissorsException();
        }
    }

    private static String checkWinner(String playerOneChoice, String playerTwoChoice) {
        if (Objects.equals(playerOneChoice, ROCK) && Objects.equals(playerTwoChoice, PAPER)) {
            return "Two";
        } else if (Objects.equals(playerOneChoice, SCISSORS) && Objects.equals(playerTwoChoice, PAPER)) {
            return "One";
        } else if (Objects.equals(playerOneChoice, PAPER) && Objects.equals(playerTwoChoice, ROCK)) {
            return "One";
        } else if (Objects.equals(playerOneChoice, PAPER) && Objects.equals(playerTwoChoice, SCISSORS)) {
            return "Two";
        } else if (Objects.equals(playerOneChoice, SCISSORS) && Objects.equals(playerTwoChoice, ROCK)) {
            return "Two";
        } else if (Objects.equals(playerOneChoice, ROCK) && Objects.equals(playerTwoChoice, SCISSORS)) {
            return "One";
        } else {
            return "Draw";
        }
    }
}
