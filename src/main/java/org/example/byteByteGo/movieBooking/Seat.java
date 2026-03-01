package org.example.byteByteGo.movieBooking;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Seat {
	private final String seatNumber;
	private final PricingStrategy pricingStrategy;

	public Seat(String seatNumber, PricingStrategy pricingStrategy) {
		this.seatNumber = seatNumber;
		this.pricingStrategy = pricingStrategy;
	}

	public BigDecimal getSeatPrice() {
		return this.pricingStrategy.getPrice();
	}

	@Override
	public String toString() {
		return seatNumber;
	}
}
