package q10;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmptyNode<T> implements GenericList<T> {

  @Override
  public String toString(){
    return "";
  }

  @Override
  public GenericList<T> addToBack(T t) {
    return new ElementNode<>(t, this);
  }

  @Override
  public int count() {
    return 0;
  }

  @Override
  public GenericList<T> filter(Predicate<T> p) {
    return this;
  }

  @Override
  public <R> GenericList<R> map(Function<T, R> transformer) {
    return new EmptyNode<R>();
  }

  @Override
  public T get(int i) {
    throw new IndexOutOfBoundsException("No such element");
  }

  @Override
  public <R> R fold(BiFunction<T, R, R> combiner, R seed) {
    return seed;
  }

  @Override
  public GenericList<T> subList(int start, int end) {
    return null;
  }

  @Override
  public GenericList<T> sublistHelp(int start, int end, int acc, GenericList<T> newList) {
    // Case: start is outside list
    if (acc < start){
      throw new IllegalArgumentException("Start is outside of list range");
    }
    // Case: end is outside list
    if (acc < end){
      throw new IllegalArgumentException("End is outside of list range");
    }
    return newList;
  }
}