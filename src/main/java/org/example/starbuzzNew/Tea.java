package org.example.starbuzzNew;

public class Tea extends Beverage {
	@Override
	public void brew() {
		System.out.println("Put tea into the boiling water");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding lemon to the cup");
	}

	@Override
	public boolean customerWantsCondiments() {
		return false;
	}
}
