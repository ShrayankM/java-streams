package org.example.byteByteGo.parkingSystem;

import java.math.BigDecimal;

public interface FareStrategy {
	BigDecimal calculateParkingFees(Ticket ticket, BigDecimal inputFare);
}
