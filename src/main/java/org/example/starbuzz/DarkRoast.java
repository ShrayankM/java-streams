package org.example.starbuzz;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		this.description = "Dark-roast coffee";
	}

	@Override
	Double cost() {
		return 0.99;
	}
}
