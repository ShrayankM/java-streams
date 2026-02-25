package org.example.byteByteGo.solid.lsp;

public class ShapeDemo {
	public static void main(String [] args) {
		Shape shape = new Rectangle(10, 5);
		System.out.println("Shape of rectangle = " + shape.calculateArea());

		shape = new Square(6.77);
		System.out.println("Shape of square = " + shape.calculateArea());
	}
}
