public interface Term {

  /** Getter method for a term's next field. */
  Term getNext();

  /**
   * Setter method to update a term's next field.
   *
   * @param t the term to be added to this' next field.
   */
  void setNext(Term t);

  /**
   * Getter method for a term's coefficient.
   *
   * @return the coefficient of the current term.
   */
  int getCoefficient();

  /**
   * Set the coefficient of a term to a new value.
   *
   * @param coeff the updated coefficient value.
   */
  void setCoefficient(int coeff);

  /**
   * Getter method for a term's power.
   *
   * @return the power of the current term.
   */
  int getPower();

  /**
   * Remove a term with a given power from the list.
   *
   * @param power the power to search for.
   */
  void removeTerm(int power);

  int findCoefficient(int power);

  double evaluate(double var, double acc);

  PolynomialImpl addHelp(PolynomialImpl acc);
}
