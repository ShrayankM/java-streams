package org.example.byteByteGo.parkingSystem;

public class CompactSpot extends ParkingSpot {

	public CompactSpot(String id) {
		super(id);
	}

	@Override
	public VehicleSize getVehicleSize() {
		return VehicleSize.COMPACT;
	}
}
