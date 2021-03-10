/** Class that represents an abstract term that can be placed into a Polynomial. */
public abstract class AbstractTerm implements Term {
  protected Term next;
  protected int coefficient;
  protected int power;

  @Override
  public void setNext(Term t) {
    this.next = t;
  }

  @Override
  public int getCoefficient() {
    return this.coefficient;
  }

  @Override
  public void setCoefficient(int coeff) {
    this.coefficient = coeff;
  }

  @Override
  public int getPower() {
    return this.power;
  }

  @Override
  public void insertTerm(int coeff, int power) {
    if (power == this.power) { // Add the coefficients if the term of this power exists already.
      this.coefficient += coeff;
      return;
    } else if (power > this.next.getPower()) {
      Term t = new PowerTerm(coeff, power, this.next);
      this.next = t;
      return;
    } else if (power <= this.next.getPower()) {
      this.next.insertTerm(coeff, power);
    }
  }

  @Override
  public Term removeTermHelp(int power, Term prev) {
    if (power == prev.getPower() && power == this.power) { // this is the first term
      return this.next;
    }
    if (power == this.power) {
      prev.setNext(this.next);
      return null;
    }
    return this.next.removeTermHelp(power, this);
  }

  @Override
  public int findCoefficient(int power) {
    if (power == this.power) {
      return this.coefficient;
    }
    if (this.next != null) {
      return this.next.findCoefficient(power);
    } else {
      return 0;
    }
  }

  /**
   * Calculate the value of a single term at a specified value of "x".
   *
   * @param var the value of x.
   * @return the result of the calculation.
   */
  private double getTermValue(double var) {
    return this.coefficient * Math.pow(var, this.power);
  }

  @Override
  public double evaluate(double var, double acc) {
    if (this.next == null) {
      return acc + this.getTermValue(var);
    }
    acc += this.getTermValue(var);
    return this.next.evaluate(var, acc);
  }

  @Override
  public PolynomialImpl addHelp(PolynomialImpl acc) {
    acc.addTerm(this.coefficient, this.power);
    return this.next.addHelp(acc);
  }
}
