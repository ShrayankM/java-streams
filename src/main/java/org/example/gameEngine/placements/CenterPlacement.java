package org.example.gameEngine.placements;

import org.example.gameEngine.boards.TicTacToeBoard;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.Player;
import org.example.gameEngine.utils.Utils;

import java.util.Optional;

public class CenterPlacement implements Placement {
	public static CenterPlacement centerPlacement;

	private CenterPlacement() {}

	public static synchronized Placement get() {
		centerPlacement = (CenterPlacement) Utils.getIfNull(centerPlacement, CenterPlacement::new);
		return centerPlacement;
	}

	@Override
	public Optional<Cell> place(TicTacToeBoard ticTacToeBoard, Player player) {
		if (ticTacToeBoard.getSymbolAtCell(1, 1) == null) {
			return Optional.of(new Cell(1, 1));
		}
		return Optional.empty();
	}

	@Override
	public Placement next() {
		return CornerPlacement.get();
	}
}
