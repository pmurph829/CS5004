package cs5004.marblesolitaire.model;

/** Implementing class for MarbleSolitaireModel that allows a game to be played. */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  private final MarbleBoard mBoard;

  /** Constructor that creates a standard game. */
  public MarbleSolitaireModelImpl() {
    this.mBoard = new MarbleBoard(3, 3, 3);
  }

  /**
   * Constructor that creates a standard size board with a specified starting point.
   *
   * @param sRow the row of the starting point.
   * @param sCol the column of the starting point.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this.mBoard = new MarbleBoard(sRow, sCol, 3);
  }

  /**
   * Constructor that creates a board of specified arm length with the starting point in the middle.
   *
   * @param armSize the arm size of the board to be created.
   */
  public MarbleSolitaireModelImpl(int armSize) {
    int mid = armSize + ((armSize - 1) / 2) - 1;
    this.mBoard = new MarbleBoard(mid, mid, armSize);
  }

  /**
   * Constructor that creates a board of specified arm length, and a start point at a specified
   * location.
   *
   * @param armSize the arm length of the board to be created.
   * @param sRow the starting row.
   * @param sCol the starting column.
   */
  public MarbleSolitaireModelImpl(int armSize, int sRow, int sCol) {
    this.mBoard = new MarbleBoard(sRow, sCol, armSize);
  }

  /**
   * Create a String representation of the game.
   *
   * @return string representation.
   */
  public String toString() {
    return this.mBoard.toString();
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.isGameOver()) {
      throw new IllegalArgumentException("Game is over!");
    }
    if (!this.canMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Unable to move to this location.");
    }

    MarbleSpace fromMarbleSpace = this.mBoard.getMarble(fromRow, fromCol);
    MarbleSpace toMarbleSpace = this.mBoard.getMarble(toRow, toCol);
    MarbleSpace middleMarbleSpace = this.findMiddleMarble(fromRow, fromCol, toRow, toCol);

    fromMarbleSpace.setMarbleStatus(false);
    toMarbleSpace.setMarbleStatus(true);
    middleMarbleSpace.setMarbleStatus(false);
  }

  /**
   * Determine if a move can be made from a certain position to another position. Does not update
   * the board.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow the row number of the position to be moved to (starts at 0)
   * @param toCol the column number of the position to be moved to (starts at 0)
   * @return true if the move is valid.
   */
  private boolean canMove(int fromRow, int fromCol, int toRow, int toCol) {

    // Just checks if difference is 2 or 0
    if (!(this.verifyDifference(fromRow, toRow) && this.verifyDifference(fromCol, toCol))) {
      return false;
    }
    // Check the move is not diagonal
    if (Math.abs(toRow - fromRow) == Math.abs(toCol - fromCol)) {
      return false;
    }
    MarbleSpace fromMarbleSpace = this.mBoard.getMarble(fromRow, fromCol);
    MarbleSpace toMarbleSpace = this.mBoard.getMarble(toRow, toCol);
    MarbleSpace middleMarbleSpace = this.findMiddleMarble(fromRow, fromCol, toRow, toCol);

    return fromMarbleSpace.containsMarble()
        && middleMarbleSpace.containsMarble()
        && !toMarbleSpace.containsMarble();
  }

  /**
   * Verify that a move from a position to another position is valid in one-dimension. This function
   * is applicable to rows or columns.
   *
   * @param from the starting row or column.
   * @param to the ending row or column.
   * @return true if the to position is valid. NOTE: Must verify both row and column before a move
   *     can be fully verified. Also doesn't take into account the state of the marbles on the
   *     board.
   */
  private boolean verifyDifference(int from, int to) {
    int diff = Math.abs(to - from);
    return diff == 2 || diff == 0;
  }

  /**
   * Find the marble that is between a from and to position.
   *
   * @param fr row of the from space.
   * @param fc column of the from space.
   * @param tr row of the to space.
   * @param tc column of the to space.
   * @return the space that is in between the from space and to space.
   */
  private MarbleSpace findMiddleMarble(int fr, int fc, int tr, int tc) {
    if (!(this.verifyDifference(fr, tr) && this.verifyDifference(fc, tc))) {
      throw new IllegalArgumentException("Invalid positions, no middle marble found.");
    }
    MarbleSpace middleMarbleSpace;
    int rowAvg = (fr + tr) / 2;
    int colAvg = (fc + tc) / 2;
    if (rowAvg == fr) {
      middleMarbleSpace = this.mBoard.getMarble(fr, colAvg);
    } else {
      middleMarbleSpace = this.mBoard.getMarble(rowAvg, fc);
    }
    return middleMarbleSpace;
  }

  @Override
  public boolean isGameOver() {
    for (int r = 0; r < this.mBoard.getGridSize(); r++) {
      for (int c = 0; c < this.mBoard.getGridSize(); c++) {
        try {
          if (!this.mBoard.getMarble(r, c).containsMarble()) {
            continue;
          }
        } catch (IllegalArgumentException ignored) {
        }

        if (this.mBoard.onBoard(r, c)) {

          if (this.mBoard.onBoard(r + 2, c)) {
            if (this.canMove(r, c, r + 2, c)) {
              return false;
            }
          }
          if (this.mBoard.onBoard(r, c + 2)) {
            if (this.canMove(r, c, r, c + 2)) {
              return false;
            }
          }
          if (this.mBoard.onBoard(r - 2, c)) {
            if (this.canMove(r, c, r - 2, c)) {
              return false;
            }
          }
          if (this.mBoard.onBoard(r, c - 2)) {
            if (this.canMove(r, c, r, c - 2)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  @Override
  public String getGameState() {
    return this.mBoard.toString();
  }

  @Override
  public int getScore() {
    int score = 0;
    for (int r = 0; r < this.mBoard.getGridSize(); r++) {
      for (int c = 0; c < this.mBoard.getGridSize(); c++) {
        if (this.mBoard.onBoard(r, c)) {
          MarbleSpace m = this.mBoard.getMarble(r, c);
          if (m.containsMarble()) {
            score++;
          }
        }
      }
    }
    return score;
  }
}
