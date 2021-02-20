/** A node that contains word information. */
public class WordNode extends AbstractNode {

  /**
   * Create a new instance of word node.
   *
   * @param word the word information to pass to the node.
   * @param rest the rest of the sentence.
   */
  public WordNode(String word, Sentence rest) {
    this.type = NodeType.WORD;
    this.data = word;
    this.rest = rest;
  }
}
