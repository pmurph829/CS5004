/** Node that hods punctuation information. */
public class PunctuationNode extends AbstractNode {

  /**
   * Create an instance of punctuation node.
   *
   * @param data the punctuation data to pass the node.
   * @param rest the rest of the Sentence.
   */
  public PunctuationNode(String data, Sentence rest) {
    this.type = NodeType.PUNCTUATION;
    this.data = data;
    this.rest = rest;
  }
}
