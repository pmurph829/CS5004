package cs5004.questionnaire;

import java.util.function.Predicate;

/** Implementation of shared methods for Question interface. */
public abstract class AbstractQuestion implements Question {
  protected String prompt;
  protected boolean required;
  protected String userAnswer = "";

  /**
   * Override the equals method. Note that two question objects are the same if they have the same
   * prompt and required status. User answer is not taken into account.
   * @param obj The other Question to test for equality.
   * @return true if the two Question objects are equal.
   */
  @Override
  public boolean equals(Object obj){
    if (this == obj){
      return true;
    }
    if (! (obj instanceof Question)){
      return false;
    }
    Question otherQ = (Question) obj;
    return this.prompt == otherQ.getPrompt()
            && this.required == otherQ.isRequired();
  }

  @Override
  public String toString(){
    return String.format("Question: %s\n\nAnswer: %s\n\n", this.prompt, this.userAnswer);
  }

  @Override
  public String getPrompt() {
    return this.prompt;
  }

  @Override
  public boolean isRequired() {
    return this.required;
  }

  @Override
  public String getAnswer() {
    return this.userAnswer;
  }

  /**
   * Test if the answer supplied to the answer method is valid. Uses a predicate (defined in
   * each child class) to test if the answer is valid. If so, updates this.userAnswer.
   * @param p the predicate that tests if the answer is valid.
   * @param ans the answer that was passed to the answer method.
   * @throws IllegalArgumentException If the answer is invalid.
   */
  protected void answerHelp(Predicate<String> p, String ans) throws IllegalArgumentException{
    if (p.test(ans)) {
      this.userAnswer = ans;
    } else {
      throw new IllegalArgumentException("The given answer is invalid.");
    }
  }

  /**
   * Helper function for the copy method. Copies over the user answer if there is one.
   * @param q the copied Question object.
   * @return the copied Question.
   */
  protected Question copyHelp(Question q){
    if (this.userAnswer != "") {
      q.answer(this.userAnswer);
    }
    return q;
  }

}
