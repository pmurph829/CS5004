package q11;

public class Rectangle {
  private Point2D lowerLeft;
  private int width;
  private int height;

  public Rectangle(int x, int y, int width, int height){
    if (width < 0 || height < 0){
      throw new IllegalArgumentException("Width / height cannot be negative.");
    }
    this.lowerLeft = new Point2D(x, y);
    this.width = width;
    this.height = height;
  }

  public String toString(){
    return String.format("x:%d, y:%d, w:%d, h:%d", lowerLeft.getX(), lowerLeft.getY(),
            width, height);
  }

  public Point2D getLowerLeft(){
    return this.lowerLeft;
  }

  boolean overlap(Rectangle other){
    int[] myBounds = this.lowerLeft.calculateBounds(this.width, this.height);
    int[] otherBounds = other.getLowerLeft().calculateBounds(other.width, other.height);
    // Overlapping x if my max x is greater than other min x
    // and other max x is greater than my min x.
    boolean xOverlap = myBounds[2] > otherBounds[0] && otherBounds[2] > myBounds[0];
    boolean yOverlap = myBounds[3] > otherBounds[1] && otherBounds[3] > myBounds[1];
    return xOverlap || yOverlap;
  }
}
