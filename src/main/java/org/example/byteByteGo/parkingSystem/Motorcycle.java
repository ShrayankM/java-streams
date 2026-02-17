package org.example.byteByteGo.parkingSystem;

public class Motorcycle implements Vehicle {
	private String licensePlate;

	public Motorcycle(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public VehicleSize getVehicleSize() {
		return VehicleSize.SMALL;
	}

	@Override
	public String getLicensePlate() {
		return this.licensePlate;
	}
}
