/** This class represents the Rook ChessPiece. */
public class Rook extends AbstractPiece {

  /**
   * Constructor for the Rook piece.
   *
   * @param row the starting row of this piece.
   * @param col the starting column of this piece.
   * @param color the color of this piece.
   */
  public Rook(int row, int col, Color color) {
    super(row, col, color);
    this.type = Type.ROOK;
  }

  @Override
  public boolean canMove(int toRow, int toCol) {
    boolean validMove = (this.row == toRow) || (this.col == toCol);
    return validMove && this.onBoard(toRow, toCol);
  }
}
