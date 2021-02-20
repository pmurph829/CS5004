public class Term extends PolynomialImpl{
  public Term(int coeff, int power, Polynomial next){
    this.coefficient = coeff;
    this.power = power;
    this.next = next;
  }
}
