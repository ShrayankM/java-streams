package org.example.gameEngine.placements;

import org.example.gameEngine.boards.TicTacToeBoard;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.GameState;
import org.example.gameEngine.game.Move;
import org.example.gameEngine.game.Player;
import org.example.gameEngine.utils.Utils;

import java.util.Optional;

public class OffensivePlacement implements Placement {
	public static OffensivePlacement offensivePlacement;

	private OffensivePlacement() {}

	public static synchronized Placement get() {
		offensivePlacement = (OffensivePlacement) Utils.getIfNull(offensivePlacement, OffensivePlacement::new);
		return offensivePlacement;
	}

	@Override
	public Optional<Cell> place(TicTacToeBoard ticTacToeBoard, Player player) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ticTacToeBoard.getSymbolAtCell(i, j) == null) {
					TicTacToeBoard ticTacToeBoardCopy = ticTacToeBoard.copy();
					ticTacToeBoardCopy.move(new Move(new Cell(i, j), player));

					GameState gameState = ruleEngine.getState(ticTacToeBoardCopy);
					if (gameState.isOver() && player.getPlayerSymbol().equals(gameState.getWinner())) {
						return Optional.of(new Cell(i, j));
					}
				}
			}
		}
		return Optional.empty();
	}

	@Override
	public Placement next() {
		return DefensivePlacement.get();
	}
}
