package org.example.byteByteGo.movieBooking;

import java.math.BigDecimal;

public class PremiumPricingStrategy implements PricingStrategy {
	private final BigDecimal PREMIUM_RATE = new BigDecimal("150.0");

	@Override
	public BigDecimal getPrice() {
		return PREMIUM_RATE;
	}
}
