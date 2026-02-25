package org.example.byteByteGo.solid.lsp;

public class Rectangle implements Shape {
	protected int width;
	protected int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		return this.width * this.height;
	}
}
