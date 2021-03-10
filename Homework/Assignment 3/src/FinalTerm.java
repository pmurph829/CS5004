/** Class that represents a final term in a polynomial (degree = 0). */
public class FinalTerm extends AbstractTerm {

  /** Create a new FinalTerm with coefficient = 0. */
  public FinalTerm() {
    this.next = null;
    this.coefficient = 0;
    this.power = 0;
  }

  /**
   * Create a new FinalTerm with a specified coefficient.
   *
   * @param coeff the coefficient of the FinalTerm.
   */
  public FinalTerm(int coeff) {
    this.next = null;
    this.coefficient = coeff;
    this.power = 0;
  }

  @Override
  public String toString() {
    if (this.coefficient == 0) {
      return "";
    } else if (this.coefficient > 0) {
      return "+" + String.valueOf(this.coefficient);
    } else {
      return String.valueOf(this.coefficient);
    }
  }

  @Override
  public void insertTerm(int coeff, int power) {
    if (power != 0) { // The term was not found in the polynomial.
      return;
    } else {
      this.coefficient += coeff;
    }
  }

  @Override
  public Term removeTermHelp(int power, Term prev) {
    if (power == prev.getPower() && power == this.power) { // this is the first term
      this.coefficient = 0;
      return this;
    }
    if (power == 0) { // The term to remove is the FinalTerm
      this.coefficient = 0;
      return null;
    } else { // The term to remove was not found
      return null;
    }
  }

  @Override
  public PolynomialImpl addHelp(PolynomialImpl acc) {
    acc.addTerm(this.coefficient, this.power);
    return acc;
  }
}
