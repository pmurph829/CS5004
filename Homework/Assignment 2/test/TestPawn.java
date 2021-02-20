import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the Pawn class.
 */
public class TestPawn {
  public ChessPiece wp1;
  public ChessPiece wp2;
  public ChessPiece bp1;
  public ChessPiece bp2;

  /**
   * Make sure Pawns can be initialized on the board.
   */
  @Before
  public void setUp() {
    wp1 = new Pawn(0, 0, Color.WHITE);
    wp2 = new Pawn(3, 5, Color.WHITE);
    bp1 = new Pawn(7, 7, Color.BLACK);
    bp2 = new Pawn(4, 6, Color.BLACK);
  }

  /**
   * Test the getRow method returns the appropriate row for each object.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, wp1.getRow());
    assertEquals(3, wp2.getRow());
    assertEquals(7, bp1.getRow());
    assertEquals(4, bp2.getRow());
  }

  /**
   * Test the getCol method returns the appropriate column for each object.
   */
  @Test
  public void testGetCol() {
    assertEquals(0, wp1.getColumn());
    assertEquals(5, wp2.getColumn());
    assertEquals(7, bp1.getColumn());
    assertEquals(6, bp2.getColumn());
  }

  /**
   * Test that the getPosition method returns the correct position for each object.
   */
  @Test
  public void testGetPosition() {
    assertEquals(0, wp1.getPosition()[0]);
    assertEquals(0, wp1.getPosition()[1]);
    assertEquals(3, wp2.getPosition()[0]);
    assertEquals(5, wp2.getPosition()[1]);
  }

  /**
   * Test that the getColor method returns the appropriate color for each object.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, wp1.getColor());
    assertEquals(Color.WHITE, wp2.getColor());
    assertEquals(Color.BLACK, bp1.getColor());
    assertEquals(Color.BLACK, bp2.getColor());
  }

  /**
   * Test the onBoard method can accurately tell if a position is on the board.
   */
  @Test
  public void testOnBoard() {
    assertTrue(wp1.onBoard(wp1.getRow(), wp1.getColumn()));
    assertTrue(wp2.onBoard(wp2.getRow(), wp2.getColumn()));
    assertTrue(bp1.onBoard(bp1.getRow(), bp1.getColumn()));

    assertFalse(wp1.onBoard(-1, 0));
    assertFalse(wp1.onBoard(8, 0));
    assertFalse(wp1.onBoard(0, -1));
    assertFalse(wp1.onBoard(0, 8));
  }

  /**
   * Make sure objects can only move to appropriate locations.
   */
  @Test
  public void TestCanMove() {
    assertTrue(wp1.canMove(1, 0));
    assertTrue(wp2.canMove(4, 5));
    assertTrue(bp1.canMove(6, 7));
    assertTrue(bp2.canMove(3, 6));
    assertFalse(wp1.canMove(2, 0));
    assertFalse(wp2.canMove(4, 6));
    assertFalse(bp1.canMove(7, 6));
    assertFalse(bp2.canMove(5, 6));
  }

  /**
   * Make sure the objects can only kill pieces they are allowed to kill.
   */
  @Test
  public void testCanKill() {
    ChessPiece target1 = new Pawn(1, 1, Color.BLACK);
    ChessPiece target2 = new Pawn(6, 7, Color.WHITE);
    ChessPiece target3 = new Pawn(4, 4, Color.WHITE);
    ChessPiece target4 = new Pawn(2, 4, Color.BLACK);

    assertTrue(wp1.canKill(target1));
    assertTrue(wp2.canKill(bp2));
    assertTrue(bp2.canKill(wp2));

    assertFalse(bp1.canKill(target2));
    assertFalse(wp2.canKill(target3));
    assertFalse(wp2.canKill(target4));
  }
}
