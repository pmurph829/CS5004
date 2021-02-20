import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the Bishop class.
 */
public class TestBishop {
  public ChessPiece wb1;
  public ChessPiece wb2;
  public ChessPiece bb1;
  public ChessPiece bb2;

  /**
   * Make sure Bishops can be placed correctly.
   */
  @Before
  public void setUp() {
    wb1 = new Bishop(0, 0, Color.WHITE);
    wb2 = new Bishop(3, 5, Color.WHITE);
    bb1 = new Bishop(7, 7, Color.BLACK);
    bb2 = new Bishop(4, 6, Color.BLACK);
  }

  /**
   * Test the getRow method returns the appropriate row for each object.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, wb1.getRow());
    assertEquals(3, wb2.getRow());
    assertEquals(7, bb1.getRow());
    assertEquals(4, bb2.getRow());
  }

  /**
   * Test the getCol method returns the appropriate column for each object.
   */
  @Test
  public void testGetCol() {
    assertEquals(0, wb1.getColumn());
    assertEquals(5, wb2.getColumn());
    assertEquals(7, bb1.getColumn());
    assertEquals(6, bb2.getColumn());
  }

  /**
   * Test that the getPosition method returns the correct position for each object.
   */
  @Test
  public void testGetPosition() {
    assertEquals(0, wb1.getPosition()[0]);
    assertEquals(0, wb1.getPosition()[1]);
    assertEquals(3, wb2.getPosition()[0]);
    assertEquals(5, wb2.getPosition()[1]);
  }

  /**
   * Test that the getColor method returns the appropriate color for each object.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, wb1.getColor());
    assertEquals(Color.WHITE, wb2.getColor());
    assertEquals(Color.BLACK, bb1.getColor());
    assertEquals(Color.BLACK, bb2.getColor());
  }

  /**
   * Test the onBoard method can accurately tell if a position is on the board.
   */
  @Test
  public void testOnBoard() {
    assertTrue(wb1.onBoard(wb1.getRow(), wb1.getColumn()));
    assertTrue(wb2.onBoard(wb2.getRow(), wb2.getColumn()));
    assertTrue(bb1.onBoard(bb1.getRow(), bb1.getColumn()));

    assertFalse(wb1.onBoard(-1, 0));
    assertFalse(wb1.onBoard(8, 0));
    assertFalse(wb1.onBoard(0, -1));
    assertFalse(wb1.onBoard(0, 8));
  }

  /**
   * Make sure objects can only move to appropriate locations.
   */
  @Test
  public void testCanMove() {
    assertTrue(wb1.canMove(1, 1));
    assertTrue(wb1.canMove(2, 2));
    assertTrue(wb1.canMove(3, 3));
    assertTrue(wb1.canMove(4, 4));
    assertTrue(wb1.canMove(7, 7));

    assertTrue(wb2.canMove(6, 2));
    assertTrue(wb2.canMove(1, 3));
    assertTrue(wb2.canMove(2, 6));
    assertTrue(wb2.canMove(5, 7));

    assertFalse(wb2.canMove(4, 5));
    assertFalse(wb2.canMove(3, 4));
    assertFalse(wb1.canMove(2, 7));
  }

  /**
   * Make sure the objects can only kill pieces they are allowed to kill.
   */
  @Test
  public void testCanKill() {
    ChessPiece target1 = new Bishop(3, 3, Color.BLACK);
    ChessPiece target2 = new Bishop(2, 4, Color.WHITE);

    assertTrue(wb1.canKill(target1));
    assertTrue(bb2.canKill(target2));

    assertFalse(wb1.canKill(target2));
    assertFalse(wb2.canKill(target2));
    assertFalse(bb1.canKill(target1));
    assertFalse(bb2.canKill(target1));
  }
}
