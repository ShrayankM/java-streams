package org.example.gameEngine.api;

import org.example.gameEngine.boards.CellBoard;
import org.example.gameEngine.game.GameState;

import java.util.function.Function;

public class Rule {
	Function<CellBoard, GameState> condition;

	public Rule(Function<CellBoard, GameState> condition) {
		this.condition = condition;
	}
}
