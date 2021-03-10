/**
 * Class that implements the Polynomial interface. Contains the first term of a Polynomial. Contains
 * methods to perform various methods on the Polynomial.
 */
public class PolynomialImpl implements Polynomial {
  private Term firstTerm = null;

  /** Create a new instance of PolynomialImpl that is equal to zero. */
  public PolynomialImpl() {
    this.firstTerm = new FinalTerm();
  }

  /**
   * * Create a PolynomialImpl object by parsing a given string.
   *
   * @param p the string that will be parsed to create terms.
   * @throws IllegalArgumentException if an invalid string is passed.
   */
  public PolynomialImpl(String p) throws IllegalArgumentException {
    try {
      this.firstTerm = new FinalTerm();
      if ("".equals(p)) {
        return;
      }
      String[] terms = p.split(" ");
      for (int i = terms.length - 1; i >= 0; i--) {
        String s = terms[i];
        if (s.startsWith("+")) {
          s = s.substring(1);
        }
        String[] inputs = s.split("x");
        if (inputs.length == 1) {
          this.addTerm(Integer.parseInt(inputs[0]), 0);
        }
        if (inputs.length > 1) {
          if (this.firstTerm == null) {
            this.firstTerm = new FinalTerm();
          }
          int coeff = Integer.parseInt(inputs[0]);
          int power = Integer.parseInt(inputs[1]);
          this.addTerm(coeff, power);
        }
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(e.toString());
    }
  }

  @Override
  public String toString() {
    if (this.firstTerm.getPower() == 0 && this.firstTerm.getCoefficient() == 0) {
      return "0";
    }
    String s = this.firstTerm.toString().strip();
    if (s.startsWith("+")) {
      return s.substring(1);
    }
    return s;
  }

  @Override
  public void addTerm(int coeff, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative.");
    } else if (power
        > this.firstTerm.getPower()) { // The term belongs at the front of the Polynomial
      Term t = new PowerTerm(coeff, power, this.firstTerm);
      this.firstTerm = t;
      return;
    }
    this.firstTerm.insertTerm(coeff, power);
  }

  @Override
  public void removeTerm(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative.");
    }
    Term t = this.firstTerm.removeTermHelp(power, this.firstTerm);
    if (t != null) {
      this.firstTerm = t;
    }
  }

  @Override
  public int getDegree() {
    return this.firstTerm.getPower();
  }

  @Override
  public int getCoefficient(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative.");
    }
    return this.firstTerm.findCoefficient(power);
  }

  @Override
  public double evaluate(double var) {
    return this.firstTerm.evaluate(var, 0);
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("Other was not of class PolynomialImpl.");
    }
    PolynomialImpl newPoly = (PolynomialImpl) other;

    return this.firstTerm.addHelp(newPoly);
  }
}
