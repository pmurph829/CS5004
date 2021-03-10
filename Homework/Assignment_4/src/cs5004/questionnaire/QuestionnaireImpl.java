package cs5004.questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class QuestionnaireImpl implements Questionnaire{
  private List<String> idList; // Contains the identifiers for each Question in order
  private HashMap<String, Question> qHashMap; // Contains id:Question pairs

  public QuestionnaireImpl(){
    this.idList = new ArrayList<>();
    this.qHashMap = new HashMap<>();
  }
  /**
   * Create a string representation of a Questionnaire.
   * @return string representation.
   */
  public String toString(){
    String s = "";
    for (String id : idList){
      Question q = qHashMap.get(id);
      s += q.toString();
    }
    return s;
  }

  @Override
  public void addQuestion(String identifier, Question q) {
    if (idList.contains(identifier)) {
      throw new IllegalArgumentException(String.format("Identifier already exists: %s.",identifier));
    }
    idList.add(identifier);
    qHashMap.put(identifier, q);
  }

  @Override
  public void removeQuestion(String identifier) {
    if (! idList.contains(identifier)){
      throw new IllegalArgumentException(String.format(
              "Could not find question identifier: %s.", identifier));
    }
    idList.remove(identifier);
    qHashMap.remove(identifier);
  }

  @Override
  public Question getQuestion(int num) {
    if (num > idList.size()){
      throw new IllegalArgumentException(String.format("Could not find question %d.", num));
    }
    return qHashMap.get(idList.get(num-1));
  }

  @Override
  public Question getQuestion(String identifier) {
    if (! idList.contains(identifier)){
      throw new IllegalArgumentException(String.format(
              "Could not find question identifier: %s.", identifier));
    }
    return qHashMap.get(identifier);
  }

  @Override
  public List<Question> getRequiredQuestions() {
    return null;
  }

  @Override
  public List<Question> getOptionalQuestions() {
    return null;
  }

  @Override
  public boolean isComplete() {
    return false;
  }

  @Override
  public List<String> getResponses() {
    return null;
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) {
    return null;
  }

  @Override
  public void sort(Comparator<Question> comp) {

  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) {
    return null;
  }
}
