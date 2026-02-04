package org.example.parkingLot.entities;

import org.example.parkingLot.enums.VehicleType;

public class Vehicle {
	private String id;
	private VehicleType vehicleType;

	public Vehicle(String id, VehicleType vehicleType) {
		this.id = id;
		this.vehicleType = vehicleType;
	}


	public VehicleType getVehicleType() { return this.vehicleType; }
	public String getId() { return this.id; }
}
