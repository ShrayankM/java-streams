package org.example.byteByteGo.parkingSystem;

public interface ParkingSpot {
	boolean isAvaliable();
	void vacat();
	void occupy(Vehicle vehicle);
	VehicleSize getVehicleSize();
	int getId();
}
