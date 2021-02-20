/** This class represents a Queen ChessPiece. */
public class Queen extends AbstractPiece {

  /**
   * Constructor for the Queen piece.
   *
   * @param row the starting row of this piece.
   * @param col the starting column of this piece.
   * @param color the color of this piece.
   */
  public Queen(int row, int col, Color color) {
    super(row, col, color);
    this.type = Type.QUEEN;
  }

  @Override
  public boolean canMove(int toRow, int toCol) {
    boolean validMove = (this.row == toRow) || (this.col == toCol);
    boolean validMove2 = (Math.abs(this.row - toRow) == Math.abs(this.col - toCol));
    return (validMove || validMove2) && this.onBoard(toRow, toCol);
  }
}
