/** Interface for the Polynomial. */
public interface Polynomial {

  /**
   * Return a string representation of the Polynomial.
   *
   * @return String representation.
   */
  public String toString();

  /**
   * Add a new term with the given coefficient and raised to the given power.
   *
   * @param coeff the coefficient for the term.
   * @param power the power for the term.
   */
  void addTerm(int coeff, int power) throws IllegalArgumentException;

  /**
   * Remove a term that is raised to the given power.
   *
   * @param power the the power of the term to remove.
   */
  void removeTerm(int power);

  /**
   * Get the degree of the polynomial by finding the largest power of all terms.
   *
   * @return the degree of the polynomial.
   */
  int getDegree();

  /**
   * Get the coefficient of the term that is raised to the given power.
   *
   * @param power the power to search terms for.
   * @return the coefficient of the term raised to the given power.
   */
  int getCoefficient(int power);

  /**
   * Calculate the numeric value of the polynomial for a given x.
   *
   * @param var the value to pass to "x".
   * @return the value of the polynomial at the given x.
   */
  double evaluate(double var);

  /**
   * Add two instances of Polynomial together.
   *
   * @param other the other Polynomial to add to this.
   * @return the resulting Polynomial object.
   * @throws IllegalArgumentException if the given object is not of class Polynomial.
   */
  Polynomial add(Polynomial other) throws IllegalArgumentException;
}
