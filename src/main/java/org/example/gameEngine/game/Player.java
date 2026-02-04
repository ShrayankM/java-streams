package org.example.gameEngine.game;

public class Player {
	private int timeUsed;
	private String playerSymbol;

	public Player(String playerSymbol) {
		this.playerSymbol = playerSymbol;
		this.timeUsed = 0;
	}

	public String getPlayerSymbol() { return this.playerSymbol; }

	public Player getOpponentPlayer() {
		return new Player(this.getPlayerSymbol().equals("X") ? "O" : "X");
	}

	public int getTimeUsed() { return this.timeUsed; }
	public void addToTimeUsed(int timeInSeconds) {
		this.timeUsed += timeInSeconds;
	}

}
