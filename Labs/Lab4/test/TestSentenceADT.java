import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSentenceADT {
  SentenceADT s1 = new WordList();
  SentenceADT s2 = new WordList();

  @Before
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
  }

  @Test
  public void test_toString(){
    assertEquals("Hello, how are you?", s1.toString());
    assertEquals("I'm doing great, thanks!", s2.toString());
  }

  @Test
  public void test_getNumberOfWords(){
    assertEquals(4, s1.getNumberOfWords());
    assertEquals(4, s2.getNumberOfWords());
  }

  @Test
  public void test_longestWord(){
    assertEquals("Hello", s1.longestWord());
    assertEquals("thanks", s2.longestWord());
  }

  @Test
  public void test_clone(){
    SentenceADT s1Clone = s1.clone();
    SentenceADT s2Clone = s2.clone();

    assertEquals("Hello, how are you?", s1Clone.toString());
    assertEquals("I'm doing great, thanks!", s2Clone.toString());
  }

  @Test
  public void test_merge(){
    SentenceADT s1S2 = s1.merge(s2);
    String s = "Hello, how are you? I'm doing great, thanks!";
    assertEquals(8, s1S2.getNumberOfWords());
    assertEquals(s, s1S2.toString());
  }

  @Test
  public void test_countPunctuation(){
    assertEquals(2, s1.countPunctuation());
    assertEquals(2, s2.countPunctuation());
  }
}
