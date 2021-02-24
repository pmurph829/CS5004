import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the SentenceADT.
 */
public class TestSentenceADT {
  SentenceADT s1 = new WordList();
  SentenceADT s2 = new WordList();
  SentenceADT s3 = new WordList();
  SentenceADT pig = new WordList();

  @Before
  /**
   * Set up some sentences.
   */
  public void setUp(){
    s1.addNode(NodeType.WORD, "Hello");
    s1.addNode(NodeType.PUNCTUATION, ",");
    s1.addNode(NodeType.WORD, "how");
    s1.addNode(NodeType.WORD, "are");
    s1.addNode(NodeType.WORD, "you");
    s1.addNode(NodeType.PUNCTUATION, "?");

    s2.addNode(NodeType.WORD,"I'm");
    s2.addNode(NodeType.WORD, "doing");
    s2.addNode(NodeType.WORD, "great");
    s2.addNode(NodeType.PUNCTUATION, ",");
    s2.addNode(NodeType.WORD, "thanks");
    s2.addNode(NodeType.PUNCTUATION, "!");

    s3.addNode(NodeType.WORD, "Zebras");
    s3.addNode(NodeType.WORD, "zoom");
    s3.addNode(NodeType.WORD, "in");
    s3.addNode(NodeType.WORD, "the");
    s3.addNode(NodeType.WORD, "zoo");
    s3.addNode(NodeType.PUNCTUATION, ".");

    pig.addNode(NodeType.WORD, "Making");
    pig.addNode(NodeType.WORD, "a");
    pig.addNode(NodeType.WORD, "pig");
    pig.addNode(NodeType.WORD, "deal");
    pig.addNode(NodeType.WORD, "about");
    pig.addNode(NodeType.WORD, "pig");
    pig.addNode(NodeType.WORD, "latin");
    pig.addNode(NodeType.PUNCTUATION, "!");
  }

  @Test
  /**
   * Tests for the toString method.
   */
  public void test_toString(){
    assertEquals("Hello, how are you?", s1.toString());
    assertEquals("I'm doing great, thanks!", s2.toString());
  }

  @Test
  /**
   * Tests for the getNumberOfWords method.
   */
  public void test_getNumberOfWords(){
    assertEquals(4, s1.getNumberOfWords());
    assertEquals(4, s2.getNumberOfWords());
  }

  @Test
  /**
   * Tests for the longestWord method
   */
  public void test_longestWord(){
    assertEquals("Hello", s1.longestWord());
    assertEquals("thanks", s2.longestWord());
  }

  @Test
  /**
   * Tests for the clone method.
   */
  public void test_clone(){
    SentenceADT s1Clone = s1.clone();
    SentenceADT s2Clone = s2.clone();

    assertEquals("Hello, how are you?", s1Clone.toString());
    assertEquals("I'm doing great, thanks!", s2Clone.toString());
  }

  @Test
  /**
   * Tests for the merge method.
   */
  public void test_merge(){
    SentenceADT s1S2 = s1.merge(s2);
    String s = "Hello, how are you? I'm doing great, thanks!";
    assertEquals(8, s1S2.getNumberOfWords());
    assertEquals(s, s1S2.toString());
  }

  @Test
  /**
   * Tests for the countPredicate method.
   */
  public void test_countPredicate(){
    Predicate<Node> p1 = n -> n.getType() == NodeType.PUNCTUATION;
    Predicate<Node> p2 = n -> n.toString().contains("z") || n.toString().contains("Z");
    assertEquals(2, s1.countPredicate(p1));
    assertEquals(2, s2.countPredicate(p1));
    assertEquals(0, s1.countPredicate(p2));
    assertEquals(0, s2.countPredicate(p2));
    assertEquals(3, s3.countPredicate(p2));
  }

  @Test
  /**
   * Tests for the translatePigLatin method.
   */
  public void test_translatePigLatin(){
    String translated = "akingmay away igpay ealday aboutway igpay atinlay!";
    assertEquals(translated, pig.translatePigLatin().toString());
  }


}
