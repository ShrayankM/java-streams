package org.example.byteByteGo.parkingSystem;

public class Bus implements Vehicle {
	private String licensePlate;

	public Bus(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public VehicleSize getVehicleSize() {
		return VehicleSize.LARGE;
	}

	@Override
	public String getLicensePlate() {
		return this.licensePlate;
	}
}
