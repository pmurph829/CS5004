/** Node that holds a word. Used in SentenceADT. */
public class WordNode extends AbstractNode {
  /**
   * Constructor for a WordNode.
   *
   * @param data The word that is stored in the node.
   */
  public WordNode(String data) {
    this.type = NodeType.WORD;
    this.data = data;
  }
}
