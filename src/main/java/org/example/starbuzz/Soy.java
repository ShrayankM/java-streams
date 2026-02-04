package org.example.starbuzz;

public class Soy extends CondimentDecorator {
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return this.beverage.getDescription() + " ,Soy";
	}

	@Override
	Double cost() {
		Double additionalCost = 0.0;
		if (this.beverage.getSize().equals(Size.TALL)) {
			additionalCost = 0.10;
		}

		if (this.beverage.getSize().equals(Size.GRANDE)) {
			additionalCost = 0.15;
		}

		if (this.beverage.getSize().equals(Size.VENTI)) {
			additionalCost = 0.20;
		}

		return this.beverage.cost() + additionalCost;
	}
}
