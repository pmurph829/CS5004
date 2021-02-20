/** This class represents a Knight ChessPiece. */
public class Knight extends AbstractPiece {
  /**
   * Constructor for the Knight piece.
   *
   * @param row the starting row of this piece.
   * @param col the starting column of this piece.
   * @param color the color of this piece.
   */
  public Knight(int row, int col, Color color) {
    super(row, col, color);
    this.type = Type.KNIGHT;
  }

  @Override
  public boolean canMove(int toRow, int toCol) {
    int rowDiff = Math.abs(toRow - this.row);
    int colDiff = Math.abs(toCol - this.col);
    boolean validMove1 = (rowDiff == 1 && colDiff == 2);
    boolean validMove2 = (rowDiff == 2 && colDiff == 1);
    return (validMove1 || validMove2) && this.onBoard(toRow, toCol);
  }
}
