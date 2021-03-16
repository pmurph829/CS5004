package q10;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface GenericList<T> {
  GenericList<T> addToBack(T t);
  int count();

  GenericList<T> filter(Predicate<T> p);

  <R> GenericList<R> map(Function<T, R> transformer);

  T get(int i);

  <R> R fold(BiFunction<T, R, R> combiner, R seed);

  /**
   * Function that creates a sublist given a start and an end position.
   * Note: The end argument is allowed to be one greater than the last index of the list to account
   * for the case where the user wishes to include the last element in the sublist (ex: in a list
   * of 5 elements the end argument may be 5 even though the last element is index 4).
   * @param start the index of the first element of the sublist.
   * @param end the index of the last element of the sublist (this element is not included).
   * @return the sublist.
   * @throws IllegalArgumentException if end is less than start, or end or start are negative.
   */
  GenericList<T> subList(int start, int end);

  /**
   * Helper function for the subList method.
   *
   * @param start the index of the first element of the sublist.
   * @param end the index of the last element of the sublist (this element is not included).
   * @param acc counts the index of the main list.
   * @param newList the growing sublist.
   * @return the completed sublist.
   * @throws IllegalArgumentException if start or end are out of bounds of the list.
   */
  GenericList<T> sublistHelp(int start, int end, int acc, GenericList<T> newList);
}