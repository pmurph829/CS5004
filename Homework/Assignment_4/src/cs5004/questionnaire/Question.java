package cs5004.questionnaire;

/** Interface that declares functions that all Question subtypes share. */
public interface Question {

  /**
   * Return the prompt for the question.
   *
   * @return the prompt.
   */
  String getPrompt();

  /**
   * Tells if the current Question is required to be answered or not.
   *
   * @return true if the Question is required.
   */
  boolean isRequired();

  /**
   * Take an answer from the user. The allowed answer differs depending on the question type.
   *
   * @param ans the answer that the user passes.
   */
  void answer(String ans);

  /**
   * Get the answer to the question. If the question has not been answered, return an empty string.
   *
   * @return The answer that was supplied in the answer() method
   */
  String getAnswer();

  /**
   * Return a copy of the Question object
   *
   * @return the copied object.
   */
  Question copy();
}
