package q10;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ElementNode<T> implements GenericList<T> {
  private T t;
  private GenericList<T> rest;

  ElementNode(T t, GenericList<T> rest) {
    this.t = t;
    this.rest = rest;
  }

  @Override
  public String toString(){
    return t.toString() + " " + this.rest.toString();
  }

  @Override
  public GenericList<T> addToBack(T t) {
    return new ElementNode<T>(this.t, rest.addToBack(t));
  }

  @Override
  public int count() {
    return 1 + rest.count();
  }

  @Override
  public GenericList<T> filter(Predicate<T> p) {
    return null;
  }

  @Override
  public <R> GenericList<R> map(Function<T, R> transformer) {
    return new ElementNode<R>(transformer.apply(t), rest.map(transformer));
  }

  @Override
  public T get(int i) {
    if (i == 0) {
      return t;
    } else {
      return rest.get(i - 1);
    }
  }

  @Override
  public <R> R fold(BiFunction<T, R, R> combiner, R seed) {
    //return combiner.apply(this.t, rest.fold(combiner, seed));
    return rest.fold(combiner, combiner.apply(this.t, seed));
  }

  @Override
  public GenericList<T> subList(int start, int end) {
    // Exception Handling:
    // End is less than start
    if (end < start){
      throw new IllegalArgumentException("End cannot be less than start");
    }
    // Start or end negative
    if (start < 0 || end <0){
      throw new IllegalArgumentException("Start / end cannot be negative");
    }
    // Start and end are equal (return empty)
    GenericList<T> newList = new EmptyNode<>();
    if (start == end){
      return newList;
    }
    return sublistHelp(start, end, 0, newList);
  }

  @Override
  public GenericList<T> sublistHelp(int start, int end, int acc, GenericList<T> newList) {
    if (acc == end){
      return newList;
    } else if (acc >= start){
      newList = newList.addToBack(this.t);
    }
    acc++;
    return this.rest.sublistHelp(start, end, acc, newList);
  }

}