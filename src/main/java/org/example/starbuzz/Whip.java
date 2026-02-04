package org.example.starbuzz;

public class Whip extends CondimentDecorator {
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return this.beverage.getDescription() + " ,Whip-cream";
	}

	@Override
	Double cost() {
		return this.beverage.cost() + 0.10;
	}
}
