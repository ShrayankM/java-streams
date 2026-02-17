package org.example.byteByteGo.parkingSystem;

import java.math.BigDecimal;

public class BaseFareStratergy implements FareStratergy {
	private static final BigDecimal SMALL_VEHICLE_RATE = new BigDecimal(10);
	private static final BigDecimal MEDIUM_VEHICLE_RATE = new BigDecimal(20);
	private static final BigDecimal LARGE_VEHICLE_RATE = new BigDecimal(35);

	@Override
	public BigDecimal calculcateFare(Ticket ticket, BigDecimal inputFare) {
		return null;
	}
}
