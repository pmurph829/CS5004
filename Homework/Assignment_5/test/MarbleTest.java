import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.Marble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Tests for the marble class. */
public class MarbleTest {

  Marble m1;
  Marble m2;

  @Before
  public void setUp() {
    m1 = new Marble(1, 1, true);
    m2 = new Marble(2, 2, false);
  }

  @Test
  public void test_toString() {
    assertEquals("O", m1.toString());
    assertEquals("_", m2.toString());
  }

  @Test
  public void test_isVisible() {
    assertTrue(m1.isVisible());
    assertFalse(m2.isVisible());
  }

  @Test
  public void test_setVisibility() {
    m1.setVisibility(false);
    m2.setVisibility(true);
    assertFalse(m1.isVisible());
    assertTrue(m2.isVisible());
  }
}
