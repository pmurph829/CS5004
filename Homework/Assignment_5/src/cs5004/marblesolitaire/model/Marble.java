package cs5004.marblesolitaire.model;

/** Class that represents a Marble in the MarbleSolitaire game. */
public class Marble {
  private final int row;
  private final int col;
  private boolean visible;

  /**
   * Constructor for a Marble object.
   *
   * @param row the row where the Marble will be placed on the board.
   * @param col the column where the Marble will be placed on the board.
   * @param visible true if the Marble is on the board, false if it has been jumped or is at the
   *     starting location.
   */
  public Marble(int row, int col, boolean visible) {
    this.visible = visible;
    this.row = row;
    this.col = col;
  }

  /**
   * Generate a string representation of the Marble (depends on visibility).
   *
   * @return string representation.
   */
  public String toString() {
    if (this.visible) {
      return "O";
    } else {
      return "_";
    }
  }

  /**
   * Determine if the Marble is visible or not.
   *
   * @return the visibility of the Marble.
   */
  public boolean isVisible() {
    return this.visible;
  }

  /** Set the visibility state of the marble. This is used for jumping behavior.
   * @param v the visibility of the marble.*/
  public void setVisibility(boolean v) {
    this.visible = v;
  }
}
