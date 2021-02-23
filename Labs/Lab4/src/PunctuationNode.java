public class PunctuationNode extends AbstractNode{
  public PunctuationNode(String data){
    if (data.length() > 1){
      throw new IllegalArgumentException("Punctuation Nodes must be only one character long.");
    }
    this.type = NodeType.PUNCTUATION;
    this.data = data;
  }
}
