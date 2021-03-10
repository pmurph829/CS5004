import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Tests for the Polynomial Class. */
public class TestPolynomial {
  PolynomialImpl p1;

  /** Set up Polynomial. */
  @Before
  public void setUp() {
    p1 = new PolynomialImpl();
    p1.addTerm(2, 1);
    p1.addTerm(4, 3);
    p1.addTerm(-3, 2);
    p1.addTerm(5, 4);
  }

  /** Test the toString method. */
  @Test
  public void test_toString() {
    String s = "5x^4 +4x^3 -3x^2 +2x^1";
    assertEquals(s, p1.toString());
  }

  /** test the addTerm method. */
  @Test
  public void test_addTerm() {
    PolynomialImpl p2 = new PolynomialImpl();
    assertEquals("0", p2.toString());
    p2.addTerm(2, 1);
    assertEquals("2x^1", p2.toString());
    p2.addTerm(4, 3);
    assertEquals("4x^3 +2x^1", p2.toString());
    p2.addTerm(-3, 2);
    assertEquals("4x^3 -3x^2 +2x^1", p2.toString());
    p2.addTerm(5, 4);
    assertEquals("5x^4 +4x^3 -3x^2 +2x^1", p2.toString());
    p2.addTerm(2, 3);
    assertEquals("5x^4 +6x^3 -3x^2 +2x^1", p2.toString());
    p2.addTerm(5, 4);
    assertEquals("10x^4 +6x^3 -3x^2 +2x^1", p2.toString());

    PolynomialImpl p2a = new PolynomialImpl("5x2 +4x1 -2");
    assertEquals("5x^2 +4x^1 -2", p2a.toString());
    p2a.addTerm(3, 0);
    p2a.addTerm(0, 2);
    assertEquals("5x^2 +4x^1 +1", p2a.toString());
  }

  /** Test the removeTerm method. */
  @Test
  public void test_removeTerm() {
    PolynomialImpl p3 = new PolynomialImpl();
    p3.addTerm(2, 1);
    p3.addTerm(4, 3);
    p3.addTerm(-3, 2);
    p3.addTerm(5, 4);
    assertEquals("5x^4 +4x^3 -3x^2 +2x^1", p3.toString());
    p3.removeTerm(2);
    assertEquals("5x^4 +4x^3 +2x^1", p3.toString());
    p3.removeTerm(2);
    p3.removeTerm(1);
    assertEquals("5x^4 +4x^3", p3.toString());
    p3.removeTerm(4);
    assertEquals("4x^3", p3.toString());
    p3.removeTerm(3);
    assertEquals("0", p3.toString());
    p3.removeTerm(0);
    assertEquals("0", p3.toString());
  }

  /** Tests the getDegree method. */
  @Test
  public void test_getDegree() {
    PolynomialImpl pa = new PolynomialImpl("2x3 +3x2 -6x1 -4");
    PolynomialImpl pb = new PolynomialImpl();
    PolynomialImpl pc = new PolynomialImpl("5x2 +4x1 -2");
    PolynomialImpl pd = new PolynomialImpl("-50x3 +1x2 +3");
    PolynomialImpl pe = new PolynomialImpl("2x5 -3x2 +4x1 -10");
    PolynomialImpl pf = new PolynomialImpl("");
    PolynomialImpl pg = new PolynomialImpl("25");
    PolynomialImpl ph = new PolynomialImpl("-567");
    assertEquals(4, p1.getDegree());
    assertEquals(3, pa.getDegree());
    assertEquals(0, pb.getDegree());
    assertEquals(2, pc.getDegree());
    assertEquals(3, pd.getDegree());
    assertEquals(5, pe.getDegree());
    assertEquals(0, pf.getDegree());
    assertEquals(0, pg.getDegree());
    assertEquals(0, ph.getDegree());

    pa.removeTerm(3);
    pa.removeTerm(2);
    assertEquals(1, pa.getDegree());
    pd.removeTerm(3);
    assertEquals(2, pd.getDegree());
    pe.addTerm(2, 4);
    assertEquals(5, pe.getDegree());
    pe.removeTerm(4);
    pe.removeTerm(2);
    pe.removeTerm(1);
    assertEquals(5, pe.getDegree());
    pe.removeTerm(5);
    assertEquals(0, pe.getDegree());
    pg.removeTerm(0);
    assertEquals(0, pg.getDegree());
  }

  /** Tests the getCoefficient method. */
  @Test
  public void test_getCoefficient() {
    assertEquals(2, p1.getCoefficient(1));
    assertEquals(-3, p1.getCoefficient(2));
    assertEquals(4, p1.getCoefficient(3));
    assertEquals(5, p1.getCoefficient(4));
  }

  /** Tests the evaluate method. */
  @Test
  public void test_evaluate() {
    assertEquals(0, p1.evaluate(0), 0.001);
    assertEquals(8, p1.evaluate(1), 0.001);
    assertEquals(-4, p1.evaluate(-1), 0.001);
    assertEquals(104, p1.evaluate(2), 0.001);
  }

  /** Tests the add method. */
  @Test
  public void test_add() {
    PolynomialImpl p4 = new PolynomialImpl();
    p4.addTerm(2, 1);
    p4.addTerm(4, 3);
    p4.addTerm(-3, 2);
    p4.addTerm(5, 4);

    assertEquals("10x^4 +8x^3 -6x^2 +4x^1", p1.add(p4).toString());
  }

  /** Test the constructor method. */
  @Test
  public void test_Constructor() {
    PolynomialImpl p5 = new PolynomialImpl("2x3 +3x2 -6x1 -4");
    PolynomialImpl p6 = new PolynomialImpl();
    PolynomialImpl p7 = new PolynomialImpl("5x2 +4x1 -2");
    PolynomialImpl p8 = new PolynomialImpl("-50x3 +1x2 +3");
    PolynomialImpl p9 = new PolynomialImpl("2x5 -3x2 +4x1 -10");
    PolynomialImpl p10 = new PolynomialImpl("");
    PolynomialImpl p11 = new PolynomialImpl("25");
    PolynomialImpl p12 = new PolynomialImpl("-567");
    PolynomialImpl p13 = new PolynomialImpl("-3x2 +2x5 -10 +4x1");

    assertEquals("2x^3 +3x^2 -6x^1 -4", p5.toString());
    assertEquals("0", p6.toString());
    assertEquals("5x^2 +4x^1 -2", p7.toString());
    assertEquals("-50x^3 +1x^2 +3", p8.toString());
    assertEquals("2x^5 -3x^2 +4x^1 -10", p9.toString());
    assertEquals("0", p10.toString());
    assertEquals("25", p11.toString());
    assertEquals("-567", p12.toString());
    assertEquals("2x^5 -3x^2 +4x^1 -10", p13.toString());
  }
}
