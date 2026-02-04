package org.example.stackoverflow.entities;

public class Comment {
	private User author;
	private String data;

	public Comment(User author, String data) {
		this.author = author;
		this.data = data;
	}
}
