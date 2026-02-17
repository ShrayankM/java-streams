package org.example.byteByteGo.parkingSystem;

public class CompactSpot implements ParkingSpot {
	private int id;
	private VehicleSize vehicleSize;
	private Vehicle vehicle;

	public CompactSpot(int id) {
		this.id = id;
		this.vehicleSize = VehicleSize.SMALL;
		this.vehicle = null;
	}

	@Override
	public boolean isAvaliable() {
		return vehicle == null;
	}

	@Override
	public void vacat() {
		this.vehicle = null;
	}

	@Override
	public void occupy(Vehicle vehicle) {

		this.vehicle = vehicle;
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
