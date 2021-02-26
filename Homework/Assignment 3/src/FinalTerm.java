public class FinalTerm extends AbstractTerm {
  public FinalTerm() {
    this.next = null;
    this.coefficient = 0;
    this.power = 0;
  }

  public FinalTerm(int coeff) {
    this.next = null;
    //    this.previous = prev;
    this.coefficient = coeff;
    this.power = 0;
  }

  public String toString() {
    if (this.coefficient == 0) {
      return "0";
    } else {
      return String.valueOf(this.coefficient);
    }
  }

  @Override
  public void setNext(Term t) {
    return;
  }

  @Override
  public PolynomialImpl addHelp(PolynomialImpl acc) {
    return acc;
  }
}
