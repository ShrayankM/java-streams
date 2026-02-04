package org.example.stackoverflow.entities;

public class User {
	private String id;
	private Reputation reputation;

	public User(String id) {
		this.id = id;
		this.reputation = new Reputation();
	}

	public String getId() { return this.id; }

	public void updateUserReputation(int delta) {
		this.reputation.updateScore(delta);
	}

	public Reputation getReputation() { return this.reputation; }

	public void viewReputation() {
		System.out.println("Reputation = " + this.reputation.getScore() );
	}
}
