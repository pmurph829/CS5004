package cs5004.tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Implementation of TicTacToe. Performs operations necessary to play TicTacToe and stores the
 * "state" of the board.
 */
public class TicTacToeModel implements TicTacToe {
  private Player[][] board;
  private Player current;

  /** Constructor for the TicTacToeModel class. */
  public TicTacToeModel() {
    this.board = new Player[3][3];
    this.current = Player.X;
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard())
        .map(
            row ->
                " "
                    + Arrays.stream(row)
                        .map(p -> p == null ? " " : p.toString())
                        .collect(Collectors.joining(" | ")))
        .collect(Collectors.joining("\n-----------\n"));
  }

  @Override
  public void move(int r, int c) {
    // Throw exception if game is over
    // Throw exception if the space is occupied or outside board
    if (this.isGameOver()) {
      throw new IllegalStateException("Game is over!");
    } else if (r >= 3 || c >= 3 || r < 0 || c < 0) {
      throw new IllegalArgumentException("Position is outside board!");
    } else if (this.board[r][c] != null) {
      throw new IllegalArgumentException("Space is occupied!");
    }

    this.board[r][c] = this.getTurn();
    if (this.getTurn() == Player.X) {
      this.current = Player.O;
    } else {
      this.current = Player.X;
    }
  }

  @Override
  public Player getTurn() {
    return this.current;
  }

  /**
   * Check if all entries in a triple are the same.
   *
   * @param triple array of players.
   * @return true if all players in the array are the same.
   */
  private boolean winningTriple(Player[] triple) {
    return (triple[0] == Player.O && triple[1] == Player.O && triple[2] == Player.O)
        || (triple[0] == Player.X && triple[1] == Player.X && triple[2] == Player.X);
  }

  /**
   * Find and check all triples on the board.
   *
   * @retrun an array of all triples on the board (including diagonals).
   */
  private Player[][] findTriples() {
    Player[][] boardCopy = this.getBoard();
    Player[][] triples = new Player[8][3];
    int counter = 0;
    for (int r = 0; r < 3; r++) {
      Player[] triple = {boardCopy[r][0], boardCopy[r][1], boardCopy[r][2]};
      triples[counter] = triple;
      counter++;
    }
    for (int c = 0; c < 3; c++) {
      Player[] triple = {boardCopy[0][c], boardCopy[1][c], boardCopy[2][c]};
      triples[counter] = triple;
      counter++;
    }
    Player[] triple = {boardCopy[0][0], boardCopy[1][1], boardCopy[2][2]};
    triples[counter] = triple;
    counter++;

    triple = new Player[] {boardCopy[2][0], boardCopy[1][1], boardCopy[0][2]};
    triples[counter] = triple;
    return triples;
  }

  @Override
  public boolean isGameOver() {
    if (getWinner() == null) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (this.getBoard()[i][j] == null) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public Player getWinner() {
    Player[][] triples = this.findTriples();
    for (Player[] triple : triples) {
      if (winningTriple(triple)) {
        return triple[0];
      }
    }
    return null;
  }

  @Override
  public Player[][] getBoard() {
    Player[][] brdCopy = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        brdCopy[i][j] = this.board[i][j];
      }
    }
    return brdCopy;
  }

  @Override
  public Player getMarkAt(int r, int c) {
    if (r >= 3 || c >= 3 || r < 0 || c < 0) {
      throw new IllegalArgumentException("Position is not on board!");
    }
    return this.getBoard()[r][c];
  }
}
