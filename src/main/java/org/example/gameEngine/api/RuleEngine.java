package org.example.gameEngine.api;

import org.example.gameEngine.boards.TicTacToeBoard;
import org.example.gameEngine.boards.Board;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.GameInfo;
import org.example.gameEngine.game.GameInfoBuilder;
import org.example.gameEngine.game.GameState;
import org.example.gameEngine.game.Move;
import org.example.gameEngine.game.Player;

import java.util.HashMap;

public class RuleEngine {
	private HashMap<String, RuleSet> ruleMap = new HashMap<>();

	public RuleEngine() {
		String ticTacToeRuleKey = TicTacToeBoard.class.getName();
		ruleMap.put(ticTacToeRuleKey, TicTacToeBoard.getRules());
	}

	public GameInfo getInfo(Board board) {
		if (board instanceof TicTacToeBoard) {
			GameState gameState = getState(board);

			TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
			// 1 player should have 3 moves, & second player should have 2 moves for fork to be possible
			int movesByPlayerWithSymbolX = 0, movesByPlayerWithSymbolO = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (ticTacToeBoard.getSymbolAtCell(i, j) == null) continue;

					if (ticTacToeBoard.getSymbolAtCell(i, j).equals("X")) movesByPlayerWithSymbolX++;
					if (ticTacToeBoard.getSymbolAtCell(i, j).equals("O")) movesByPlayerWithSymbolO++;
				}
			}

			if ((movesByPlayerWithSymbolX == 3 && movesByPlayerWithSymbolO == 2)
					|| (movesByPlayerWithSymbolX == 2 && movesByPlayerWithSymbolO == 3)) {
				// fork may be present

				// find playerWithTurn
				Player defendingPlayer = movesByPlayerWithSymbolX == 2 ? new Player("X") :
						new Player("O");
				Player attackingPlayer = defendingPlayer.getOpponentPlayer();

				Cell forkCell = null;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						TicTacToeBoard ticTacToeBoardCopy = ticTacToeBoard.copy();
						if (ticTacToeBoardCopy.getSymbolAtCell(i, j) != null) continue;

						ticTacToeBoardCopy.move(new Move(new Cell(i, j), defendingPlayer));

						for (int ii = 0; ii < 3; ii++) {
							for (int jj = 0; jj < 3; jj++) {
								if (ticTacToeBoardCopy.getSymbolAtCell(ii, jj) != null) continue;

								ticTacToeBoardCopy.move(new Move(new Cell(ii, jj), attackingPlayer));
								forkCell = new Cell(ii, jj);
								GameState getGameStateAfterAttack = getState(ticTacToeBoardCopy);
								if (getGameStateAfterAttack.getWinner().equals(attackingPlayer.getPlayerSymbol())) {
									return new GameInfoBuilder()
											.isOver(gameState.isOver())
											.winner(gameState.getWinner())
											.player(attackingPlayer)
											.hasFork(true)
											.forkCell(forkCell)
											.build();
								}
							}
						}
					}
				}
			}
			return new GameInfoBuilder()
					.isOver(gameState.isOver())
					.build();
		} else {
			throw new IllegalArgumentException();
		}
	}


	public GameState getState(Board board) {
		if (board instanceof TicTacToeBoard) {
			TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;

			RuleSet ticTacToeRules = ruleMap.get(TicTacToeBoard.class.getName());
			for (Rule rule : ticTacToeRules) {
				GameState gameState = rule.condition.apply(ticTacToeBoard);
				if (gameState.isOver()) return gameState;
			}
			return new GameState(false, "-");
		} else {
			throw new IllegalArgumentException();
		}
	}
}

