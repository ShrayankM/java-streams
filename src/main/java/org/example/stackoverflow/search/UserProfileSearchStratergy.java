package org.example.stackoverflow.search;

import org.example.stackoverflow.entities.Question;

import java.util.List;

public class UserProfileSearchStratergy implements SearchStratergy {

	@Override
	public Question searchQuestion(List<Question> questionList, String searchBy) {
		for (Question question : questionList) {
			String questionUserId = question.getUserId();

			if (questionUserId.equals(searchBy)) {
				return question;
			}
		}
		return null;
	}
}
