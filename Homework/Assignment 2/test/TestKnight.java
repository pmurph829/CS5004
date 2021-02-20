import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the Knight class.
 */
public class TestKnight {
  public ChessPiece wk1;
  public ChessPiece wk2;
  public ChessPiece bk1;
  public ChessPiece bk2;

  /**
   * Initialize some Knights on the board.
   */
  @Before
  public void setUp() {
    wk1 = new Knight(0, 0, Color.WHITE);
    wk2 = new Knight(3, 5, Color.WHITE);
    bk1 = new Knight(7, 7, Color.BLACK);
    bk2 = new Knight(4, 6, Color.BLACK);
  }

  /**
   * Test the getRow method returns the appropriate row for each object.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, wk1.getRow());
    assertEquals(3, wk2.getRow());
    assertEquals(7, bk1.getRow());
    assertEquals(4, bk2.getRow());
  }

  /**
   * Test the getCol method returns the appropriate column for each object.
   */
  @Test
  public void testGetCol() {
    assertEquals(0, wk1.getColumn());
    assertEquals(5, wk2.getColumn());
    assertEquals(7, bk1.getColumn());
    assertEquals(6, bk2.getColumn());
  }

  /**
   * Test that the getPosition method returns the correct position for each object.
   */
  @Test
  public void testGetPosition() {
    assertEquals(0, wk1.getPosition()[0]);
    assertEquals(0, wk1.getPosition()[1]);
    assertEquals(3, wk2.getPosition()[0]);
    assertEquals(5, wk2.getPosition()[1]);
  }

  /**
   * Test that the getColor method returns the appropriate color for each object.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, wk1.getColor());
    assertEquals(Color.WHITE, wk2.getColor());
    assertEquals(Color.BLACK, bk1.getColor());
    assertEquals(Color.BLACK, bk2.getColor());
  }

  /**
   * Test the onBoard method can accurately tell if a position is on the board.
   */
  @Test
  public void testOnBoard() {
    assertTrue(wk1.onBoard(wk1.getRow(), wk1.getColumn()));
    assertTrue(wk2.onBoard(wk2.getRow(), wk2.getColumn()));
    assertTrue(bk1.onBoard(bk1.getRow(), bk1.getColumn()));

    assertFalse(wk1.onBoard(-1, 0));
    assertFalse(wk1.onBoard(8, 0));
    assertFalse(wk1.onBoard(0, -1));
    assertFalse(wk1.onBoard(0, 8));
  }

  /**
   * Make sure objects can only move to appropriate locations.
   */
  @Test
  public void testCanMove() {
    // Tests for wk1
    assertTrue(wk1.canMove(2, 1));
    assertTrue(wk1.canMove(1, 2));
    assertFalse(wk1.canMove(1, 1));
    assertFalse(wk1.canMove(2, 0));
    assertFalse(wk1.canMove(-1, 2));

    // Tests for bk1
    assertTrue(bk1.canMove(6, 5));
    assertTrue(bk1.canMove(5, 6));
    assertFalse(bk1.canMove(6, 7));

    // Tests for wk2
    assertTrue(wk2.canMove(5, 4));
    assertTrue(wk2.canMove(5, 6));
    assertTrue(wk2.canMove(4, 3));
    assertTrue(wk2.canMove(4, 7));
    assertTrue(wk2.canMove(2, 3));
    assertTrue(wk2.canMove(2, 7));
    assertTrue(wk2.canMove(1, 4));
    assertTrue(wk2.canMove(1, 6));
    assertFalse(wk2.canMove(5, 5));
    assertFalse(wk2.canMove(5, 3));
    assertFalse(wk2.canMove(2, 4));
    assertFalse(wk2.canMove(5, 1));
  }

  /**
   * Make sure the objects can only kill pieces they are allowed to kill.
   */
  @Test
  public void testCanKill() {
    ChessPiece target1 = new Knight(5, 4, Color.WHITE);
    ChessPiece target2 = new Knight(5, 6, Color.WHITE);
    ChessPiece target3 = new Knight(2, 7, Color.BLACK);

    // Tests for wk1
    assertFalse(wk1.canKill(target1));
    assertFalse(wk1.canKill(target2));
    assertFalse(wk1.canKill(target3));

    // Tests for wk2
    assertFalse(wk2.canKill(target1));
    assertFalse(wk2.canKill(target2));
    assertTrue(wk2.canKill(target3));

    // Tests for bk1
    assertFalse(bk1.canKill(target1));
    assertTrue(bk1.canKill(target2));
    assertFalse(bk1.canKill(target3));

    // Tests for bk2
    assertTrue(bk2.canKill(target1));
    assertFalse(bk2.canKill(target2));
    assertFalse(bk2.canKill(target3));

    ChessPiece dum1 = new Pawn(1, 0, Color.BLACK);
    ChessPiece dum2 = new Pawn(1, 2, Color.BLACK);
    ChessPiece dumTar = new Pawn(0, 1, Color.WHITE);

    assertTrue(dum1.canKill(dumTar));
    assertTrue(dum2.canKill(dumTar));
  }
}
