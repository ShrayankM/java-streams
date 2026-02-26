package org.example.byteByteGo.parkingSystem;

import java.math.BigDecimal;
import java.util.Random;

public class ParkingLot {
	private ParkingManager parkingManager;
	private ParkingFareCalculator parkingFareCalculator;

	public ParkingLot(ParkingManager parkingManager, ParkingFareCalculator parkingFareCalculator) {
		this.parkingManager = parkingManager;
		this.parkingFareCalculator = parkingFareCalculator;
	}

	public Ticket entryVehicle(Vehicle vehicle) {
		ParkingSpot parkingSpot = parkingManager.parkVehicle(vehicle);

		if (parkingSpot != null) {
			return new Ticket(generateTicketId(), vehicle);
		}
		return null;
	}

	private String generateTicketId() {
		return new Random().toString();
	}

	public void exitVehicle(Ticket ticket) {
		Vehicle vehicle = ticket.getVehicle();
		parkingManager.unparkVehicle(vehicle);

		BigDecimal fare = parkingFareCalculator.calculateParkingFees(ticket);
		System.out.println("Vehicle fare calculated = $" + fare);
	}
}
