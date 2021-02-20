/** This interface gives a framework for methods that all ChessPieces should implement. */
public interface ChessPiece {

  Color color = null;

  /**
   * Gets the row that the ChessPiece is currently at.
   *
   * @return the row on the ChessBoard.
   */
  int getRow();

  /**
   * Gets the column that the ChessPiece is currently at.
   *
   * @return the column on the ChessBoard.
   */
  int getColumn();

  /**
   * Get the position of the ChessPiece in [row, column] format.
   *
   * @return array with index 0 = row, index 1 = column.
   */
  int[] getPosition();

  /**
   * Get the color of the ChessPiece.
   *
   * @return BLACK or WHITE.
   */
  Color getColor();

  /**
   * This method determines if the specified position is on the chess board.
   *
   * @param row the row of the position.
   * @param col the column of the position.
   * @return whether or not the position is on the board.
   */
  boolean onBoard(int row, int col);

  /**
   * Determine if the ChessPiece can move to the specified location.
   *
   * @param row the row of the specified location.
   * @param col the column of the specified location.
   * @return whether or not the ChessPiece can move to the location.
   */
  boolean canMove(int row, int col);

  /**
   * Determine if the ChessPiece can kill another instance of ChessPiece.
   *
   * @param target the other ChessPiece instance in question.
   * @return whether or not the ChessPiece can kill the other ChessPiece.
   */
  boolean canKill(ChessPiece target);

  /** Enum that stores the kind of piece the ChessPiece is. */
  enum Type {
    BISHOP,
    KNIGHT,
    PAWN,
    QUEEN,
    ROOK
  }
}
