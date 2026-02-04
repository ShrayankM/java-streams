package org.example.stackoverflow.search;

import org.example.stackoverflow.entities.Question;

import java.util.List;

public interface SearchStratergy {
	Question searchQuestion(List<Question> questionList, String searchBy);
}
