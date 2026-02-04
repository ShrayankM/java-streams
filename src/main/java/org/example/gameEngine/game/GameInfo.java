package org.example.gameEngine.game;

public class GameInfo {
	private boolean isOver;
	private String winner;
	private Player player;
	private boolean hasFork;
	private Cell forkCell;

	public GameInfo(boolean isOver, String winner, Player player, boolean hasFork, Cell forkCell) {
		this.isOver = isOver;
		this.winner = winner;
		this.player = player;
		this.hasFork = hasFork;
		this.forkCell = forkCell;
	}

	public boolean isHasFork() { return this.hasFork; }
	public Player getForkPlayer() { return this.player; }
	public Cell getForkCell() { return this.forkCell; }
}

