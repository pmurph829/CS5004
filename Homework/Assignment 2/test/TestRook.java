import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the Rook class.
 */
public class TestRook {
  public ChessPiece wr1;
  public ChessPiece wr2;
  public ChessPiece br1;
  public ChessPiece br2;

  /**
   * Make sure the Rook pieces can be initialized properly.
   */
  @Before
  public void setUp() {
    wr1 = new Rook(0, 0, Color.WHITE);
    wr2 = new Rook(3, 5, Color.WHITE);
    br1 = new Rook(7, 7, Color.BLACK);
    br2 = new Rook(4, 6, Color.BLACK);
  }

  /**
   * Test the getRow method returns the appropriate row for each object.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, wr1.getRow());
    assertEquals(3, wr2.getRow());
    assertEquals(7, br1.getRow());
    assertEquals(4, br2.getRow());
  }

  /**
   * Test the getCol method returns the appropriate column for each object.
   */
  @Test
  public void testGetCol() {
    assertEquals(0, wr1.getColumn());
    assertEquals(5, wr2.getColumn());
    assertEquals(7, br1.getColumn());
    assertEquals(6, br2.getColumn());
  }

  /**
   * Test that the getPosition method returns the correct position for each object.
   */
  @Test
  public void testGetPosition() {
    assertEquals(0, wr1.getPosition()[0]);
    assertEquals(0, wr1.getPosition()[1]);
    assertEquals(3, wr2.getPosition()[0]);
    assertEquals(5, wr2.getPosition()[1]);
  }

  /**
   * Test that the getColor method returns the appropriate color for each object.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, wr1.getColor());
    assertEquals(Color.WHITE, wr2.getColor());
    assertEquals(Color.BLACK, br1.getColor());
    assertEquals(Color.BLACK, br2.getColor());
  }

  /**
   * Test the onBoard method can accurately tell if a position is on the board.
   */
  @Test
  public void testOnBoard() {
    assertTrue(wr1.onBoard(wr1.getRow(), wr1.getColumn()));
    assertTrue(wr2.onBoard(wr2.getRow(), wr2.getColumn()));
    assertTrue(br1.onBoard(br1.getRow(), br1.getColumn()));

    assertFalse(wr1.onBoard(-1, 0));
    assertFalse(wr1.onBoard(8, 0));
    assertFalse(wr1.onBoard(0, -1));
    assertFalse(wr1.onBoard(0, 8));
  }

  /**
   * Make sure objects can only move to appropriate locations.
   */
  @Test
  public void canMove() {
    assertTrue(wr2.canMove(4, 5));
    assertTrue(wr2.canMove(3, 4));
    assertTrue(wr2.canMove(2, 5));
    assertTrue(wr2.canMove(3, 6));
    assertTrue(br2.canMove(4, 1));
  }

  /**
   * Make sure the objects can only kill pieces they are allowed to kill.
   */
  @Test
  public void canKill() {
    ChessPiece target1 = new Rook(4, 0, Color.WHITE);
    ChessPiece target2 = new Rook(3, 6, Color.BLACK);
    assertTrue(br2.canKill(target1));
    assertFalse(br1.canKill(target1));
    assertFalse(wr1.canKill(target1));
    assertFalse(wr2.canKill(target1));

    assertTrue(wr2.canKill(target2));
    assertFalse(br2.canKill(target2));
  }
}
