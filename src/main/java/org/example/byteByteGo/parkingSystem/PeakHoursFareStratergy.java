package org.example.byteByteGo.parkingSystem;

import java.math.BigDecimal;

public class PeakHoursFareStratergy implements FareStratergy {
	private static final BigDecimal PEAK_HOURS_RATE_MULTIPLIER = new BigDecimal(2);

	@Override
	public BigDecimal calculcateFare(Ticket ticket, BigDecimal inputFare) {
		return null;
	}
}
