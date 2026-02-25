package org.example.byteByteGo.solid.ocp;

public class PremiumDiscountCalculator implements DiscountCalculator {
	private final static double fixedDiscountMultiplier = 0.10;

	@Override
	public double calculateDiscount(double amount) {
		return amount * fixedDiscountMultiplier;
	}
}
