package org.example.starbuzz;

public class Decaf extends Beverage {
	public Decaf() {
		this.description = "Decaf coffee";
	}
	@Override
	Double cost() {
		return 1.05;
	}
}
