/** An empty node that holds no data. */
public class EmptyNode extends AbstractNode {

  /** Create an instance of empty node. */
  public EmptyNode() {
    this.type = NodeType.EMPTY;
    this.data = "";
    this.rest = null;
  }
}
