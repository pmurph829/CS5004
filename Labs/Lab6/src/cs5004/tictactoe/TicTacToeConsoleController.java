package cs5004.tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * Implementation of the TicTacToeController interface that allows players to play TicTacToe
 * through a console interface.
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private final Readable in;
  private final Appendable out;
  private final TicTacToeModel ttt = new TicTacToeModel();

  /**
   * Constructor for the TicTacToeConsoleController.
   * @param in A readable that allows for user input.
   * @param out An appendable that is used for output.
   */
  public TicTacToeConsoleController(Readable in, Appendable out){
    this.in = in;
    this.out = out;
  }

  @Override
  public void playGame(TicTacToe m) {
    int arg1, arg2;
    Scanner scan = new Scanner(this.in);

    while (! this.ttt.isGameOver()){
      arg1 = scan.nextInt();
      arg2 = scan.nextInt();
      this.ttt.move(arg1, arg2);
      try {
        this.out.append(this.ttt.toString() + "\n");
      } catch (IOException e) {
        throw new IllegalStateException("IOException thrown.");
      }
    }
  }
}
