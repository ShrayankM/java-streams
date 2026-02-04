package org.example.starbuzz;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		this.description = "House-blend coffee";
	}

	@Override
	Double cost() {
		return 0.89;
	}
}
