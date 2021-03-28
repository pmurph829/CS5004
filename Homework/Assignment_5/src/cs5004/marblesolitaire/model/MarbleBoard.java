package cs5004.marblesolitaire.model;

/** Class that represents a board of marbles used in the game MarbleSpace Solitaire. */
public class MarbleBoard {
  private final int gridSize;
  private final int buffer;
  private final MarbleSpace[][] board;

  /**
   * Constructor for a marbleBoard object.
   *
   * @param sRow the row of the starting empty space.
   * @param sCol the column of the starting empty space.
   * @param armSize the size of each "arm" square that the board is made up of.
   * @throws IllegalArgumentException if the armsize is invalid or the starting location is not on
   *     the board.
   */
  public MarbleBoard(int sRow, int sCol, int armSize) throws IllegalArgumentException {
    if (armSize % 2 != 1) {
      throw new IllegalArgumentException("Arm length must be a positive odd integer.");
    }

    this.gridSize = 3 * armSize - 2;
    this.board = new MarbleSpace[this.gridSize][this.gridSize];
    this.buffer = armSize - 1;
    for (int r = 0; r < this.gridSize; r++) {
      for (int c = 0; c < this.gridSize; c++) {
        if (isInBuffer(r, c)) {
          this.board[r][c] = null;
        } else if (r == sRow && c == sCol) {
          this.board[r][c] = new MarbleSpace(r, c, false);
        } else {
          this.board[r][c] = new MarbleSpace(r, c, true);
        }
      }
    }
    if (!onBoard(sRow, sCol)) {
      throw new IllegalArgumentException(
          String.format("Invalid empty cell position (%s %s)", sRow, sCol));
    }
  }

  /**
   * Return a string representation of the board with all the marbles shown.
   *
   * @return string representation.
   */
  public String toString() {
    String s = "";
    for (int r = 0; r < this.gridSize; r++) {
      for (int c = 0; c < this.gridSize; c++) {
        if (isInBuffer(r, c)) {
          s += " ";
        } else {
          s += this.board[r][c].toString();
        }
        if (c != this.gridSize - 1) {
          s += " ";
        } else {
          s = s.stripTrailing();
          s += "\n";
        }
      }
    }
    return s.substring(0, s.length() - 1);
  }

  /**
   * Getter method that returns grid size.
   *
   * @return the size of the gird.
   */
  public int getGridSize() {
    return this.gridSize;
  }

  /**
   * Determine if a row/column pair is in a "buffer zone" which are the corners of the grid where no
   * marbles are allowed to be placed.
   *
   * @param r the row to check.
   * @param c the column to check.
   * @return true if the coordinate is in one of the 4 buffer zones.
   */
  private boolean isInBuffer(int r, int c) {
    int buffer2 = this.gridSize - this.buffer;
    return (r < this.buffer && c < this.buffer)
        || (r < this.buffer && c >= buffer2)
        || (r >= buffer2 && c < this.buffer)
        || (r >= buffer2 && c >= buffer2);
  }

  /**
   * Determine if a row/column pair is on the board.
   *
   * @param r the row to check.
   * @param c the column to check.
   * @return true if the location is a valid position on the board.
   */
  public boolean onBoard(int r, int c) {
    if (r < 0 || c < 0 || r >= this.gridSize || c >= this.gridSize) {
      return false; // position is outside board bounds
    } else if (this.board[r][c] == null) {
      return false; // position is not an allowed space
    }
    return true;
  }

  /**
   * Get the marble object at a specified row/column pair on the board.
   *
   * @param r the row of the MarbleSpace.
   * @param c the column of the MarbleSpace.
   * @return the MarbleSpace object that is found.
   * @throws IllegalArgumentException if the specified position is invalid.
   */
  public MarbleSpace getMarble(int r, int c) throws IllegalArgumentException {
    if (!this.onBoard(r, c)) {
      throw new IllegalArgumentException("Position is not on board.");
    }
    return this.board[r][c];
  }
}
