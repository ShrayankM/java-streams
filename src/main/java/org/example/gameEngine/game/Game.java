package org.example.gameEngine.game;

import org.example.gameEngine.boards.Board;

public class Game {
	private GameConfig gameConfig;
	private Board board;
	private Player winner;
	private int lastMoveTimeStampInSeconds;
	private int maxTimePerUserInSeconds;
	private int maxTimePerMoveForUserInSeconds;

	public void move(Move move, int timeStampInSeconds) {
		int timeTakenSinceLastMoveInSeconds = lastMoveTimeStampInSeconds - timeStampInSeconds;
		move.getPlayer().addToTimeUsed(timeTakenSinceLastMoveInSeconds);
		if (gameConfig.isTimed()) {

			if (gameConfig.isTimedPerPlayer()) {
				if (moveIsMadeInTime(timeTakenSinceLastMoveInSeconds, maxTimePerMoveForUserInSeconds)) {
					board.move(move);
				} else {
					winner = move.getPlayer().getOpponentPlayer();
				}

			} else {
				int totalTimeUsedByPlayerInSeconds = move.getPlayer().getTimeUsed();
				if (moveIsMadeInTime(totalTimeUsedByPlayerInSeconds, maxTimePerUserInSeconds)) {
					board.move(move);
				} else {
					winner = move.getPlayer().getOpponentPlayer();
				}
			}
		} else {
			board.move(move);
		}
	}

	private boolean moveIsMadeInTime(int totalTimeUsedByPlayerInSeconds, int maxTime) {
		return totalTimeUsedByPlayerInSeconds < maxTime;
	}
}
