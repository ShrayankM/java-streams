package org.example.stackoverflow.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Reputation {
	private AtomicInteger score;

	public Reputation() {
		this.score = new AtomicInteger(0);
	}

	public void updateScore(int delta) {
		this.score.addAndGet(delta);
	}

	public AtomicInteger getScore() { return this.score; }
}
