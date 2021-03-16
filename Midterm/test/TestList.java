import org.junit.Before;
import org.junit.Test;

import q10.EmptyNode;
import q10.GenericList;

import static org.junit.Assert.assertEquals;

public class TestList {
  GenericList<Integer> tmp;

  @Before
  public void setUp(){
    tmp = new EmptyNode<Integer>();
    tmp = tmp.addToBack(0);
    tmp = tmp.addToBack(1);
    tmp = tmp.addToBack(2);
    tmp = tmp.addToBack(3);
    tmp = tmp.addToBack(4);
  }

  @Test
  public void test_toString(){
    String expect = "0 1 2 3 4 ";
    System.out.println(tmp.toString());
    assertEquals(expect, tmp.toString());
  }

  @Test
  public void test_subList(){
    GenericList<Integer> newL1= tmp.subList(-1, 1);
    System.out.println(newL1.toString());
  }
}
