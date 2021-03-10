package cs5004.questionnaire;

import java.util.function.Predicate;

/** A question that is answered on a fixed, 5 point likert scale. */
public class Likert extends AbstractQuestion {

  /**
   * Constructor for a Likert (Question) object.
   *
   * @param prompt the question prompt.
   * @param required true if the question is required.
   */
  public Likert(String prompt, boolean required) {
    this.prompt = prompt;
    this.required = required;
  }

  /**
   * Predicate that checks if a string matches one of the values of the LikertResponseOption enum.
   */
  private final Predicate<String> p = s -> {
    for (LikertResponseOption v : LikertResponseOption.values()) {
      if (s.equalsIgnoreCase(v.getText())){
        return true;
      }
    }
    return false;
  };

  @Override
  public void answer(String ans) {
    this.answerHelp(p, ans);
  }

  @Override
  public Question copy() {
    Question q = new Likert(this.prompt, this.required);
    return copyHelp(q);
  }
}
