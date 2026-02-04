package org.example.gameEngine.api;

import org.example.gameEngine.boards.TicTacToeBoard;
import org.example.gameEngine.boards.Board;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.GameState;
import org.example.gameEngine.game.Move;
import org.example.gameEngine.game.Player;
import org.example.gameEngine.placements.OffensivePlacement;
import org.example.gameEngine.placements.Placement;

import java.util.Optional;

public class AIEngine {
	public Move suggestMove(Player computer, Board board) {
		if (board instanceof TicTacToeBoard) {
			TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
			Cell suggestedCell = null;
			int threshold = 3;
			if (checkMovesThreshold(ticTacToeBoard, threshold)) {
				suggestedCell = getInitialCellToPlay(ticTacToeBoard);
			} else if (checkMovesThreshold(ticTacToeBoard, threshold + 1)) {
				suggestedCell = getSmartCellToPlay(computer, ticTacToeBoard);
			} else {
				suggestedCell = getOptimalCellToPlay(computer, ticTacToeBoard);
			}
			return new Move(suggestedCell, computer);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private Cell getOptimalCellToPlay(Player computer, TicTacToeBoard ticTacToeBoard) {
		Placement placement = OffensivePlacement.get();
		while (placement.next() != null) {
			Optional<Cell> isPlacement =   placement.place(ticTacToeBoard, computer);
			if (isPlacement.isPresent()) {
				return isPlacement.get();
			}
			placement = placement.next();
		}
		return null;


//		RuleEngine ruleEngine = new RuleEngine();
//		// if computer has winning move, play it
//		Cell offensiveCell = offensiveCell(computer, ticTacToeBoard);
//		if (offensiveCell != null) return offensiveCell;
//
//		// if player has winning move, block it
//		Cell defensiveCell = defensiveCell(computer, ticTacToeBoard);
//		if (defensiveCell != null) return defensiveCell;
//
//		// if computer has fork, then play it
//		// if player has fork, then block it
//		GameInfo currentGameInfo = ruleEngine.getInfo(ticTacToeBoard);
//		if (currentGameInfo.isHasFork()) {
//			return currentGameInfo.getForkCell();
//		}
//
//		// if center is available, play it
//		if (ticTacToeBoard.getSymbolAtCell(1, 1) == null) {
//			return new Cell(1, 1);
//		}
//		// if corner is available, play it
//		int [][] cornerCellsIndex = new int [][]{{0, 0}, {0, 2}, {2, 0}, {2, 2}};
//		for (int i = 0; i < cornerCellsIndex.length; i++) {
//			int rowIndex = cornerCellsIndex[i][0];
//			int colIndex = cornerCellsIndex[i][1];
//
//			if (ticTacToeBoard.getSymbolAtCell(rowIndex, colIndex) == null) {
//				return new Cell(rowIndex, colIndex);
//			}
//		}
//		return null;
	}

	private Cell getInitialCellToPlay( TicTacToeBoard ticTacToeBoard) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ticTacToeBoard.getSymbolAtCell(i, j) == null) {
					new Cell(i, j);
				}
			}
		}
		return null;
	}

	private Cell offensiveCell(Player player, TicTacToeBoard ticTacToeBoard) {
		RuleEngine ruleEngine = new RuleEngine();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ticTacToeBoard.getSymbolAtCell(i, j) == null) {
					TicTacToeBoard ticTacToeBoardCopy = ticTacToeBoard.copy();
					ticTacToeBoardCopy.move(new Move(new Cell(i, j), player));

					GameState gameState = ruleEngine.getState(ticTacToeBoardCopy);
					if (gameState.isOver() && player.getPlayerSymbol().equals(gameState.getWinner())) {
						return new Cell(i, j);
					}
				}
			}
		}
		return null;
	}

	private Cell defensiveCell(Player player, TicTacToeBoard ticTacToeBoard) {
		RuleEngine ruleEngine = new RuleEngine();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ticTacToeBoard.getSymbolAtCell(i, j) == null) {
					TicTacToeBoard ticTacToeBoardCopy = ticTacToeBoard.copy();
					ticTacToeBoardCopy.move(new Move(new Cell(i, j), player));

					GameState gameState = ruleEngine.getState(ticTacToeBoardCopy);
					if (gameState.isOver() && player.getPlayerSymbol().equals(gameState.getWinner())) {
						return new Cell(i, j);
					}
				}
			}
		}
		return null;
	}

	private Cell getSmartCellToPlay(Player computer, TicTacToeBoard ticTacToeBoard) {
//		RuleEngine ruleEngine = new RuleEngine();

		// attacking moves (computer trying to win)
		// check if computer can win the game by making a move, if yes play that move & win
		Cell offensiveCell = offensiveCell(computer, ticTacToeBoard);
		if (offensiveCell != null) return offensiveCell;
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				if (ticTacToeBoard.getSymbolAtCell(i, j) == null) {
//					TicTacToeBoard ticTacToeBoardCopy = ticTacToeBoard.copy();
//					ticTacToeBoardCopy.move(new Move(new Cell(i, j), computer));
//
//					GameState gameState = ruleEngine.getState(ticTacToeBoardCopy);
//					if (gameState.isOver() && computer.getPlayerSymbol().equals(gameState.getWinner())) {
//						return new Cell(i, j);
//					}
//				}
//			}
//		}

		// defensive moves
		// check if human can win the game by making a move, if yes block the human & stop him from winning
		Player human = computer.getOpponentPlayer();
		Cell defensiveCell = defensiveCell(human, ticTacToeBoard);
		if (defensiveCell != null) return defensiveCell;
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				if (ticTacToeBoard.getSymbolAtCell(i, j) == null) {
//					TicTacToeBoard ticTacToeBoardCopy = ticTacToeBoard.copy();
//					ticTacToeBoardCopy.move(new Move(new Cell(i, j), human));
//
//					GameState gameState = ruleEngine.getState(ticTacToeBoardCopy);
//					if (gameState.isOver() && human.getPlayerSymbol().equals(gameState.getWinner())) {
//						return new Cell(i, j);
//					}
//				}
//			}
//		}
		return getInitialCellToPlay(ticTacToeBoard);
	}

	private boolean checkMovesThreshold(TicTacToeBoard ticTacToeBoard, int threshold) {
		int countMoves = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ticTacToeBoard.getSymbolAtCell(i, j) != null) {
					countMoves++;
				}
			}
		}
		return countMoves < threshold;
	}
}
