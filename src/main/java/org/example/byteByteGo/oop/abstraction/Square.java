package org.example.byteByteGo.oop.abstraction;

public class Square extends Shape {
	private final double side;

	Square(String color, double side) {
		super(color);
		this.side = side;
	}

	@Override
	void calculateArea() {
		double area = side * side;
		System.out.println("Area of square = " + area);
	}

	@Override
	public void draw() {
		System.out.println("Drawing square shape");
	}
}
