package kata.rock.paper.scissors;

import java.util.Objects;

public class Game {
    public static String play(String playerOne, String playerTwo) {
        if (Objects.equals(playerOne, "Rock") && Objects.equals(playerTwo, "Paper")) {
            return "One";
        } else if (playerOne.equals(playerTwo)) {
            return "Draw";
        } else {
            return "Two";
        }
    }
}
