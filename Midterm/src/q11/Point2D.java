package q11;

public class Point2D {
  private int x;
  private int y;

  public Point2D(int x, int y){
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  /**
   * Calculate the bounds of of a point given a with and height
   * @param width the width to calculate.
   * @param height the height to calculate.
   * @return array in the format: {minX, minY, maxX, maxY}
   */
  public int[] calculateBounds(int width, int height){
    int maxX = this.x + height;
    int maxY = this.y + width;
    return new int[] {this.x, this.y, maxX, maxY};
  }
}
