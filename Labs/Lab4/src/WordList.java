import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class WordList implements SentenceADT {
  protected ArrayList<Node> list;

  public WordList(){
    this.list = new ArrayList<Node>();
  }

  @Override
  public String toString(){
    String s = "";
    for (Node n : this.list){
      switch (n.getType()){
        case WORD:
          s += " " + n.toString();
          break;
        case PUNCTUATION:
          s += n.toString();
      }
    }
    return s.trim();
  }
  @Override
  public void addNode(NodeType type, String data){
    Node node = null;
    switch (type){
      case WORD:
        node = new WordNode(data);
        break;
      case PUNCTUATION:
        node = new PunctuationNode(data);
        break;
    }
    this.list.add(node);
  }

  @Override
  public ArrayList<Node> getList(){
    return this.list;
  }

  @Override
  public int getNumberOfWords() {
    int count = 0;
    for (Node n : this.list){
      if (n.getType()==NodeType.WORD){
        count++;
      }
    }
    return count;
  }

  @Override
  public String longestWord() {
    int longest = 0;
    Node longestWord = null;
    for (Node n : this.list){
      if (n.toString().length() > longest){
        longest = n.toString().length();
        longestWord = n;
      }
    }
    return longestWord.toString();
  }

  @Override
  public SentenceADT clone() {
    WordList newList = new WordList();
    for (Node n : this.list){
      newList.addNode(n.getType(), n.getData());
    }
    return newList;
  }

  @Override
  public SentenceADT merge(SentenceADT other) {
    SentenceADT thisClone = this.clone();
    for (Node n : other.getList()){
      thisClone.addNode(n.getType(), n.getData());
    }
    return thisClone;
  }

  @Override
  public SentenceADT filter(Predicate<Node> p) {
    SentenceADT newList = new WordList();
    for (Node n : this.clone().getList()){
      if (p.test(n)){
        newList.addNode(n.getType(), n.getData());
      }
    }
    return newList;
  }

  @Override
  public int countPredicate(Predicate<Node> p){
    SentenceADT filteredList = filter(p);
    return filteredList.getList().size();
  }

  @Override
  public SentenceADT translatePigLatin(){
    String[] v = {"a", "e", "i", "o", "u"};
    ArrayList<String> vowels = new ArrayList(Arrays.asList(v));
    String firstLetter;
    SentenceADT translatedList = new WordList();
    for (Node n : this.list){
      switch (n.getType()) {
        case WORD:
          firstLetter = String.valueOf(n.getData().charAt(0)).toLowerCase();
          if (vowels.contains(firstLetter)) {
            translatedList.addNode(NodeType.WORD, n.getData() + "way");
          } else {
            String newData = n.getData().substring(1) + firstLetter + "ay";
            translatedList.addNode(NodeType.WORD, newData);
          }
          break;
        case PUNCTUATION:
          translatedList.addNode(NodeType.PUNCTUATION, n.getData());
          break;
      }
    }
    return translatedList;
  }

}
