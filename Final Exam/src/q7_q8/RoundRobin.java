package q7_q8;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that iterates over a list of iterators and returns the items in those iterators in a
 * "Round Robin" style.
 * @param <T> the type of data contained within the iterators.
 */
public class RoundRobin<T> implements Iterable<T> {
  private ArrayList<Iterator<T>> collectionOfIterators;
  private int index = 0;

  /**
   * Constructor for a RoundRobin object.
   * @param collectionOfIterators The list of iterators the RoundRobin object will traverse over.
   */
  public RoundRobin(ArrayList<Iterator<T>> collectionOfIterators) {
    this.collectionOfIterators = collectionOfIterators;
  }

  /**
   * Create the RoundRobin iterator.
   * @return Iterator containing sublists.
   */
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      @Override
      public boolean hasNext() {
        for (Iterator<T> subList : collectionOfIterators) {
          if (subList.hasNext()) {
            return true;
          }
        }
        return false;
      }

      @Override
      public T next() {
        Iterator<T> subList = collectionOfIterators.get(index);

        // increment our index and circle back to 0 when the last item is reached
        index = (index + 1) % collectionOfIterators.size();

        if (!subList.hasNext()) {
          return this.next();
        }
        return subList.next();
      }
    };
  }

  public static void main(String [] args) {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Wanda Bids: ");
    names.add("Vision Bids: ");
    names.add("Quicksilver Bids: ");
    names.add("Captain Marvel Bids: ");

    TriangleSeries ts = new TriangleSeries(2,6);
    Iterator<Integer> tsi = ts.iterator();
    ArrayList<String> bids = new ArrayList<>();
    while(tsi.hasNext()) {
      bids.add("$ " + Integer.toString(tsi.next()));
    }

    ArrayList<String> winner = new ArrayList<String>();
    winner.add("Wanda has winning bid");
    winner.add("Vision has winning bid");
    winner.add("Quicksilver has winning bid");
    winner.add("Captain Marvel has winning bid");
    winner.add("What about Thanos?");
    winner.add("I SAID: What about Thanos???");

    ArrayList<Iterator<String>> it = new ArrayList<>();
    it.add(names.iterator());
    it.add(bids.iterator());
    it.add(winner.iterator());

    RoundRobin robin = new RoundRobin(it);
    Iterator<String> roundRobinIterator = robin.iterator();
    while(roundRobinIterator.hasNext()) {
      System.out.println(roundRobinIterator.next());
    }
  }
}
