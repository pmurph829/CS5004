import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Tests for the FibCounter class. */
public class FibCounterTest {
  private FibonacciCounter initial1;
  private FibonacciCounter initial2;

  @Before
  public void setUp() {
    initial1 = new FibonacciCounter(5);
    initial2 = new FibonacciCounter(0);
  }

  @Test
  public void testToString() {
    assertEquals(initial1.toString(), "Count: 5");
  }

  @Test
  public void testGetFibNumber() {
    assertEquals(5, initial1.getFibNumber(), 2);
    assertEquals(0, initial2.getFibNumber(), 2);
  }

  @Test
  public void testIncrement() {
    FibonacciCounter increment;
    increment = initial1.incrementCount();
    assertEquals("Count: 6", increment.toString());
  }

  @Test
  public void testDecrement() {
    FibonacciCounter decrement1;
    FibonacciCounter decrement2;
    decrement1 = initial1.decrementCount();
    decrement2 = initial2.decrementCount();
    assertEquals("Count: 4", decrement1.toString());
    assertEquals("Count: 0", decrement2.toString());
  }
}
