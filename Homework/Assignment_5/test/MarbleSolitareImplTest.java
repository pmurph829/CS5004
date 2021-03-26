import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

public class MarbleSolitareImplTest {

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
  public void test_toString() {
    assertEquals(
        "    O O O    \n"
            + "    O O O    \n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O    \n"
            + "    O O O    \n",
        game1.toString());
  }

  @Test
  public void test_getGameState() {
    System.out.println(game2.getGameState());
  }
}
