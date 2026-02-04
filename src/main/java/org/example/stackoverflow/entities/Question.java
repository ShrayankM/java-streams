package org.example.stackoverflow.entities;

import java.util.ArrayList;
import java.util.List;

public class Question extends Post {
	private List<Tag> questionTags;
	private List<Answer> answers;

	public Question(String id, String data, User author) {
		super(id, data, author);
		this.answers = new ArrayList<>();
		this.questionTags = new ArrayList<>();
	}

	public void addTag(Tag tag) {
		this.questionTags.add(tag);
	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
	}

	public List<Tag> getTags() {
		return this.questionTags;
	}
}
