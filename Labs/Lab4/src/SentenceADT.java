import java.util.ArrayList;
import java.util.function.Predicate;

/** A sentence of word nodes, punctuation nodes, and empty node. Empty node marks the end. */
public interface SentenceADT {

  /**
   * Return a string representation of a sentence.
   *
   * @return string representation.
   */
  String toString();

  /**
   * Add a new node to the list given a node type and the data it contains.
   *
   * @param type the type of node to add
   * @param data the data that will be held in the node.
   */
  void addNode(NodeType type, String data);

  /**
   * Return the list contained in a word list.
   *
   * @return
   */
  ArrayList<Node> getList();

  /**
   * Find the number of words in a sentence.
   *
   * @return number of words.
   */
  int getNumberOfWords();

  /**
   * Find the longest word in a sentence.
   *
   * @return the longest word.
   */
  String longestWord();

  /**
   * Create a clone of the sentence.
   *
   * @return identical sentence.
   */
  SentenceADT clone();

  /**
   * Merge two sentences.
   *
   * @param other the sentence to be merged.
   * @return the newly merged sentence.
   */
  SentenceADT merge(SentenceADT other);

  /**
   * Filter out all elements of a list that do not match a given predicate function.
   *
   * @param p predicate function to test each node on.
   * @return the filtered list.
   */
  SentenceADT filter(Predicate<Node> p);

  /**
   * Count the number of elements in a list that match a given predicate.
   *
   * @param p the predicate used for the count.
   * @return the number of elements that matched the predicate.
   */
  int countPredicate(Predicate<Node> p);

  /**
   * Translate all words in a list to pig latin.
   *
   * @return the translated list.
   */
  SentenceADT translatePigLatin();
}
