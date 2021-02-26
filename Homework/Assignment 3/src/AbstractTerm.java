public abstract class AbstractTerm implements Term {
  protected Term next;
  protected int coefficient;
  protected int power;

  @Override
  public Term getNext() {
    return this.next;
  }

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
  public void removeTerm(int power) {
    if (this.next.getPower() == power) {
      if (power == 0) {
        this.next = new FinalTerm();
      }
      this.next = this.next.getNext();
      return;
    }
    if (this.next != null) {
      this.next.removeTerm(power);
    }
    return;
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
