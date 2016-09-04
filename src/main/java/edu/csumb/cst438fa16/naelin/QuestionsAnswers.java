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
	static Map<String, String> questions = new HashMap<String, String>();

	public void put(String question, String answer) {
		questions.put(question, answer);
	}

	public boolean testAnswer(String question, String answer) {
		return questions.get(question).equals(answer) ? true : false;
	}

	public String getRandomQuestion() {
		int limit = questions.size();

		Random rand = new Random();
		int randomQuestionIndex = rand.nextInt(limit);

		int i = 0;
		for (Map.Entry<String, String> questionSet : questions.entrySet()) {
			if (i == randomQuestionIndex)
				return questionSet.getValue();

			i++;
		}
		return null;
	}

}
