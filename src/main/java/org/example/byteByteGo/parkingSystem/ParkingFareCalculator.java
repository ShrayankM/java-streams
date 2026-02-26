package org.example.byteByteGo.parkingSystem;

import java.math.BigDecimal;
import java.util.List;

public class ParkingFareCalculator {
	private List<FareStrategy> fareStrategyList;

	public ParkingFareCalculator(List<FareStrategy> fareStrategyList) {
		this.fareStrategyList = fareStrategyList;
	}

	public BigDecimal calculateParkingFees(Ticket ticket) {
		BigDecimal fare = new BigDecimal("0.0");

		for (FareStrategy fareStrategy : fareStrategyList) {
			fare = fareStrategy.calculateParkingFees(ticket, fare);
		}
		return fare;
	}
}
