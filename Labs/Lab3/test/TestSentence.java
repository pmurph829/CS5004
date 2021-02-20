import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Tests for the Sentence class. */
public class TestSentence {
  Sentence sentence1;
  Sentence emptyS;

  @Before
  public void setUp() {
    Sentence tmp;
    emptyS = new EmptyNode();

    tmp = new PunctuationNode("!", emptyS);
    tmp = new WordNode("dog", tmp);
    tmp = new WordNode("lazy", tmp);
    tmp = new WordNode("the", tmp);
    tmp = new WordNode("over", tmp);
    tmp = new WordNode("jumped", tmp);
    tmp = new PunctuationNode(".", tmp);
    tmp = new PunctuationNode(".", tmp);
    tmp = new PunctuationNode(".", tmp);
    tmp = new WordNode("fox", tmp);
    tmp = new WordNode("brown", tmp);
    tmp = new WordNode("quick", tmp);
    tmp = new WordNode("The", tmp);
    sentence1 = tmp;
  }

  @Test
  public void testToStiring() {
    assertEquals(" The quick brown fox... jumped over the lazy dog!", sentence1.toString());
  }

  @Test
  public void testGetNumberOfWords() {
    assertEquals(9, sentence1.getNumberOfWords());
    assertEquals(0, emptyS.getNumberOfWords());
  }

  @Test
  public void testLongestWord() {
    assertEquals("jumped", sentence1.longestWord());
    assertEquals("", emptyS.longestWord());
  }

  @Test
  public void testClone() {
    Sentence sentence2 = sentence1.clone();
    assertEquals(9, sentence2.getNumberOfWords());
    assertEquals(" The quick brown fox... jumped over the lazy dog!", sentence2.toString());
  }

  @Test
  public void testMerge() {
    Sentence sentence3;
    Sentence sentence4;
    Sentence sentence5;
    Sentence tmp;
    tmp = new WordNode("fox", new EmptyNode());
    tmp = new WordNode("brown", tmp);
    tmp = new WordNode("quick", tmp);
    tmp = new WordNode("The", tmp);
    sentence3 = tmp;

    tmp = new WordNode("dog", new EmptyNode());
    tmp = new WordNode("the", tmp);
    tmp = new WordNode("over", tmp);
    tmp = new WordNode("jumped", tmp);
    sentence4 = tmp;

    sentence5 = sentence3.merge(sentence4);
    assertEquals(" The quick brown fox jumped over the dog", sentence5.toString());
  }
}
