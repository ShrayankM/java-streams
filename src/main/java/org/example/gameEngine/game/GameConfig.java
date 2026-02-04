package org.example.gameEngine.game;

public class GameConfig {
	private final boolean timed;

	private final boolean isTimedPerPlayer;

	public GameConfig(boolean timed, boolean isTimedPerPlayer) {
		this.timed = timed;
		this.isTimedPerPlayer = isTimedPerPlayer;
	}

	public boolean isTimed() { return this.timed; }
	public boolean isTimedPerPlayer() { return this.isTimedPerPlayer; }
}
