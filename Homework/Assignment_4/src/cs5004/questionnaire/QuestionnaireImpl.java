package cs5004.questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/** Questionnaire implementing class. */
public class QuestionnaireImpl implements Questionnaire {
  private List<String> idList; // Contains the identifiers for each Question in order
  private HashMap<String, Question> qHashMap; // Contains id:Question pairs

  /** Constructor for the QuestionnaireImpl class. */
  public QuestionnaireImpl() {
    this.idList = new ArrayList<>();
    this.qHashMap = new HashMap<>();
  }

  /**
   * Create a string representation of a Questionnaire.
   *
   * @return string representation.
   */
  public String toString() {
    String s = "";
    for (String id : idList) {
      Question q = qHashMap.get(id);
      s += q.toString();
    }
    return s.trim() + " ";
  }

  /**
   * Create a list of all question objects. Useful for filtering. Questions added to the list are
   * copies of the original question objects.
   *
   * @return a list of all questions in the questionnaire.
   */
  private List<Question> createQuestionList() {
    List<Question> questionList = new ArrayList<>();
    for (String id : idList) {
      Question q = qHashMap.get(id);
      questionList.add(q.copy());
    }
    return questionList;
  }

  @Override
  public void addQuestion(String identifier, Question q) {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException(String.format("Identifier cannot be empty."));
    }
    if (idList.contains(identifier)) {
      throw new IllegalArgumentException(
          String.format("Identifier already exists: %s.", identifier));
    }
    idList.add(identifier);
    qHashMap.put(identifier, q);
  }

  @Override
  public void removeQuestion(String identifier) {
    if (!idList.contains(identifier)) {
      throw new IndexOutOfBoundsException(
          String.format("Could not find question identifier: %s.", identifier));
    }
    idList.remove(identifier);
    qHashMap.remove(identifier);
  }

  @Override
  public Question getQuestion(int num) {
    if (num > idList.size()) {
      throw new IndexOutOfBoundsException(String.format("Could not find question %d!", num));
    }
    return qHashMap.get(idList.get(num - 1));
  }

  @Override
  public Question getQuestion(String identifier) {
    if (!idList.contains(identifier)) {
      throw new NoSuchElementException(
          String.format("Could not find question identifier: %s.", identifier));
    }
    return qHashMap.get(identifier);
  }

  @Override
  public List<Question> getRequiredQuestions() {
    Predicate<Question> p = question -> question.isRequired();
    List<Question> allQs = this.createQuestionList();
    List<Question> requiredQs = allQs.stream().filter(p).collect(Collectors.toList());
    return requiredQs;
  }

  @Override
  public List<Question> getOptionalQuestions() {
    Predicate<Question> p = question -> !question.isRequired();
    List<Question> allQs = this.createQuestionList();
    List<Question> optionalQs = allQs.stream().filter(p).collect(Collectors.toList());
    return optionalQs;
  }

  @Override
  public boolean isComplete() {
    List<Question> requiredQs = this.getRequiredQuestions();
    if (requiredQs.size() == 0) {
      return true;
    }
    for (Question q : requiredQs) {
      if (q.getAnswer().equals("")) {
        return false;
      }
    }
    return true;
  }

  @Override
  public List<String> getResponses() {
    List<String> responses = new ArrayList<>();
    List<Question> allQs = this.createQuestionList();
    for (Question q : allQs) {
      responses.add(q.getAnswer());
    }
    return responses;
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) {
    Questionnaire filteredQuestionnaire = new QuestionnaireImpl();

    for (String id : this.idList) {
      Question q = this.qHashMap.get(id);
      if (pq.test(q)) {
        filteredQuestionnaire.addQuestion(id, q.copy());
      }
    }
    return filteredQuestionnaire;
  }

  @Override
  public void sort(Comparator<Question> comp) {
    List<Question> allQs = this.createQuestionList();
    List<Question> sortedQs = allQs.stream().sorted(comp).collect(Collectors.toList());
    List<String> sortedIds = new ArrayList<>();
    for (Question q : sortedQs) {
      for (String id : this.idList) {
        if (this.qHashMap.get(id).equals(q)) {
          sortedIds.add(id);
        }
      }
    }
    this.idList = sortedIds;
  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) {
    R acc = seed;
    List<Question> allQs = this.createQuestionList();
    for (Question q : allQs) {
      acc = bf.apply(q, acc);
    }
    return acc;
  }
}
