package org.example.starbuzzNew;

public abstract class Beverage {
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	abstract void brew();
	abstract void addCondiments();

	final void boilWater() {
		System.out.println("Boiling water");
	}

	final void pourInCup() {
		System.out.println("Pour it in a cup");
	}

	boolean customerWantsCondiments() {
		return true;
	}
}
