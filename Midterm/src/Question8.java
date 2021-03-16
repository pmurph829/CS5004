import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Question8 {
  public static void main(String[] args){
    Predicate<Integer> p = integer -> integer != 0;
    List<Integer> integerList = Arrays.asList(1, 2, -4, 0, 2, 0, -1, 14, 0, -1);
    List<Integer> result = integerList.stream()
            .filter(p)
            .collect(Collectors.toList());
    for (Integer i : result){
      System.out.println(i);
    }
  }
}
