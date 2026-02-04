package org.example.starbuzz;

public class Mocha extends CondimentDecorator {
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " ,Mocha (Chocolate)";
	}

	@Override
	Double cost() {
		return this.beverage.cost() + 0.20;
	}
}
