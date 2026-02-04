package org.example.gameEngine.placements;

import org.example.gameEngine.boards.TicTacToeBoard;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.GameInfo;
import org.example.gameEngine.game.Player;
import org.example.gameEngine.utils.Utils;

import java.util.Optional;

public class ForkPlacement implements Placement {
	public static ForkPlacement forkPlacement;

	private ForkPlacement() {};

	public static synchronized Placement get() {
		forkPlacement = (ForkPlacement) Utils.getIfNull(forkPlacement, ForkPlacement::new);
		return forkPlacement;
	}

	@Override
	public Optional<Cell> place(TicTacToeBoard ticTacToeBoard, Player player) {
		GameInfo currentGameInfo = ruleEngine.getInfo(ticTacToeBoard);
		if (currentGameInfo.isHasFork()) {
			return Optional.of(currentGameInfo.getForkCell());
		}
		return Optional.empty();
	}

	@Override
	public Placement next() {
		return CenterPlacement.get();
	}
}
