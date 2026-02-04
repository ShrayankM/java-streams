package org.example.gameEngine.game;

public class GameState {
	private boolean isOver;
	private String winner;

	public GameState(boolean isOver, String winner) {
		this.isOver = isOver;
		this.winner = winner;
	}

	@Override
	public String toString() {
		String gameStatus = this.isOver ? "complete" : "inProgress";
		String s = "Game-status = " + gameStatus + " Winner = [" + winner + "]";
		return s;
	}

	public boolean isOver() { return this.isOver; }
	public String getWinner() {return this.winner; }
}
