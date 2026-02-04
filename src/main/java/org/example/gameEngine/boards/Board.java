package org.example.gameEngine.boards;

import org.example.gameEngine.game.Move;

public interface Board {
	void viewBoard();
	void move(Move move);
	Board copy();
}
