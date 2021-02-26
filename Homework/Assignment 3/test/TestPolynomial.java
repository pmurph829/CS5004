import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPolynomial {
  PolynomialImpl p1;

  @Before
  public void setUp() {
    p1 = new PolynomialImpl();
    p1.addTerm(2, 1);
    p1.addTerm(4, 3);
    p1.addTerm(-3, 2);
    p1.addTerm(5, 4);
  }

  @Test
  public void test_toString() {
    String s = "5x^4 +4x^3 -3x^2 +2x^1";
    assertEquals(s, p1.toString());
  }

  @Test
  public void test_addTerm() {
    PolynomialImpl p2 = new PolynomialImpl();
    assertEquals("", p2.toString());
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
  }

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
    p3.removeTerm(1);
    assertEquals("5x^4 +4x^3", p3.toString());
    p3.removeTerm(4);
    assertEquals("4x^3", p3.toString());
    p3.removeTerm(3);
    assertEquals("", p3.toString());
  }

  @Test
  public void test_getDegree() {
    assertEquals(4, p1.getDegree());
  }

  @Test
  public void test_getCoefficient() {
    assertEquals(2, p1.getCoefficient(1));
    assertEquals(-3, p1.getCoefficient(2));
    assertEquals(4, p1.getCoefficient(3));
    assertEquals(5, p1.getCoefficient(4));
  }

  @Test
  public void test_evaluate() {
    assertEquals(0, p1.evaluate(0), 0.001);
    assertEquals(8, p1.evaluate(1), 0.001);
    assertEquals(104, p1.evaluate(2), 0.001);
  }

  @Test
  public void test_add() {
    PolynomialImpl p4 = new PolynomialImpl();
    p4.addTerm(2, 1);
    p4.addTerm(4, 3);
    p4.addTerm(-3, 2);
    p4.addTerm(5, 4);

    assertEquals("10x^4 +8x^3 -6x^2 +4x^1", p1.add(p4).toString());
  }

  @Test
  public void test_Constructor() {
    PolynomialImpl p5 = new PolynomialImpl("2x^3 +3x^2 -6x^1 -4");
    assertEquals("2x^3 +3x^2 -6x^1 -4", p5.toString());
  }
}
