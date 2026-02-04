package org.example.gameEngine.api;

import org.example.gameEngine.boards.Board;
import org.example.gameEngine.game.Move;
import org.example.gameEngine.boards.TicTacToeBoard;

public class GameEngine {
	public Board start(String typeOfBoard) {
		if ("TicTacToe".equals(typeOfBoard)) {
			return new TicTacToeBoard();
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void move(Board board, Move move) {
		if (board instanceof TicTacToeBoard) {
			board.move(move);
		} else {
			throw new IllegalArgumentException();
		}
	}
}

