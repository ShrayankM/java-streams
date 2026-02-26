package org.example.byteByteGo.parkingSystem;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Ticket {
	private final String id;
	private final Vehicle vehicle;
	private final LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private Double fees;

	public Ticket(String id, Vehicle vehicle) {
		this.id = id;
		this.vehicle = vehicle;
		this.entryTime = LocalDateTime.now();
	}

	public BigDecimal getVehicleParkedDuration() {
		return new BigDecimal(
				Duration.between(
						entryTime, Objects.requireNonNullElseGet(exitTime, LocalDateTime::now)
				).toSeconds());
	}
}
