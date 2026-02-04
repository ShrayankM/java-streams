package org.example.starbuzzNew;

public class Coffee extends Beverage {

	@Override
	public void brew() {
		System.out.println("Grind the coffee beans & put in boiling water");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding sugar & milk to the cup");
	}
}
