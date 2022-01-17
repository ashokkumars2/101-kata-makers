package kata.rock.paper.scissors;

import java.util.Scanner;
import kata.rock.paper.scissors.Game.Choices;

public class Input {

  public String getPlayerInput() {

    Scanner playerInput = new Scanner(System.in);
    System.out.println("Choose your weapon: ");
    String playerChoice = playerInput.nextLine();
    Choices scanner = Choices.valueOf(playerChoice);
    System.out.println(scanner);
    return playerChoice;
  }

}
