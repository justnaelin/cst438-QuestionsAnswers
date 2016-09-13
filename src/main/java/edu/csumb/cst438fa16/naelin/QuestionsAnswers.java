/*
 * Author: Naelin Aquino
 * CST438: Software Engineering
 * Date: Sep 3 2016
 */

package edu.csumb.cst438fa16.naelin;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class QuestionsAnswers {
	private Map<String, String> questions = new HashMap<String, String>();

	public Map<String, String> getQuestions() {
		return questions;
	}

	public QuestionsAnswers() {
		questions.put("What is my favourite colour right now?", "Orange");
		questions.put("What is my favourite show?", "Wentworth");
		questions.put("Answer this question with a Linux command: Who are you?", "whoami");
		questions.put("Who is the CST334 instructor?", "Soren Lassen");
		questions.put("What is the answer to life?", "42");
		questions.put("What is 1 + 1?", "2");

	}

	public void put(String question, String answer) {
		questions.put(question, answer);
	}

	public boolean testAnswer(String question, String answer) {
		return questions.get(question).equalsIgnoreCase(answer) ? true : false;
	}

	public String getRandomQuestion() {
		int limit = questions.size();

		Random rand = new Random();
		int randomQuestionIndex = rand.nextInt(limit);

		int i = 0;
		for (Map.Entry<String, String> questionSet : questions.entrySet()) {
			if (i == randomQuestionIndex)
				return questionSet.getKey();

			i++;
		}
		return null;
	}

	public static void main(String[] args) {
		return;
	}

}
