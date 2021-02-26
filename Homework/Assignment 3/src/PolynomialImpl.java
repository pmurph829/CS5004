public class PolynomialImpl implements Polynomial {
  private Term firstTerm = null;

  public PolynomialImpl() {
    this.firstTerm = new FinalTerm();
  }

  public PolynomialImpl(String p) {
    String[] terms = p.split(" ");
    for (int i = terms.length - 1; i >= 0; i--) {
      String s = terms[i];
      if (s.startsWith("+")) {
        s = s.substring(1);
      }
      String[] inputs = s.split("x\\^");
      if (inputs.length == 1) {
        this.firstTerm = new FinalTerm(Integer.parseInt(inputs[0]));
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
  }

  @Override
  public String toString() {
    Term iter = this.firstTerm;
    String s = "";
    while (iter != null) {
      if (iter.getCoefficient() <= 0) {
        s += iter.toString() + " ";
      } else {
        s += "+" + iter.toString() + " ";
      }
      iter = iter.getNext();
    }
    s = s.strip();
    if (s.startsWith("+")) {
      return s.substring(1);
    }
    return s;
  }

  @Override
  public void addTerm(int coeff, int power) throws IllegalArgumentException {
    // Case 0: zero or negative power is passed as parameter
    if (power < 0) {
      throw new IllegalArgumentException("Cannot add a term with a negative power.");
    }

    // Case 1: new term has a greater power than first term
    if (power > this.firstTerm.getPower()) {
      this.firstTerm = new PowerTerm(coeff, power, this.firstTerm);
      return;
    } else if (power == this.firstTerm.getPower()) {
      this.firstTerm.setCoefficient(this.firstTerm.getCoefficient() + coeff);
      return;
    }

    Term iter = this.firstTerm.getNext();
    Term prev = this.firstTerm;
    while (iter != null) {
      // Case 2: new term belongs before iterator
      if (power > iter.getPower()) {
        Term t = new PowerTerm(coeff, power, iter);
        prev.setNext(t);
        return;

        // Case 3: new term has same power as iterator
      } else if (power == iter.getPower()) {
        iter.setCoefficient(iter.getCoefficient() + coeff);
        return;
        // Case 4: new term belongs after iterator - repeat loop
      } else {
        prev = iter;
        iter = iter.getNext();
      }
    }
  }

  @Override
  public void removeTerm(int power) {
    if (this.firstTerm.getPower() == power) {
      this.firstTerm = this.firstTerm.getNext();
      return;
    }
    this.firstTerm.removeTerm(power);
  }

  @Override
  public int getDegree() {
    return this.firstTerm.getPower();
  }

  @Override
  public int getCoefficient(int power) {
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
