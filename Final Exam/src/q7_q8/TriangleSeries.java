package q7_q8;

import java.util.Iterator;
import java.lang.Integer;
/** Class that represents a triangle series. Triangle Series Rule: t = n * (n + 1) / 2 */
public class TriangleSeries implements Iterable<Integer> {

  private final Integer start;
  private final Integer end;

  /**
   * Constructor for a triangle (sub)series that allows the user to specify a starting and ending
   * "n".
   *
   * @param start the starting "n" value.
   * @param end the ending "n" value.
   */
  public TriangleSeries(Integer start, Integer end) {
    this.start = start;
    this.end = end;
  }

  /**
   * Determine the value of the series at a given "n".
   *
   * @param n the term to evaluate.
   * @return the value of the series at n.
   */
  public Integer evaluate(Integer n) {
    return n * (n + 1) / 2;
  }

  /**
   * Get the starting term number of this subseries.
   *
   * @return the value of "n" at the first term.
   */
  public Integer getStart() {
    return this.start;
  }

  /**
   * Get the ending term number of this subseries.
   *
   * @return the value of "n" at the last term.
   */
  public Integer getEnd() {
    return this.end;
  }

  @Override
  public java.util.Iterator<Integer> iterator() {
    return new TriangleSeriesIterator(this);
  }

  /** Class that is able to iterate over terms of a q7.TriangleSeries. */
  private class TriangleSeriesIterator implements Iterator<Integer> {

    private final TriangleSeries ts;
    private java.lang.Integer current;

    /**
     * Constructor for a TriangleSeriesIterator.
     *
     * @param ts the q7.TriangleSeries object that will be iterated over.
     */
    public TriangleSeriesIterator(TriangleSeries ts) {
      this.ts = ts;
      this.current = this.ts.getStart();
    }

    @Override
    public boolean hasNext() {
      return this.current < this.ts.getEnd();
    }

    @Override
    public Integer next() {
      java.lang.Integer element = this.ts.evaluate(this.current);
      this.current = this.current + 1;
      return element;
    }
  }
}
