package org.example.byteByteGo.parkingSystem;

public abstract class ParkingSpot {
	private final String id;
	private Vehicle parkedVehicle;

	ParkingSpot(String id) {
		this.id = id;
	}

	boolean isParkingSpotVacant() {
		return parkedVehicle == null;
	}

	void occupySpot(Vehicle vehicle) {
		this.parkedVehicle = vehicle;
	}

	void vacatSpot() {
		this.parkedVehicle = null;
	}

	abstract VehicleSize getVehicleSize();
}
