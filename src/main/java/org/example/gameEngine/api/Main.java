package org.example.gameEngine.api;

import org.example.gameEngine.boards.Board;
import org.example.gameEngine.game.Cell;
import org.example.gameEngine.game.GameState;
import org.example.gameEngine.game.Move;
import org.example.gameEngine.game.Player;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		GameEngine gameEngine = new GameEngine();
		AIEngine aiEngine = new AIEngine();
		RuleEngine ruleEngine = new RuleEngine();
		Board gameBoard = gameEngine.start("TicTacToe");

		Player computer = new Player("O");
		Player human = new Player("X");

		Scanner scanner = new Scanner(System.in);

		while (!ruleEngine.getState(gameBoard).isOver()) {
			System.out.println("Make your move");

			int rowInput = scanner.nextInt();
			int colInput = scanner.nextInt();

			// human-move
			gameEngine.move(gameBoard, new Move(new Cell(rowInput, colInput), human));

			// make move only is game not complete & cells remain
			if (!ruleEngine.getState(gameBoard).isOver()) {
				// computer-move
				Move computerMove = aiEngine.suggestMove(computer, gameBoard);
				gameEngine.move(gameBoard, computerMove);
			}
			gameBoard.viewBoard();
		}
		GameState gameState = ruleEngine.getState(gameBoard);
		System.out.println(gameState);
	}
}
