package org.example.byteByteGo.parkingSystem;

public class RegularSpot extends ParkingSpot {
	public RegularSpot(String id) {
		super(id);
	}

	@Override
	public VehicleSize getVehicleSize() {
		return VehicleSize.REGULAR;
	}
}
