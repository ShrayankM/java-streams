package org.example.stackoverflow.search;

import org.example.stackoverflow.entities.Question;

import java.util.Arrays;
import java.util.List;

public class KeywordSearchStratergy implements SearchStratergy {

	@Override
	public Question searchQuestion(List<Question> questions, String searchBy) {
		for (Question question : questions) {
			String data = question.getData();

			List<String> dataList = Arrays.stream(data.split(" ")).toList();
			for (String currentKeyWord : dataList) {
				if (currentKeyWord.equalsIgnoreCase(searchBy)) {
					return question;
				}
			}
		}
		return null;
	}
}
