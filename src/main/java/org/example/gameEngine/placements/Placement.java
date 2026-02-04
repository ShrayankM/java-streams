package org.example.gameEngine.placements;

import org.example.gameEngine.api.RuleEngine;
import org.example.gameEngine.boards.TicTacToeBoard;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.Player;

import java.util.Optional;

public interface Placement {
	RuleEngine ruleEngine = new RuleEngine();

	Optional<Cell> place(TicTacToeBoard ticTacToeBoard, Player player);
	Placement next();
}
