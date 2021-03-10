import org.junit.Before;
import org.junit.Test;

import cs5004.questionnaire.Likert;
import cs5004.questionnaire.Question;
import cs5004.questionnaire.Questionnaire;
import cs5004.questionnaire.QuestionnaireImpl;
import cs5004.questionnaire.ShortAnswer;
import cs5004.questionnaire.YesNo;

import static org.junit.Assert.assertEquals;

/** tests for the Questionnaire class. */
public class QuestionnaireTest {

  Questionnaire questionnaire1;
  Questionnaire questionnaire2;
  Questionnaire questionnaire3;
  String baseToString;
  Question qC;

  /**
   * Set up QuestionnaireImpl objects.
   */
  @Before
  public void setUp(){
    questionnaire1 = new QuestionnaireImpl();
    questionnaire2 = new QuestionnaireImpl();
    questionnaire3 = new QuestionnaireImpl();
    questionnaire2.addQuestion("Monday", new YesNo("Is today Monday?",
            true));

    Question qA = new ShortAnswer("What is your name?", true);
    qA.answer("Peter");
    Question qB = new YesNo("Do you seek the Holy Grail?", true);
    qB.answer("Yes");
    qC = new Likert("How do you feel about the following: 'Blue is a nice color'?",
            false);
    qC.answer("Agree");
    questionnaire3.addQuestion("name", qA);
    questionnaire3.addQuestion("quest", qB);
    questionnaire3.addQuestion("color", qC);
    baseToString = "Question: What is your name?\n" +
            "\n" +
            "Answer: Peter\n" +
            "\n" +
            "Question: Do you seek the Holy Grail?\n" +
            "\n" +
            "Answer: Yes\n" +
            "\n" +
            "Question: How do you feel about the following: 'Blue is a nice color'?\n" +
            "\n" +
            "Answer: Agree\n\n";
  }

  /**
   * Test the toString method.
   */
  @Test
  public void test_toString(){
    assertEquals(baseToString, questionnaire3.toString());
  }

  /**
   * test the addQuestion method with valid input.
   */
  @Test
  public void test_addQuestion(){
    Question q1 = new ShortAnswer("What is your name?", true);
    q1.answer("Peter");
    Question q2 = new YesNo("Do you seek the Holy Grail?", true);
    q2.answer("Yes");
    Question q3 = new Likert("How do you feel about the following: 'Blue is a nice color'?",
            false);
    q3.answer("Agree");
    questionnaire1.addQuestion("name", q1);
    questionnaire1.addQuestion("quest", q2);
    questionnaire1.addQuestion("color", q3);

    assertEquals(baseToString, questionnaire1.toString());
  }

  /**
   * Test the addQuestion method with invalid input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test_addQuestionInvalid(){
    Question q = new YesNo("Was yesterday Monday?", false);
    questionnaire2.addQuestion("Monday", q);
  }

  /**
   * test the remove question method with valid input.
   */
  @Test
  public void test_removeQuestion(){
    questionnaire3.removeQuestion("color");
    assertEquals(
        "Question: What is your name?\n"
            + "\n"
            + "Answer: Peter\n"
            + "\n"
            + "Question: Do you seek the Holy Grail?\n"
            + "\n"
            + "Answer: Yes\n"
            + "\n", questionnaire3.toString());
    questionnaire3.addQuestion("color", qC);
  }

  /**
   * Test the removeQuestion method with invalid input.
   */
  @Test (expected = IllegalArgumentException.class)
  public void test_removeQuestionInvalid(){
    questionnaire3.removeQuestion("capitalOfAssyria");
  }

  /**
   * Test the getQuestion method with valid input.
   */
  @Test
  public void test_getQuestion(){
    assertEquals("Question: Do you seek the Holy Grail?\n"
            + "\n"
            + "Answer: Yes\n"
            + "\n", questionnaire3.getQuestion("quest").toString());

    assertEquals("Question: Do you seek the Holy Grail?\n"
            + "\n"
            + "Answer: Yes\n"
            + "\n", questionnaire3.getQuestion(2).toString());
  }

  /**
   * Test the getQuestion method (id) with invalid input.
   */
  @Test (expected = IllegalArgumentException.class)
  public void test_getQuestionInvalid1(){
    questionnaire3.getQuestion("capitalOfAssyria");
  }

  /**
   * Test the getQuestion method (num) with invalid input.
   */
  @Test (expected = IllegalArgumentException.class)
  public void test_getQuestionInvalid2(){
    questionnaire3.getQuestion(4);
  }


}
