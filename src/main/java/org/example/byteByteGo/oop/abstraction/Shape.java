package org.example.byteByteGo.oop.abstraction;


public abstract class Shape implements Drawable {
	private final String color;

	Shape(String color) {
		this.color = color;
	}

	abstract void calculateArea();

	public void displayColor() {
		System.out.println("Color of the shape is = " + color);
	}
}
