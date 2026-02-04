package org.example.stackoverflow;

import org.example.stackoverflow.entities.Answer;
import org.example.stackoverflow.entities.Comment;
import org.example.stackoverflow.entities.Question;
import org.example.stackoverflow.entities.Tag;
import org.example.stackoverflow.entities.User;
import org.example.stackoverflow.entities.VoteType;
import org.example.stackoverflow.search.KeywordSearchStratergy;
import org.example.stackoverflow.search.SearchStratergy;
import org.example.stackoverflow.search.TagSearchStratergy;
import org.example.stackoverflow.search.UserProfileSearchStratergy;

public class StackOverFlow {
	public static void main(String [] args) {
		StackOverFlowSystem stackOverFlowSystem = StackOverFlowSystem.getInstance();

		User john = stackOverFlowSystem.createUser("U1");
		User max = stackOverFlowSystem.createUser("U2");
		User rick = stackOverFlowSystem.createUser("U3");

		Question q1 = stackOverFlowSystem.postQuestions("Q1", john, "Is java a good programming language ?");
		Question q2 = stackOverFlowSystem.postQuestions("Q2", max, "Is ai really useful ?");
		Question q3 = stackOverFlowSystem.postQuestions("Q3", rick, "How to learn system-design ?");

		q1.vote(max, VoteType.UPVOTE);
		q1.vote(rick, VoteType.UPVOTE);

		Answer a1 = stackOverFlowSystem.postAnswer("A1", q1.getId(), max, "Java is a very good language to use");
		Answer a2 = stackOverFlowSystem.postAnswer("A2", q1.getId(), rick, "Java is a very hard to learn programming language");

		a1.vote(john, VoteType.UPVOTE);
		a2.vote(john, VoteType.DOWNVOTE);

		Answer a3 = stackOverFlowSystem.postAnswer("A3", q2.getId(), john,"AI is the next big thing");
		Answer a4 = stackOverFlowSystem.postAnswer("A4", q2.getId(), rick, "AI is shit");

		a3.vote(max, VoteType.UPVOTE);
		a4.vote(john, VoteType.DOWNVOTE);
		a4.vote(max, VoteType.DOWNVOTE);

		john.viewReputation();
		max.viewReputation();
		rick.viewReputation();

		SearchStratergy searchStratergy = new KeywordSearchStratergy();
		Question findQuestion = searchStratergy.searchQuestion(stackOverFlowSystem.getQuestionList(),
				"JAVA");
		if (findQuestion != null) {
			System.out.println("Keyword successful");
			System.out.println(findQuestion.getData());
		}


		searchStratergy = new TagSearchStratergy();
		Question findQuestionByTag = searchStratergy.searchQuestion(stackOverFlowSystem.getQuestionList(), "JAVA");
		if (findQuestionByTag != null) {
			System.out.println("Tag-search successful");
			System.out.println(findQuestionByTag.getData());
		}

		searchStratergy = new UserProfileSearchStratergy();
		Question findQuestionByUserId = searchStratergy.searchQuestion(stackOverFlowSystem.getQuestionList(), max.getId());
		if (findQuestionByUserId != null) {
			System.out.println("User-id successful");
			System.out.println(findQuestionByUserId.getData());
		}
	}
}
