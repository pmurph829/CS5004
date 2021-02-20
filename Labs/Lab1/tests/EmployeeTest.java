import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Tests for the Employee class. */
public class EmployeeTest {
  private Employee peter;
  private PayCheck firstPaycheck;
  private PayCheck secondPayCheck;

  @Before
  public void setUp() {
    peter = new Employee("Peter", 15.00);
    peter.addHoursWorked(30);
    firstPaycheck = peter.getWeeklyCheck();
    peter.resetHoursWorked();
    peter.addHoursWorked(45);
    secondPayCheck = peter.getWeeklyCheck();
  }

  @Test
  public void testGetPayRate() {
    assertEquals(15.00, peter.getPayRate(), 2);
  }

  @Test
  public void testGetHours() {
    peter.resetHoursWorked();
    peter.addHoursWorked(10);
    assertEquals(10, peter.getHours(), 2);
  }

  @Test
  public void testResetHours() {
    peter.resetHoursWorked();
    assertEquals(0, peter.getHours(), 2);
  }

  @Test
  public void testToString() {
    assertEquals("Peter", peter.toString());
  }

  @Test
  public void testGetWeeklyPaycheck() {
    assertEquals("$450.00", firstPaycheck.toString());
    assertEquals("$712.50", secondPayCheck.toString());
  }
}
