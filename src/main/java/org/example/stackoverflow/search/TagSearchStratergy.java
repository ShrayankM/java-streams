package org.example.stackoverflow.search;

import org.example.stackoverflow.entities.Question;
import org.example.stackoverflow.entities.Tag;

import java.util.List;

public class TagSearchStratergy implements SearchStratergy {

	@Override
	public Question searchQuestion(List<Question> questionList, String searchBy) {
		for (Question question : questionList) {
			List<Tag> questionTags = question.getTags();

			for (Tag tag : questionTags) {
				if (tag.name().equals(searchBy)) {
					return question;
				}
			}
		}
		return null;
	}
}
