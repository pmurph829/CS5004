import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSpace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Tests for the marble class. */
public class MarbleSpaceTest {
  MarbleSpace m1;
  MarbleSpace m2;

  @Before
  public void setUp() {
    m1 = new MarbleSpace(1, 1, true);
    m2 = new MarbleSpace(2, 2, false);
  }

  @Test
  public void test_toString() {
    assertEquals("O", m1.toString());
    assertEquals("_", m2.toString());
  }

  @Test
  public void test_containsMarble() {
    assertTrue(m1.containsMarble());
    assertFalse(m2.containsMarble());
  }

  @Test
  public void test_setMarbleStatus() {
    m1.setMarbleStatus(false);
    m2.setMarbleStatus(true);
    assertFalse(m1.containsMarble());
    assertTrue(m2.containsMarble());
  }
}
