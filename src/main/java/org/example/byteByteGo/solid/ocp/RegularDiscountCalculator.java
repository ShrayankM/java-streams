package org.example.byteByteGo.solid.ocp;

public class RegularDiscountCalculator implements DiscountCalculator {
	private final static double fixedDiscountMultiplier = 0.05;

	@Override
	public double calculateDiscount(double amount) {
		return amount * fixedDiscountMultiplier;
	}
}
