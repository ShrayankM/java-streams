package org.example.gameEngine.game;

public class Cell {
	private int rowIndex;
	private int colIndex;

	public Cell(int rowIndex, int colIndex) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}

	public int getRowIndex() { return this.rowIndex; }
	public int getColIndex() { return this.colIndex; }
}
