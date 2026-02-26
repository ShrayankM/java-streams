package org.example.byteByteGo.parkingSystem;

public class Truck implements Vehicle {
	private final String licensePlate;

	public Truck(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String getLicensePlate() {
		return this.licensePlate;
	}

	@Override
	public VehicleSize getVehicleSize() {
		return VehicleSize.OVERSIZED;
	}
}
