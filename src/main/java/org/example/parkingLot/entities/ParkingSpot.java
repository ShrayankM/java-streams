package org.example.parkingLot.entities;

import org.example.parkingLot.enums.Status;
import org.example.parkingLot.enums.VehicleType;

public class ParkingSpot {
	private String id;
	private VehicleType vehicleType;
	private Status status;
	private Vehicle parkedVehicle;

	public ParkingSpot() {
		this.id = "id";
		this.vehicleType = VehicleType.CAR;
		this.status = Status.VACANT;
	}

	public ParkingSpot(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
		this.id = "id";
		this.status = Status.VACANT;
	}

	public void parkVehicle(Vehicle vehicle) {
		this.parkedVehicle = vehicle;
		this.status = Status.OCCUPIED;
	}

	public void unparkVehicle() {
		this.parkedVehicle = null;
		this.status = Status.VACANT;
	}

	public boolean isVacant() {
		return this.status == Status.VACANT;
	}

	public boolean matchesVehicleType(VehicleType vehicleType) {
		return this.vehicleType == vehicleType;
	}

	public Status getStatus() { return this.status; }

	public VehicleType getVehicleType() { return this.vehicleType; }

	public Vehicle getParkedVehicle() { return this.parkedVehicle; }
}
