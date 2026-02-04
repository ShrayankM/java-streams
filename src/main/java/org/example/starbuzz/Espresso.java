package org.example.starbuzz;

public class Espresso extends Beverage {
	public Espresso() {
		this.description = "Espresso strong-coffee";
	}
	@Override
	Double cost() {
		return 1.99;
	}
}
