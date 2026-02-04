package org.example.starbuzz;

public abstract class Beverage {
	public enum Size { TALL, GRANDE, VENTI }

	String description;
	private Size size;

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	abstract Double cost();
	public String getDescription() {
		return this.description;
	}
}
