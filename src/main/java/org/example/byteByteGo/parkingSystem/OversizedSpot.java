package org.example.byteByteGo.parkingSystem;

public class OversizedSpot implements ParkingSpot {
	private int id;
	private VehicleSize vehicleSize;
	private Vehicle vehicle;
	private boolean isOccupied;

	public OversizedSpot(int id) {
		this.id = id;
		this.vehicleSize = VehicleSize.LARGE;
		this.isOccupied = false;
		this.vehicle = null;
	}

	@Override
	public boolean isAvaliable() {
		return isOccupied;
	}

	@Override
	public void vacat() {
		this.isOccupied = false;
	}

	@Override
	public void occupy(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.isOccupied = true;
	}

	@Override
	public VehicleSize getVehicleSize() {
		return this.vehicleSize;
	}

	@Override
	public int getId() {
		return this.id;
	}
}
