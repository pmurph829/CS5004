/** This class represents a Pawn ChessPiece. */
public class Pawn extends AbstractPiece {
  /**
   * Constructor for the Pawn piece.
   *
   * @param row the starting row of this piece.
   * @param col the starting column of this piece.
   * @param color the color of this piece.
   */
  public Pawn(int row, int col, Color color) {
    super(row, col, color);
    this.type = Type.PAWN;
  }

  @Override
  public boolean canMove(int toRow, int toCol) {
    if (this.color == Color.WHITE) {
      return (this.row + 1 == toRow) && (this.col == toCol);
    } else {
      return (this.row - 1 == toRow) && (this.col == toCol);
    }
  }

  @Override
  public boolean canKill(ChessPiece target) {
    boolean validMove1;
    boolean validMove2;
    validMove1 = Math.abs(target.getColumn() - this.col) == 1;
    if (this.color == Color.WHITE) {
      validMove2 = target.getRow() - this.row == 1;
    } else {
      validMove2 = target.getRow() - this.row == -1;
    }
    boolean validKillPos =
        validMove1 && validMove2 && this.onBoard(target.getRow(), target.getColumn());
    return validKillPos && this.getColor() != target.getColor();
  }
}
