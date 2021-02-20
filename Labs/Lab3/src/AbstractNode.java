/** Abstract class the WordNode, PunctuationNode, and EmptyNode can extend. */
public abstract class AbstractNode implements Sentence {
  protected NodeType type;
  protected String data;
  protected Sentence rest;

  @Override
  public String toString() {
    if (this.type == NodeType.WORD) {
      return " " + this.data + this.rest.toString();
    } else if (this.type == NodeType.PUNCTUATION) {
      return this.data + this.rest.toString();
    } else if (this.type == NodeType.EMPTY) {
      return this.data;
    }
    return null;
  }

  @Override
  public Sentence getRest() {
    return this.rest;
  }

  @Override
  public void setRest(Sentence newRest) {
    this.rest = newRest;
  }

  @Override
  public NodeType getType() {
    return this.type;
  }

  @Override
  public int getNumberOfWords() {
    return countHelp(0);
  }

  @Override
  public int countHelp(int acc) {
    if (this.type == NodeType.WORD) {
      return this.rest.countHelp(1 + acc);
    } else if (this.type == NodeType.PUNCTUATION) {
      return this.rest.countHelp(acc);
    } else if (this.type == NodeType.EMPTY) {
      return acc;
    }
    return acc;
  }

  @Override
  public String longestWord() {
    return longestWordHelp("", 0);
  }

  @Override
  public String longestWordHelp(String longest, int length) {

    if (this.type == NodeType.WORD) {
      if (length <= this.data.length()) {
        longest = this.data;
        length = this.data.length();
      }
      return this.rest.longestWordHelp(longest, length);
    } else if (this.type == NodeType.PUNCTUATION) {
      return this.rest.longestWordHelp(longest, length);
    } else if (this.type == NodeType.EMPTY) {
      return longest;
    }
    return longest;
  }

  @Override
  public Sentence clone() {
    if (this.type == NodeType.WORD) {
      return new WordNode(this.data, this.rest);
    } else if (this.type == NodeType.PUNCTUATION) {
      return new PunctuationNode(this.data, this.rest);
    } else if (this.type == NodeType.EMPTY) {
      return new EmptyNode();
    }
    return null;
  }

  @Override
  public Sentence merge(Sentence other) {
    Sentence temp;
    temp = getLast(this);
    temp.setRest(other);
    return this;
  }

  @Override
  public Sentence getLast(Sentence iter) {
    if (iter.getRest().getType() == NodeType.EMPTY) {
      return iter;
    }
    return getLast(iter.getRest());
  }
}
