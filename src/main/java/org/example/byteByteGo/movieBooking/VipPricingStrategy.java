package org.example.byteByteGo.movieBooking;

import java.math.BigDecimal;

public class VipPricingStrategy implements PricingStrategy {
	private final BigDecimal VIP_RATE = new BigDecimal("75.0");

	@Override
	public BigDecimal getPrice() {
		return VIP_RATE;
	}
}
