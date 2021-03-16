import java.util.Comparator;
public class BoxerComparator implements Comparator<Boxer> {
  @Override
  public int compare(Boxer o1, Boxer o2) {
    // subtract weight and cast to int to match return type.
    return (int) (o1.getWeight() - o2.getWeight());
  }
}
