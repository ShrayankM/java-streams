package org.example.byteByteGo.movieBooking;

import java.math.BigDecimal;

public class NormalPricingStrategy implements PricingStrategy {
	private final BigDecimal NORMAL_RATE = new BigDecimal("50.0");

	@Override
	public BigDecimal getPrice() {
		return NORMAL_RATE;
	}
}
