import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Tests for the PayCheck class. */
public class PayCheckTest {
  private PayCheck underTime;
  private PayCheck overTime;
  private PayCheck time;

  @Before
  public void setUp() {
    Employee peter;
    peter = new Employee("Peter", 15.00);
    underTime = new PayCheck(peter, 30);
    overTime = new PayCheck(peter, 45);
    time = new PayCheck(peter, 40);
  }

  @Test
  public void testUnderTime() {
    assertEquals("$450.00", underTime.toString());
  }

  @Test
  public void testOverTime() {
    assertEquals("$712.50", overTime.toString());
  }

  @Test
  public void testTime() {
    assertEquals("$600.00", time.toString());
  }
}
