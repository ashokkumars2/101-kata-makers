package kata.rock.paper.scissors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void playerOneWins() {
        String result = Game.play("Rock", "Paper");
        Assertions.assertEquals("One", result);
    }

    @Test
    public void playerTwoWins() {
        String result = Game.play("Paper", "Rock");
        Assertions.assertEquals("Two", result);
    }

    @Test
    public void draw() {
        String result = Game.play("Paper", "Paper");
        Assertions.assertEquals("Draw", result);
    }
}