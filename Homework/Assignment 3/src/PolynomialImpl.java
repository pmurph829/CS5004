public abstract class PolynomialImpl implements Polynomial{
  protected Polynomial next;
  protected int coefficient;
  protected int power;


  public EmptyTerm Polynomial(){
    return new EmptyTerm();
  }
  
  public Polynomial Polynomial(String p){
    EmptyTerm tmp = new EmptyTerm();
    // parse string
    // for each term found in string, create a temporary Term
    // Assign next to tmp for the next term found.

    return tmp;
  }

  @Override
  public String toString(){
    return "";
  }

  @Override
  public void addTerm(int coeff, int power) {

  }

  @Override
  public void removeTerm(int power) {

  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public double evaluate(double var) {
    return 0;
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    return null;
  }
}
