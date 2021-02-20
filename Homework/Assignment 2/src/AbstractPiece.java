/**
 * This Abstract class implements the ChessPiece interface and defines behavior of various methods
 * common to all ChessPiece instances.
 */
public abstract class AbstractPiece implements ChessPiece {
  protected int col;
  protected int row;
  protected int[] position;
  protected Color color;
  protected Type type;

  /**
   * Constructor for a generic piece.
   *
   * @param row the starting row of this piece.
   * @param col the starting column of this piece.
   * @param color the color of this piece.
   * @throws IllegalArgumentException if the piece is not placed on the board.
   */
  public AbstractPiece(int row, int col, Color color) throws IllegalArgumentException {
    if (!this.onBoard(row, col)) {
      throw new IllegalArgumentException("Not on the board, cannot create piece.");
    }
    this.row = row;
    this.col = col;
    this.position = new int[] {row, col};
    this.color = color;
  }

  @Override
  public int getColumn() {
    return this.col;
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int[] getPosition() {
    return this.position;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public boolean onBoard(int row, int col) {
    boolean a = 0 <= row;
    boolean b = row <= 7;
    boolean c = 0 <= col;
    boolean d = col <= 7;
    return (a && b) && (c && d);
  }

  @Override
  public boolean canKill(ChessPiece target) {
    int[] targetPosition = target.getPosition();
    return this.canMove(targetPosition[0], targetPosition[1])
        && this.getColor() != target.getColor();
  }
}
