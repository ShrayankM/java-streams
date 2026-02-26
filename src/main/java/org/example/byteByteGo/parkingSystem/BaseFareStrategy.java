package org.example.byteByteGo.parkingSystem;

import java.math.BigDecimal;

public class BaseFareStrategy implements FareStrategy {
	private final BigDecimal COMPACT_VEHICLE_BASE_FARE = new BigDecimal("10.0");
	private final BigDecimal REGULAR_VEHICLE_BASE_FARE = new BigDecimal("20.0");
	private final BigDecimal OVERSIZED_VEHICLE_BASE_FARE = new BigDecimal("30.0");

	@Override
	public BigDecimal calculateParkingFees(Ticket ticket, BigDecimal inputFare) {
		Vehicle vehicle = ticket.getVehicle();
		BigDecimal durationInMinutes = ticket.getVehicleParkedDuration();

		BigDecimal rate = new BigDecimal("1.0");
		switch (vehicle.getVehicleSize()) {
			case COMPACT -> rate = COMPACT_VEHICLE_BASE_FARE;
			case REGULAR -> rate = REGULAR_VEHICLE_BASE_FARE;
			case OVERSIZED -> rate = OVERSIZED_VEHICLE_BASE_FARE;
		}
		return inputFare.add(durationInMinutes.multiply(rate));
	}
}
