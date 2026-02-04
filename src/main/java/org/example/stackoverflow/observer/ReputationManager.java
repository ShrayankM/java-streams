package org.example.stackoverflow.observer;

import org.example.stackoverflow.entities.User;

public class ReputationManager implements PostObserver {
	private final static int upvote_answer_score = 5;
	private final static int downvote_answer_score = -2;
	private final static int upvote_question_score = 3;
	private final static int downvote_question_score = -1;

	@Override
	public void processEvent(Event event) {
		User author = event.getPost().getAuthor();
		switch (event.getEventType()) {
			case UPVOTE_ANSWER -> {
				author.updateUserReputation(upvote_answer_score);
			}

			case DOWNVOTE_ANSWER -> {
				author.updateUserReputation(downvote_answer_score);
			}

			case UPVOTE_QUESTION -> {
				author.updateUserReputation(upvote_question_score);
			}

			case DOWNVOTE_QUESTION -> {
				author.updateUserReputation(downvote_question_score);
			}
		}
 	}
}
