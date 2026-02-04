package org.example.gameEngine.boards;

import java.util.ArrayList;
import java.util.List;

public class History {
	private List<Board> boardList = new ArrayList<>();

	public Board getBoardAtMoveIndex(int moveIndex) {
		return boardList.get(moveIndex);
	}

	public void undoLastMove() {
		if (boardList.size() == 0) {
			throw new IllegalArgumentException();
		}
		boardList.remove(boardList.size());
	}

	public void add(Board board) {
		boardList.add(board);
	}
}
