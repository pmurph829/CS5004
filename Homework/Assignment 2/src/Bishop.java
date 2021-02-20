/** This class represents a Bishop ChessPiece. */
public class Bishop extends AbstractPiece {
  /**
   * Constructor for the Bishop piece.
   *
   * @param row the starting row of this piece.
   * @param col the starting column of this piece.
   * @param color the color of this piece.
   */
  public Bishop(int row, int col, Color color) {
    super(row, col, color);
    this.type = Type.BISHOP;
  }

  @Override
  public boolean canMove(int toRow, int toCol) {
    boolean validMove = (Math.abs(this.row - toRow) == Math.abs(this.col - toCol));
    return validMove && this.onBoard(toRow, toCol);
  }
}
