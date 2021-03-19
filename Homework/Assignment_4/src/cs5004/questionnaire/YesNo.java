package cs5004.questionnaire;

import java.util.function.Predicate;

/** A question that can only be answered with Yes or No. */
public class YesNo extends AbstractQuestion {

  /** Predicate that returns true if a String matches 'yes' or 'no' regardless of case. */
  private final Predicate<String> p = s -> s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("no");

  /**
   * Constructor for a YesNo (Question) object.
   *
   * @param prompt the question prompt.
   * @param required true if the question is required.
   */
  public YesNo(String prompt, boolean required) {
    this.prompt = prompt;
    this.required = required;
  }

  @Override
  public void answer(String ans) {
    this.answerHelp(p, ans);
  }

  @Override
  public Question copy() {
    Question q = new YesNo(this.prompt, this.required);
    return copyHelp(q);
  }
}
