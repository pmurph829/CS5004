import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the Queen class.
 */
public class TestQueen {
  public ChessPiece wq1;
  public ChessPiece wq2;
  public ChessPiece bq1;
  public ChessPiece bq2;

  /**
   * Make sure Queens can be initialized properly.
   */
  @Before
  public void setUp() {
    wq1 = new Queen(0, 0, Color.WHITE);
    wq2 = new Queen(3, 5, Color.WHITE);
    bq1 = new Queen(7, 7, Color.BLACK);
    bq2 = new Queen(4, 6, Color.BLACK);
  }

  /**
   * Test the getRow method returns the appropriate row for each object.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, wq1.getRow());
    assertEquals(3, wq2.getRow());
    assertEquals(7, bq1.getRow());
    assertEquals(4, bq2.getRow());
  }

  /**
   * Test the getCol method returns the appropriate column for each object.
   */
  @Test
  public void testGetCol() {
    assertEquals(0, wq1.getColumn());
    assertEquals(5, wq2.getColumn());
    assertEquals(7, bq1.getColumn());
    assertEquals(6, bq2.getColumn());
  }

  /**
   * Test that the getPosition method returns the correct position for each object.
   */
  @Test
  public void testGetPosition() {
    assertEquals(0, wq1.getPosition()[0]);
    assertEquals(0, wq1.getPosition()[1]);
    assertEquals(3, wq2.getPosition()[0]);
    assertEquals(5, wq2.getPosition()[1]);
  }

  /**
   * Test that the getColor method returns the appropriate color for each object.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, wq1.getColor());
    assertEquals(Color.WHITE, wq2.getColor());
    assertEquals(Color.BLACK, bq1.getColor());
    assertEquals(Color.BLACK, bq2.getColor());
  }

  /**
   * Test the onBoard method can accurately tell if a position is on the board.
   */
  @Test
  public void testOnBoard() {
    assertTrue(wq1.onBoard(wq1.getRow(), wq1.getColumn()));
    assertTrue(wq2.onBoard(wq2.getRow(), wq2.getColumn()));
    assertTrue(bq1.onBoard(bq1.getRow(), bq1.getColumn()));

    assertFalse(wq1.onBoard(-1, 0));
    assertFalse(wq1.onBoard(8, 0));
    assertFalse(wq1.onBoard(0, -1));
    assertFalse(wq1.onBoard(0, 8));
  }

  /**
   * Make sure objects can only move to appropriate locations.
   */
  @Test
  public void canMove() {
    assertTrue(wq2.canMove(4, 5));
    assertTrue(wq2.canMove(3, 4));
    assertTrue(wq2.canMove(2, 5));
    assertTrue(wq2.canMove(3, 6));

    assertTrue(bq2.canMove(4, 1));

    assertTrue(wq1.canMove(1, 1));
    assertTrue(wq1.canMove(4, 4));
    assertTrue(wq1.canMove(7, 7));

    assertTrue(wq2.canMove(6, 2));
    assertTrue(wq2.canMove(1, 3));
    assertTrue(wq2.canMove(2, 6));
    assertTrue(wq2.canMove(5, 7));

    assertFalse(wq1.canMove(2, 7));
  }

  /**
   * Make sure the objects can only kill pieces they are allowed to kill.
   */
  @Test
  public void canKill() {
    ChessPiece target1 = new Queen(4, 4, Color.BLACK);
    ChessPiece target2 = new Queen(5, 1, Color.WHITE);

    assertTrue(wq1.canKill(target1));
    assertTrue(wq2.canKill(target1));
    assertTrue(wq2.canKill(bq2));
    assertTrue(bq2.canKill(wq2));
    assertTrue(wq1.canKill(bq1));
    assertTrue(bq1.canKill(wq1));

    assertFalse(bq1.canKill(target1));
    assertFalse(bq2.canKill(target1));
    assertFalse(wq1.canKill(target2));
    assertFalse(wq2.canKill(target2));
    assertFalse(bq1.canKill(target2));
    assertFalse(bq2.canKill(target2));
  }
}
