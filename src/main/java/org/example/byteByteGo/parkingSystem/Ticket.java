package org.example.byteByteGo.parkingSystem;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

@Getter
public class Ticket {
	private int id;
	private ParkingSpot parkingSpot;
	private Vehicle vehicle;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private BigDecimal fees;

	public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
		this.id = new Random().nextInt();
		this.parkingSpot = parkingSpot;
		this.vehicle = vehicle;
		this.entryTime = LocalDateTime.now();
	}

	BigDecimal calculateParkingDuration() {
		return new BigDecimal(Duration.between(entryTime, Objects.requireNonNullElse(exitTime, LocalDateTime.now())).toMinutes());
	}
}
