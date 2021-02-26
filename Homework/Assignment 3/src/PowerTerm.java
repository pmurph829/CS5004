public class PowerTerm extends AbstractTerm {
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
    return String.valueOf(this.coefficient) + "x^" + String.valueOf(this.power);
  }
}
