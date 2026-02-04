package org.example.stackoverflow;

import org.example.stackoverflow.entities.Answer;
import org.example.stackoverflow.entities.Comment;
import org.example.stackoverflow.entities.Question;
import org.example.stackoverflow.entities.Reputation;
import org.example.stackoverflow.entities.Tag;
import org.example.stackoverflow.entities.User;
import org.example.stackoverflow.entities.VoteType;
import org.example.stackoverflow.observer.ReputationManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOverFlowSystem {
	private static StackOverFlowSystem stackOverFlowSystem;
	private Map<String, Question> questionMap = new HashMap<>();
	private Map<String, User> userMap = new HashMap<>();

	// single-ton design pattern
	private StackOverFlowSystem() {};

	public static synchronized StackOverFlowSystem getInstance() {
		if (stackOverFlowSystem == null) {
			return new StackOverFlowSystem();
		}
		return stackOverFlowSystem;
	}

	public List<Question> getQuestionList() {
		return this.questionMap.values().stream().toList();
	}

	public User createUser(String id) {
		User user = new User(id);
		userMap.put(id, user);
		return user;
	}

	Question postQuestions(String id, User author, String data) {
		Question question = new Question(id, data, author);
		question.addObservers(new ReputationManager());
		questionMap.put(id, question);
		return question;
	}

	Answer postAnswer(String id, String questionId, User author, String data) {
		Answer answer = new Answer(id, data, author);
		Question question = questionMap.get(questionId);
		question.addAnswer(answer);
		return answer;
	}

	void commentOnQuestion(Comment comment, Question question) {
		String questionId = question.getId();
		if (questionMap.containsKey(questionId)) {
			question.addComment(comment);;
		} else {
			System.out.println("Question does not exist");
		}
	}

	void commentOnAnswer(Comment comment, Answer answer) {
		answer.addComment(comment);
	}

}
