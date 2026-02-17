package org.example.byteByteGo.parkingSystem;

import java.math.BigDecimal;

public class ParkingLot {
	private ParkingManager parkingManager = new ParkingManager();
	private FareCalculator fareCalculator;

	public Ticket enterVehicle(Vehicle vehicle) {
		ParkingSpot parkingSpot = parkingManager.parkVehicle(vehicle);
		return new Ticket(parkingSpot, vehicle);
	}

	public void exitVehicle(Ticket ticket) {
		BigDecimal fees = fareCalculator.calculateFare(ticket);
		System.out.println("Total parking fees = " + fees);
		parkingManager.unparkVehicle(ticket.getVehicle());
	}
}
