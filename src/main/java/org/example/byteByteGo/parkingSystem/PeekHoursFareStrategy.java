package org.example.byteByteGo.parkingSystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PeekHoursFareStrategy implements FareStrategy {
	private final BigDecimal PEEK_HOURS_MULTIPLIER = new BigDecimal("1.5");

	@Override
	public BigDecimal calculateParkingFees(Ticket ticket, BigDecimal inputFare) {
		LocalDateTime entryTime = ticket.getEntryTime();

		if (isEntryAtPeekHours(entryTime)) {
			return inputFare.multiply(PEEK_HOURS_MULTIPLIER);
		}
		return inputFare;
	}

	private boolean isEntryAtPeekHours(LocalDateTime entryTime) {
		int hour = entryTime.getHour();

		return (hour >= 7 && hour <= 10) || (hour >= 16 && hour <= 19);
	}
}
