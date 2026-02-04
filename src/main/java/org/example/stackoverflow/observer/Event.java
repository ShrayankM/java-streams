package org.example.stackoverflow.observer;

import org.example.stackoverflow.entities.Post;
import org.example.stackoverflow.entities.User;

public class Event {
	private Post post;
	private EventType eventType;

	public Event(EventType eventType, Post post) {
		this.eventType = eventType;
		this.post = post;
	}

	public EventType getEventType() { return this.eventType; }
	public Post getPost() { return this.post; }
}
