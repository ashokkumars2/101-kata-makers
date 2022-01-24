package kata.rock.paper.scissors;

import java.util.Locale;
import java.util.Scanner;
import kata.rock.paper.scissors.Game.Choices;

public class Input {

  public Choices getPlayerInput() {

    Scanner playerInput = new Scanner(System.in);
    System.out.println("Choose your weapon: ");
    String playerChoice = playerInput.nextLine().toUpperCase(Locale.ROOT);
    return Choices.valueOf(playerChoice);
  }

}
