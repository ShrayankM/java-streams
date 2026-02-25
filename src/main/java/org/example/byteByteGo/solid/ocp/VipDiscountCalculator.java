package org.example.byteByteGo.solid.ocp;

public class VipDiscountCalculator implements DiscountCalculator {
	private final static double fixedDiscountMultiplier = 0.20;

	@Override
	public double calculateDiscount(double amount) {
		return amount * fixedDiscountMultiplier;
	}
}
