package cs5004.marblesolitaire.model;

/** Class that represents a MarbleSpace in the MarbleSolitaire game. */
public class MarbleSpace {
  private final int row;
  private final int col;
  private boolean occupied;

  /**
   * Constructor for a MarbleSpace object.
   *
   * @param row the row where the MarbleSpace will be placed on the board.
   * @param col the column where the MarbleSpace will be placed on the board.
   * @param occupied true if the MarbleSpace is on the board, false if it has been jumped or is at
   */
  public MarbleSpace(int row, int col, boolean occupied) {
    this.occupied = occupied;
    this.row = row;
    this.col = col;
  }

  /**
   * Generate a string representation of the MarbleSpace (depends on visibility).
   *
   * @return string representation.
   */
  public String toString() {
    if (this.occupied) {
      return "O";
    } else {
      return "_";
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MarbleSpace)) {
      return false;
    }
    MarbleSpace ms = (MarbleSpace) o;
    return this.row == ms.getPosition()[0] && this.col == ms.getPosition()[1];
  }

  /**
   * Determine if the MarbleSpace is visible or not.
   *
   * @return the visibility of the MarbleSpace.
   */
  public boolean containsMarble() {
    return this.occupied;
  }

  /**
   * Set the visibility state of the marble. This is used for jumping behavior.
   *
   * @param containsMarble true to add a marble from the MarbleSpace. False to remove Marble.
   */
  public void setMarbleStatus(boolean containsMarble) {
    this.occupied = containsMarble;
  }

  public int[] getPosition() {
    return new int[] {this.row, this.col};
  }
}
