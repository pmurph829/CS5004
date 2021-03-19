import org.junit.Before;
import org.junit.Test;

import cs5004.questionnaire.Likert;
import cs5004.questionnaire.Question;
import cs5004.questionnaire.ShortAnswer;
import cs5004.questionnaire.YesNo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Tests for the question class. */
public class QuestionTest {
  Question yesNo;
  Question shortAnswer;
  Question likeRt;

  /** Set up the Question tests. */
  @Before
  public void setUp() {
    yesNo = new YesNo("Is today Monday?", true);
    shortAnswer = new ShortAnswer("How is your day going?", true);
    likeRt = new Likert("I am having a great day.", false);
  }

  /** Test the getPrompt method. */
  @Test
  public void test_getPrompt() {
    assertEquals("Is today Monday?", yesNo.getPrompt());
    assertEquals("How is your day going?", shortAnswer.getPrompt());
    assertEquals("I am having a great day.", likeRt.getPrompt());
  }

  /** Test the isRequired method. */
  @Test
  public void test_isRequired() {
    assertTrue(yesNo.isRequired());
    assertTrue(shortAnswer.isRequired());
    assertFalse(likeRt.isRequired());
  }

  /** Test valid arguments to the Answer method for a YesNo object. */
  @Test
  public void test_answerYesNo() {
    yesNo.answer("YES");
    assertEquals("YES", yesNo.getAnswer());
    yesNo.answer("yes");
    assertEquals("yes", yesNo.getAnswer());
    yesNo.answer("Yes");
    assertEquals("Yes", yesNo.getAnswer());
    yesNo.answer("NO");
    assertEquals("NO", yesNo.getAnswer());
    yesNo.answer("no");
    assertEquals("no", yesNo.getAnswer());
    yesNo.answer("No");
    assertEquals("No", yesNo.getAnswer());
  }

  /** Test invalid argument to the answer method for a YesNo object. */
  @Test(expected = IllegalArgumentException.class)
  public void test_answerYesNoInvalid() {
    yesNo.answer("Maybe");
  }

  /** Test valid argument to the answer method for a ShortAnswer object. */
  @Test
  public void test_answerShortAnswer() {
    shortAnswer.answer("I am having a great day");
    assertEquals("I am having a great day", shortAnswer.getAnswer());
  }

  /** Test invalid argument to the answer method for a ShortAnswer object. */
  @Test(expected = IllegalArgumentException.class)
  public void test_answerShortAnswerInvalid() {
    String message =
        "Am I having a great day, you ask? Well, the answer depends entirely upon "
            + "the perspective from which the question is answered. I could say that I am having a "
            + "great day, which is probably the most socially acceptable option. However, to me "
            + "the word 'great' implies that I am having an above average day. I would consider "
            + "this day to be fairly average. But if I tell you that I am not having a great day, "
            + "you would probably ask if there is something wrong when in reality there is "
            + "absolutely nothing wrong, just that there is nothing particularly great about this "
            + "day. So, Ill keep it simple and say my answer to your question is "
            + "'I am having a great day'.";

    assertTrue(message.length() > 280);
    shortAnswer.answer(message);
  }

  /** test valid arguments to the answer method for Likert object. */
  @Test
  public void test_answerLikert() {
    likeRt.answer("STRONGLY DISAGREE");
    assertEquals("STRONGLY DISAGREE", likeRt.getAnswer());
    likeRt.answer("disagree");
    assertEquals("disagree", likeRt.getAnswer());
    likeRt.answer("Neither Agree Nor Disagree");
    assertEquals("Neither Agree Nor Disagree", likeRt.getAnswer());
    likeRt.answer("Agree");
    assertEquals("Agree", likeRt.getAnswer());
    likeRt.answer("STRONGLY agree");
    assertEquals("STRONGLY agree", likeRt.getAnswer());
  }

  /** Test invalid argument to the answer method for Likert object. */
  @Test(expected = IllegalArgumentException.class)
  public void test_answerLikertInvalid() {
    likeRt.answer("Agree Strongly");
  }

  /** Test the copy method for the YesNo class. */
  @Test
  public void test_copyYesNo() {
    Question q = yesNo.copy();
    assertEquals(yesNo, q);
    yesNo.answer("yes");
    q.answer("no");
    assertEquals("yes", yesNo.getAnswer());
    assertEquals("no", q.getAnswer());

    Question qCopy = q.copy();
    assertEquals("no", qCopy.getAnswer());
    assertEquals(yesNo, qCopy);
    assertEquals(yesNo, q);
  }

  /** Test the copy method for ShortAnswer class. */
  @Test
  public void test_copyShortAnswer() {
    Question q = shortAnswer.copy();
    assertEquals(shortAnswer, q);
    shortAnswer.answer("I am having a great day.");
    q.answer("I am not having a great day.");
    assertEquals("I am having a great day.", shortAnswer.getAnswer());
    assertEquals("I am not having a great day.", q.getAnswer());
    assertEquals(shortAnswer, q);
  }

  /** Test the copy method for Likert class. */
  @Test
  public void test_copyLikert() {
    Question q = likeRt.copy();
    assertEquals(q, likeRt);
    likeRt.answer("Strongly Agree");
    q.answer("Strongly Disagree");
    assertEquals("Strongly Agree", likeRt.getAnswer());
    assertEquals("Strongly Disagree", q.getAnswer());
    assertEquals(q, likeRt);
  }

  @Test
  public void test_copyNoAnswer() {
    Question noAns = new YesNo("Is it raining?", false);
    Question noAnsCopy = noAns.copy();
    assertEquals(noAns, noAnsCopy);
  }

  @Test
  public void test_toString() {
    yesNo.answer("Yes");
    shortAnswer.answer("I am having a great day.");
    likeRt.answer("Neither Agree Nor Disagree");

    assertEquals("Question: Is today Monday?\n\nAnswer: Yes\n\n", yesNo.toString());
    assertEquals(
        "Question: How is your day going?\n\n" + "Answer: I am having a great day.\n\n",
        shortAnswer.toString());
    assertEquals(
        "Question: I am having a great day.\n\n" + "Answer: Neither Agree Nor Disagree\n\n",
        likeRt.toString());
  }
}
