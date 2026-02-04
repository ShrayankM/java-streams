package org.example.gameEngine.boards;

import org.example.gameEngine.api.Rule;
import org.example.gameEngine.api.RuleSet;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.GameState;
import org.example.gameEngine.game.Move;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TicTacToeBoard implements CellBoard {
	String[][] cells = new String[3][3];
	private static final RuleSet rules = new RuleSet();

	private History boardHistory = new History();

	public static RuleSet getRules() {
		rules.add(new Rule(board -> findStreak((i, j) -> board.getSymbolAtCell(i, j))));
		rules.add(new Rule(board -> findStreak((i, j) -> board.getSymbolAtCell(j, i))));
		rules.add(new Rule(board ->  findDiagonalStreak(i -> board.getSymbolAtCell(i, i))));
		rules.add(new Rule(board -> findDiagonalStreak(i -> board.getSymbolAtCell(i, 2 - i))));
		rules.add(new Rule(board -> countMoves(board)));
		return rules;
	}

	public String getSymbolAtCell(int i, int j) { return cells[i][j]; }

	public void setCell(Cell cell, String symbol) {
		int i = cell.getRowIndex();
		int j = cell.getColIndex();

		if (cells[i][j] == null) {
			cells[i][j] = symbol;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void viewBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (cells[i][j] == null) {
					System.out.print(" _ ");
				} else {
					System.out.print(" " + cells[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	@Override
	public void move(Move move) {
		boardHistory.add(this);

		Cell cellForMove = move.getCell();
		String playerSymbol = move.getPlayer().getPlayerSymbol();

		setCell(cellForMove, playerSymbol);
	}

	@Override
	public TicTacToeBoard copy() {
		TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ticTacToeBoard.setCell(new Cell(i, j), this.cells[i][j]);
			}
		}
		return ticTacToeBoard;
	}

	private static GameState findStreak(BiFunction<Integer, Integer, String> next) {
		for (int i = 0; i < 3; i++) {
			boolean possibleStreak = true;
			for (int j = 0; j < 3; j++) {
				if (next.apply(i, 0) == null || !next.apply(i, 0).equals(next.apply(i, j))) {
					possibleStreak = false;
					break;
				}
			}
			if (possibleStreak) {
				return new GameState(true, next.apply(i, 0));
			}
		}
		return new GameState(false, "-");
	}

	private static GameState findDiagonalStreak(Function<Integer, String> next) {
		boolean possibleStreak = true;
		for (int j = 0; j < 3; j++) {
			if (next.apply(0) == null || !next.apply(0).equals(next.apply(j))) {
				possibleStreak = false;
				break;
			}
		}

		if (possibleStreak) {
			return new GameState(true, next.apply(0));
		}
		return new GameState(false, "-");
	}

	private static GameState countMoves(CellBoard board) {
		int countFilledCells = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board.getSymbolAtCell(i, j) != null)
					countFilledCells++;
			}
		}

		if (countFilledCells == 9) {
			return new GameState(true, "-");
		}
		return new GameState(false, "-");
	}
}
