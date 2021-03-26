import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleBoard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Tests for the */
public class MarbleBoardTest {
  MarbleBoard mb1;
  MarbleBoard mb2;

  @Before
  public void setUp() {
    mb1 = new MarbleBoard(3, 3, 3);
    mb2 = new MarbleBoard(4, 2, 5);
  }

  @Test
  public void test_toString() {
    assertEquals(
        "    O O O    \n"
            + "    O O O    \n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O    \n"
            + "    O O O    ",
        mb1.toString());
    assertEquals(
        "      O O O O O      \n"
            + "      O O O O O      \n"
            + "      O O O O O      \n"
            + "O O O O O O O O O O O\n"
            + "O O _ O O O O O O O O\n"
            + "O O O O O O O O O O O\n"
            + "O O O O O O O O O O O\n"
            + "O O O O O O O O O O O\n"
            + "      O O O O O      \n"
            + "      O O O O O      \n"
            + "      O O O O O      ",
        mb2.toString());
  }

  @Test
  public void test_onBoard() {
    assertTrue(mb1.onBoard(2, 0));
    assertTrue(mb1.onBoard(4, 2));
    assertTrue(mb1.onBoard(3, 3));
    assertTrue(mb1.onBoard(2, 6));
    assertFalse(mb1.onBoard(0, 0));
    assertFalse(mb1.onBoard(1, 5));
    assertFalse(mb1.onBoard(5, 1));
    assertFalse(mb1.onBoard(6, 6));
    assertFalse(mb1.onBoard(-1, 0));
    assertFalse(mb1.onBoard(0, -1));
    assertFalse(mb1.onBoard(7, 0));
    assertFalse(mb1.onBoard(0, 7));
  }
}
