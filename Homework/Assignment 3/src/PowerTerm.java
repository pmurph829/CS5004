/** Class that represents a term in a polynomial that has a nonzero, non-negative power. */
public class PowerTerm extends AbstractTerm {

  /**
   * Create a new PowerTerm.
   *
   * @param coeff the coefficient of the term.
   * @param power the power the term is raised to.
   * @param next the next term in the Polynomial.
   * @throws IllegalArgumentException if the power is negative.
   */
  public PowerTerm(int coeff, int power, Term next) throws IllegalArgumentException {
    if (power <= 0) {
      throw new IllegalArgumentException("Cannot have a power <= 0 for PowerTerm");
    }
    this.coefficient = coeff;
    this.power = power;
    this.next = next;
  }

  @Override
  public String toString() {
    String s = String.valueOf(this.coefficient) + "x^" + String.valueOf(this.power) + " ";
    if (this.coefficient < 0) {
      return s + this.next.toString();
    }
    return "+" + s + this.next.toString();
  }
}
