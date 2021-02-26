/** Node interface that defines methods shared by all Nodes. */
public interface Node {
  /**
   * Get the data stored in the current node.
   *
   * @return the word or punctuation data stored by the node.
   */
  String getData();

  /**
   * Get the type of node.
   *
   * @return the NodeType.
   */
  NodeType getType();
}
