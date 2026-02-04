package org.example.stackoverflow.entities;

import org.example.stackoverflow.observer.Event;
import org.example.stackoverflow.observer.EventType;
import org.example.stackoverflow.observer.PostObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Post {
	private String id;
	private String data;
	private User author;
	private List<Comment> comments;
	private AtomicInteger voteCount;
	private Map<String, VoteType> voters;
	private List<PostObserver> observers;

	public Post(String id, String data, User author) {
		this.id = id;
		this.data = data;
		this.author = author;
		this.comments = new ArrayList<>();
		this.voters = new HashMap<>();
		this.voteCount = new AtomicInteger(0);
		this.observers = new ArrayList<>();
	}

	public String getData() { return this.data; }
	public String getId() { return this.id; }

	public User getAuthor() { return this.author; }

	public String getUserId() {
		return this.author.getId();
	}

	protected void notifyObservers(Event event) {
		observers.forEach(o -> o.processEvent(event));
	}

	public void addObservers(PostObserver observer) {
		this.observers.add(observer);
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public void vote(User user, VoteType voteType) {
		String userId = user.getId();
		User author = this.author;
		if (voters.containsKey(userId)) {
			if (voters.get(userId) == voteType) {
				return;
			}

			// change of vote
			int changeInVoteCount = 0;
			VoteType previousVoteType = voters.get(userId);

			if (previousVoteType == VoteType.UPVOTE) {
				changeInVoteCount = -2;
			} else {
				changeInVoteCount = 2;
			}
			voteCount.addAndGet(changeInVoteCount);
//			author.updateUserReputation(changeInVoteCount);
		} else {
			// first-time vote
			int change = 0;
			if (voteType == VoteType.UPVOTE) {
				change = 1;
			} else {
				change = -1;
			}
			voteCount.addAndGet(change);
//			author.updateUserReputation(change);
		}

		EventType eventType = EventType.UPVOTE_QUESTION;

		if (this instanceof Question) {
			eventType = (voteType == VoteType.UPVOTE ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION);
		} else {
			eventType = (voteType == VoteType.UPVOTE ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER);
		}

		notifyObservers(new Event(eventType, this));
	}
}
