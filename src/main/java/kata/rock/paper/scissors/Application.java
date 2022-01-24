package kata.rock.paper.scissors;


public class Application {

  public static void main(String[] args) {
    Computer computer = new Computer();
    Input input = new Input();
    Game game = new Game(computer, input);
    game.checkWinnerAfterThreeRounds();
  }
}
