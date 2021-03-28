import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Tests for the MarbleSolitaireImpl class. */
public class MarbleSolitaireImplTest {

  MarbleSolitaireModelImpl game1;
  MarbleSolitaireModelImpl game2;
  MarbleSolitaireModelImpl game3;
  MarbleSolitaireModelImpl game4;

  @Before
  public void setUp() {
    game1 = new MarbleSolitaireModelImpl();
    game2 = new MarbleSolitaireModelImpl(1, 3);
    game3 = new MarbleSolitaireModelImpl(7);
    game4 = new MarbleSolitaireModelImpl(5, 6, 4);
  }

  @Test
  public void test_constructors() {
    assertEquals(
        "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game1.toString());

    assertEquals(
        "    O O O\n"
            + "    O _ O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game2.toString());

    assertEquals(
        "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O _ O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O",
        game3.toString());

    assertEquals(
        "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O",
        game4.toString());
  }

  @Test
  public void test_validMove1() {
    // move up
    game1.move(5, 3, 3, 3);
    assertEquals(
        "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O",
        game1.toString());
  }

  @Test
  public void test_validMove2() {
    // move down
    game1.move(1, 3, 3, 3);
    assertEquals(
        "    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game1.toString());
  }

  @Test
  public void test_validMove3() {
    // move left
    game1.move(3, 5, 3, 3);
    assertEquals(
        "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game1.toString());
  }

  @Test
  public void test_validMove4() {
    // move right
    game1.move(3, 1, 3, 3);
    assertEquals(
        "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game1.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidMove1() {
    // Move that would work on standard board with armlength 5
    game4.move(6, 4, 6, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidMove2() {
    // move to occupied space
    game4.move(6, 6, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidMove3() {
    // jump two marbles
    game4.move(6, 7, 6, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidMove4() {
    // move diagonally
    game4.move(8, 6, 6, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidMove5a() {
    // move off board
    game4.move(0, 4, 0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidMove5b() {
    // move off board
    game4.move(4, 12, 4, 13);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidMove6() {
    // Play a couple moves
    game1.move(1, 3, 3, 3);
    game1.move(2, 1, 2, 3);
    game1.move(3, 3, 1, 3);
    game1.move(3, 1, 3, 3);
    game1.move(0, 2, 2, 2);
    // move from empty spot to valid spot
    game1.move(2, 1, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_invalidMove7() {
    // Play a couple moves
    game1.move(1, 3, 3, 3);
    game1.move(2, 1, 2, 3);
    game1.move(3, 3, 1, 3);
    game1.move(3, 1, 3, 3);
    game1.move(0, 2, 2, 2);
    // no middle marble
    game1.move(3, 3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_isGameOver() {
    assertFalse(game1.isGameOver());
    assertFalse(game2.isGameOver());
    assertFalse(game3.isGameOver());
    assertFalse(game4.isGameOver());
    game1.move(3, 1, 3, 3);
    assertEquals(
        "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game1.toString());
    game1.move(5, 2, 3, 2);
    game1.move(4, 0, 4, 2);
    game1.move(3, 2, 5, 2);
    game1.move(6, 2, 4, 2);
    game1.move(5, 4, 5, 2);
    game1.move(4, 3, 4, 1);
    game1.move(1, 2, 3, 2);
    game1.move(4, 5, 4, 3);
    game1.move(2, 0, 4, 0);
    game1.move(4, 0, 4, 2);
    game1.move(4, 2, 4, 4);
    game1.move(6, 4, 6, 2);
    game1.move(6, 2, 4, 2);
    game1.move(4, 2, 2, 2);
    game1.move(3, 4, 3, 2);
    game1.move(3, 2, 1, 2);
    game1.move(2, 4, 2, 2);
    game1.move(2, 1, 2, 3);
    game1.move(2, 6, 2, 4);
    game1.move(4, 6, 2, 6);
    game1.move(1, 4, 3, 4);
    game1.move(4, 4, 2, 4);
    game1.move(1, 2, 1, 4);
    game1.move(2, 3, 2, 5);
    game1.move(2, 6, 2, 4);
    game1.move(1, 4, 3, 4);
    assertFalse(game1.isGameOver());
    game1.move(3, 5, 3, 3);

    assertEquals(
        "    O O O\n"
            + "    _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _",
        game1.toString());
    assertTrue(game1.isGameOver());
    assertEquals(4, game1.getScore());
    game1.move(3, 3, 5, 3);
  }

  @Test
  public void test_getGameState() {
    // Play a couple moves
    game1.move(1, 3, 3, 3);
    game1.move(2, 1, 2, 3);
    game1.move(3, 3, 1, 3);
    game1.move(3, 1, 3, 3);
    game1.move(0, 2, 2, 2);
    assertEquals(
        "    _ O O\n"
            + "    _ O O\n"
            + "O _ O _ O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game1.getGameState());
  }

  @Test
  public void test_getScore() {
    // Play a couple moves
    game1.move(1, 3, 3, 3);
    game1.move(2, 1, 2, 3);
    game1.move(3, 3, 1, 3);
    game1.move(3, 1, 3, 3);
    game1.move(0, 2, 2, 2);

    assertEquals(27, game1.getScore());
  }
}
