package q7_q8;

import java.util.Iterator;

public class IteratorMain {
  public static void main(String [] args) {
    TriangleSeries triangleSeries = new TriangleSeries(1, 13);
    Iterator<Integer> iterator = triangleSeries.iterator();
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
