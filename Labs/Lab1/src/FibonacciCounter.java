/**
 * The FibonacciCounter class represents a term in the fibonacci sequence. It can return the value
 * of the fibonacci number at that term.
 */
public class FibonacciCounter {
  private final int initialCount;
  private final double fibNumber;

  /**
   * Creates a new fibonacciCounter object.
   *
   * @param initialCount the term in the fibonacci sequence to represent.
   */
  public FibonacciCounter(int initialCount) {
    this.initialCount = initialCount;
    this.fibNumber = calculateFibNumber(initialCount);
  }

  /**
   * Creates a String representation of the object.
   *
   * @return string representation.
   */
  public String toString() {
    return String.format("Count: %d", this.initialCount);
  }

  /**
   * Returns a new FibonacciCounter object that represents a term that is one higher than the
   * initial.
   *
   * @return new FibonacciCounter object
   */
  public FibonacciCounter incrementCount() {
    return new FibonacciCounter(this.initialCount + 1);
  }

  /**
   * Returns a new FibonacciCounter object that represents a term that is one lower than the
   * initial.
   *
   * @return new FibonacciCounter object
   */
  public FibonacciCounter decrementCount() {
    if (initialCount <= 0) {
      return new FibonacciCounter(this.initialCount);
    }
    return new FibonacciCounter(this.initialCount - 1);
  }

  /**
   * Getter method that returns the initial count.
   *
   * @return int initialCount
   */
  public int getCurrentCount() {
    return this.initialCount;
  }

  /**
   * Calculate the value of the fibonacci number a given nth term using Binet's formula.
   *
   * @param n int. nth term in the fibonacci sequence.
   * @return double fibonacci number at term n
   */
  public double calculateFibNumber(int n) {
    double a = (1 / Math.sqrt(5));
    double b = Math.pow((1 + Math.sqrt(5)) / 2, n);
    double c = Math.pow((1 - Math.sqrt(5)) / 2, n);
    return a * (b - c);
  }

  /**
   * Getter that returns the fibNumber field.
   *
   * @return double fibonacci number at term initialCount.
   */
  public double getFibNumber() {
    return this.fibNumber;
  }
}
