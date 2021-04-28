package q7_q8;

/**
 * Interface for an iterator that is capable of iterating over an iterable of an abstract type.
 * @param <E> the type of data contained in the iterable.
 */
interface Iterator<E> {
  /**
   * Determine if the iterable has another value for next.
   * @return true if there is a next value, false otherwise.
   */
  boolean hasNext();

  /**
   * Return the next item in the iterable.
   * @return the next element.
   */
  E next();
}
