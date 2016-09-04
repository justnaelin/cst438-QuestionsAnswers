package edu.csumb.cst438fa16.naelin;

import org.junit.Test;
import junit.framework.TestCase;

public class QuestionsAnswersTest extends TestCase {

	@Test
	public void testQuestionAndAnswer() {
		QuestionsAnswers qa = new QuestionsAnswers();
		qa.put("What is Pooh's full name?", "Winnie the Pooh");
		assertEquals("Winnie the Pooh", QuestionsAnswers.questions.get("What is Pooh's full name?"));
	}
	
	@Test
	public void testTestAnswer() {
		QuestionsAnswers qa = new QuestionsAnswers();
		qa.put("What is my last name?", "Aquino");
		assertTrue(qa.testAnswer("What is my last name?", "Aquino"));
	}
	
	@Test
	public void testRandomQuestion() {
		QuestionsAnswers qa = new QuestionsAnswers();
		qa.put("What is Pooh's full name?", "Winnie the Pooh");
		qa.put("What is my last name?", "Aquino");

		assertNotNull(qa.getRandomQuestion());

	}

}
