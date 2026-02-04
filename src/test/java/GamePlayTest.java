import org.example.gameEngine.api.GameEngine;
import org.example.gameEngine.api.RuleEngine;
import org.example.gameEngine.boards.Board;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.Move;
import org.example.gameEngine.game.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GamePlayTest {
	private GameEngine gameEngine;
	private RuleEngine ruleEngine;

	@Before
	public void setupForTest() {
		gameEngine = new GameEngine();
		ruleEngine = new RuleEngine();
	}

	@Test
	public void checkRowWin() {
		Board gameBoard = gameEngine.start("TicTacToe");
		int [][] playerOneMoves = new int [][] {{1, 0}, {1, 1}, {1, 2}};
		int [][] playerTwoMoves = new int [][] {{0, 0}, {2, 0}, {2, 1}};

		// player-one-win
		playGame(gameBoard, playerOneMoves, playerTwoMoves);
		Assert.assertTrue(ruleEngine.getState(gameBoard).isOver());
		Assert.assertEquals("X", ruleEngine.getState(gameBoard).getWinner());
	}

	@Test
	public void checkForColWin() {
		Board gameBoard = gameEngine.start("TicTacToe");
		int [][] playerOneMoves = new int [][] {{0, 0}, {1, 0}, {2, 0}};
		int [][] playerTwoMoves = new int [][] {{0, 1}, {0, 2}, {2, 1}};

		// player-one-win
		playGame(gameBoard, playerOneMoves, playerTwoMoves);
		Assert.assertTrue(ruleEngine.getState(gameBoard).isOver());
		Assert.assertEquals("X", ruleEngine.getState(gameBoard).getWinner());
	}

	@Test
	public void checkForDiagonalWin() {
		Board gameBoard = gameEngine.start("TicTacToe");
		int [][] playerOneMoves = new int [][] {{0, 0}, {1, 1}, {2, 2}};
		int [][] playerTwoMoves = new int [][] {{0, 1}, {0, 2}, {2, 1}};

		// player-one-win
		playGame(gameBoard, playerOneMoves, playerTwoMoves);
		Assert.assertTrue(ruleEngine.getState(gameBoard).isOver());
		Assert.assertEquals("X", ruleEngine.getState(gameBoard).getWinner());
	}

	@Test
	public void checkForRevDiagonalWin() {
		Board gameBoard = gameEngine.start("TicTacToe");
		int [][] playerOneMoves = new int [][] {{0, 2}, {1, 1}, {2, 0}};
		int [][] playerTwoMoves = new int [][] {{0, 1}, {0, 0}, {2, 1}};

		// player-one-win
		playGame(gameBoard, playerOneMoves, playerTwoMoves);
		Assert.assertTrue(ruleEngine.getState(gameBoard).isOver());
		Assert.assertEquals("X", ruleEngine.getState(gameBoard).getWinner());
	}

	@Test
	public void checkForComputerWin() {
		Board gameBoard = gameEngine.start("TicTacToe");
		int [][] playerOneMoves = new int [][] {{0, 0}, {0, 1}, {1, 0}};
		int [][] playerTwoMoves = new int [][] {{2, 0}, {2, 1}, {2, 2}};

		// player-two-win
		playGame(gameBoard, playerOneMoves, playerTwoMoves);
		Assert.assertTrue(ruleEngine.getState(gameBoard).isOver());
		Assert.assertEquals("O", ruleEngine.getState(gameBoard).getWinner());
	}

	private void playGame(Board gameBoard, int [][] playerOneMoves, int [][] playerTwoMoves) {
		Player playerOne = new Player("X");
		Player playerTwo = new Player("O");

		int index = 0;
		while (!ruleEngine.getState(gameBoard).isOver()) {
			// player-one move
			gameEngine.move(gameBoard, new Move(new Cell(playerOneMoves[index][0], playerOneMoves[index][1]), playerOne));

			// make move only is game not complete & cells remain
			if (!ruleEngine.getState(gameBoard).isOver()) {
				// computer-move
				gameEngine.move(gameBoard, new Move(new Cell(playerTwoMoves[index][0], playerTwoMoves[index][1]), playerTwo));
			}
			index++;
		}
	}
}
