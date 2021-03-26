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
    this.mBoard = new MarbleBoard(armSize, armSize, armSize);
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
    /*
    1. ensure the spots are two spaces away and not diagonal.
    2. ensure the from marble is visible and the to marble is not.
    3. ensure the middle marble is visible
    4. Set the from marble visibility to false
    5. Set the to marble visibility to true
    6. Set the middle marble visibility to false
    */

    if (!(this.verifyDifference(fromRow, toRow) && this.verifyDifference(fromCol, toCol))) {
      throw new IllegalArgumentException("The given positions are invalid.");
    }
    Marble fromMarble = this.mBoard.getMarble(fromRow, fromCol);
    Marble toMarble = this.mBoard.getMarble(toRow, toCol);
    Marble middleMarble = this.findMiddleMarble(fromRow, fromCol, toRow, toCol);

    if (!fromMarble.isVisible() || toMarble.isVisible() || !middleMarble.isVisible()) {
      throw new IllegalArgumentException("Invalid board setup.");
    }
    fromMarble.setVisibility(false);
    toMarble.setVisibility(true);
    middleMarble.setVisibility(false);
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

  private Marble findMiddleMarble(int fr, int fc, int tr, int tc) {
    Marble middleMarble;
    int rowAvg = (fr + tr) / 2;
    int colAvg = (fc + tc) / 2;
    if (rowAvg == 0) {
      middleMarble = this.mBoard.getMarble(fr, colAvg);
    } else {
      middleMarble = this.mBoard.getMarble(rowAvg, fc);
    }
    return middleMarble;
  }

  @Override
  public boolean isGameOver() {
    for (int r = 0; r < this.mBoard.getGridSize(); r++) {
      for (int c = 0; c < this.mBoard.getGridSize(); c++) {
        if ()

      }
    }
    return false;
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
          Marble m = this.mBoard.getMarble(r, c);
          if (m.isVisible()) {
            score++;
          }
        }
      }
    }
    return score;
  }
}
