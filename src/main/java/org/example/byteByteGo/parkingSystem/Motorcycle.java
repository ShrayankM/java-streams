package org.example.byteByteGo.parkingSystem;

public class Motorcycle implements Vehicle {
	private final String licensePlate;

	public Motorcycle(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String getLicensePlate() {
		return this.licensePlate;
	}

	@Override
	public VehicleSize getVehicleSize() {
		return VehicleSize.COMPACT;
	}
}
