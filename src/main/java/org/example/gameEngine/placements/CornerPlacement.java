package org.example.gameEngine.placements;

import org.example.gameEngine.boards.TicTacToeBoard;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.Player;
import org.example.gameEngine.utils.Utils;

import java.util.Optional;

public class CornerPlacement implements Placement {
	public static CornerPlacement cornerPlacement;

	private CornerPlacement() {}

	public static synchronized Placement get() {
		cornerPlacement = (CornerPlacement) Utils.getIfNull(cornerPlacement, CornerPlacement::new);
		return cornerPlacement;
	}

	@Override
	public Optional<Cell> place(TicTacToeBoard ticTacToeBoard, Player player) {
		int [][] cornerCellsIndex = new int [][]{{0, 0}, {0, 2}, {2, 0}, {2, 2}};
		for (int i = 0; i < cornerCellsIndex.length; i++) {
			int rowIndex = cornerCellsIndex[i][0];
			int colIndex = cornerCellsIndex[i][1];

			if (ticTacToeBoard.getSymbolAtCell(rowIndex, colIndex) == null) {
				return Optional.of(new Cell(rowIndex, colIndex));
			}
		}
		return Optional.empty();
	}

	@Override
	public Placement next() {
		return null;
	}
}
