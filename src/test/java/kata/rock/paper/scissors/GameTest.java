package kata.rock.paper.scissors;

import kata.rock.paper.scissors.exception.IsNotRockPaperScissorsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void playerOneWinsWithPaper() throws IsNotRockPaperScissorsException {
        String result = Game.play("Paper", "Rock");
        Assertions.assertEquals("One", result);
    }

    @Test
    public void playerOneWinsWithScissors() throws IsNotRockPaperScissorsException {
        String result = Game.play("Scissors", "Paper");
        Assertions.assertEquals("One", result);
    }

    @Test
    public void playerOneWinsWithRock() throws IsNotRockPaperScissorsException {
        String result = Game.play("Rock", "Scissors");
        Assertions.assertEquals("One", result);
    }

    @Test
    public void playerTwoWinsWithPaper() throws IsNotRockPaperScissorsException {
        String result = Game.play("Rock", "Paper");
        Assertions.assertEquals("Two", result);
    }

    @Test
    public void playerTwoWinsWithRock() throws IsNotRockPaperScissorsException {
        String result = Game.play("Scissors", "Rock");
        Assertions.assertEquals("Two", result);
    }

    @Test
    public void playerTwoWinsWithScissors() throws IsNotRockPaperScissorsException {
        String result = Game.play("Paper", "Scissors");
        Assertions.assertEquals("Two", result);
    }

    @Test
    public void draw() throws IsNotRockPaperScissorsException {
        String result = Game.play("Paper", "Paper");
        Assertions.assertEquals("Draw", result);
    }

    @Test
    public void invalidInputThrowsException() {
        Assertions.assertThrows(IsNotRockPaperScissorsException.class, () -> Game.play("Banana", "Paper"));
        Assertions.assertThrows(IsNotRockPaperScissorsException.class, () -> Game.play("Rock", "Banana"));

    }
}