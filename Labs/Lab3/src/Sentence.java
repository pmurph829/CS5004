/** A sentence of word nodes, punctuation nodes, and empty node. Empty node marks the end. */
public interface Sentence {
  /**
   * Return a string representation of a sentence.
   *
   * @return string representation.
   */
  String toString();

  /**
   * Find the number of words in a sentence.
   *
   * @return number of words.
   */
  int getNumberOfWords();

  /**
   * Helper function for count.
   *
   * @param acc the accumulated count.
   * @return the number of words counted.
   */
  int countHelp(int acc);

  /**
   * Return the type of the node.
   *
   * @return node type.
   */
  NodeType getType();

  /**
   * Get the rest of the sentence at the current node.
   *
   * @return rest of the sentence.
   */
  Sentence getRest();

  /**
   * Update the rest field with more data.
   *
   * @param newRest node(s) to be added.
   */
  void setRest(Sentence newRest);

  /**
   * Find the longest word in a sentence.
   *
   * @return the longest word.
   */
  String longestWord();

  /**
   * Helper function for the longest word.
   *
   * @param longest the longest word so far.
   * @param length the length of the longest word so far.
   * @return the longest word.
   */
  String longestWordHelp(String longest, int length);

  /**
   * Create a clone of the sentence.
   *
   * @return identical sentence.
   */
  Sentence clone();

  /**
   * Merge two sentences.
   *
   * @param other the sentence to be merged.
   * @return the newly merged sentence.
   */
  Sentence merge(Sentence other);

  /**
   * Helper method for the merge method.
   *
   * @param iter the first node in a list.
   * @return the last node before the empty node.
   */
  Sentence getLast(Sentence iter);
}
