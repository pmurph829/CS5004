package cs5004.tictactoe;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implementation of the TicTacToeController interface that allows players to play TicTacToe through
 * a console interface.
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private final Readable in;
  private final Appendable out;
  private final TicTacToeModel ttt = new TicTacToeModel();

  /**
   * Constructor for the TicTacToeConsoleController.
   *
   * @param in A readable that allows for user input.
   * @param out An appendable that is used for output.
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }

  /**
   * Method that creates a message that gives the state of the board and the winner at the end of a
   * game.
   *
   * @return The end game message.
   */
  private String endGame() {
    String message = this.ttt.toString() + "\nGame is over! ";
    Player winner = this.ttt.getWinner();
    if (winner != null) {
      message += String.format("%s wins.", winner.toString());
    } else {
      message += "Tie game.";
    }
    return message;
  }

  /**
   * Helper funciton for scanner that avoids raising exceptions.
   *
   * @param s the scanner object being used.
   * @return the string found by the scanner, or empty string if nothing is found.
   */
  private String scanHelp(Scanner s) {
    if (s.hasNext()) {
      return s.next();
    } else {
      return "";
    }
  }

  @Override
  public void playGame(TicTacToe m) throws IllegalStateException {
    String arg1;
    String arg2;
    Scanner scan = new Scanner(this.in);
    boolean skip = false;
    while (!this.ttt.isGameOver()) {

      try {
        if (!skip) {
          this.out.append(this.ttt.toString()).append("\n");
          this.out.append("Enter a move for ").append(ttt.getTurn().toString()).append(":\n");
        }

        arg1 = this.scanHelp(scan);
        arg2 = this.scanHelp(scan);

        if (arg1.equalsIgnoreCase("q") || arg2.equalsIgnoreCase("q")) {
          this.out.append("Game quit! Ending game state:\n").append(ttt.toString()).append("\n");
          break;
        } else if (arg2.equals("")) {
          break;
        }

        try {
          int a = Integer.parseInt(arg1);
          int b = Integer.parseInt(arg2);
          skip = false;
        } catch (NumberFormatException | InputMismatchException e) {
          this.out.append("Please enter two integers.\n");
          skip = true;
        }

        if (!skip) {
          this.ttt.move(Integer.parseInt(arg1) - 1, Integer.parseInt(arg2) - 1);
        }
        if (ttt.isGameOver()) {
          this.out.append(this.endGame());
        }
      } catch (IOException e) {
        throw new IllegalStateException("IOException thrown.");
      } catch (IllegalArgumentException e) {
        try {
          this.out.append(e.getMessage()).append("\n");
          skip = true;
        } catch (IOException ioException) {
          throw new IllegalStateException("IOException thrown.");
        }
      }
    }
  }
}
