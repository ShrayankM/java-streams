package org.example.starbuzz;

public class SteamedMilk extends CondimentDecorator {
	public SteamedMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	Double cost() {
		return this.beverage.cost() + 0.10;
	}

	@Override
	public String getDescription() {
		return this.beverage.getDescription() + " ,Steamed-milk";
	}
}
