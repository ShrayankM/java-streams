package org.example.byteByteGo.oop.abstraction;

public class AbstractionTest {
	public static void main(String [] args) {
		Shape squareShape = new Square("Red", 8.35);

		squareShape.displayColor();
		squareShape.calculateArea();
		squareShape.draw();
	}
}
