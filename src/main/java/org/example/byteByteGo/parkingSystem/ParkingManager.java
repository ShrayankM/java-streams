package org.example.byteByteGo.parkingSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
	Map<VehicleSize, List<ParkingSpot>> availableParkingSpots = new HashMap<>();
	Map<Vehicle, ParkingSpot> vehicleToParkingSpotMap = new HashMap<>();

	ParkingSpot findParkingSpotForVehicle(Vehicle vehicle) {
		VehicleSize vehicleSize = vehicle.getVehicleSize();

		for (VehicleSize size : VehicleSize.values()) {
			if (size.ordinal() >= vehicleSize.ordinal()) {
				List<ParkingSpot> parkingSpotForVehicle = availableParkingSpots.get(size);
				for (ParkingSpot parkingSpot : parkingSpotForVehicle) {
					if (parkingSpot.isAvaliable()) return parkingSpot;
				}
			}
		}
		return null;
	}

	ParkingSpot parkVehicle(Vehicle vehicle) {
		ParkingSpot parkingSpot = findParkingSpotForVehicle(vehicle);

		if (parkingSpot != null) {
			parkingSpot.occupy(vehicle);
			vehicleToParkingSpotMap.put(vehicle, parkingSpot);
			availableParkingSpots.get(vehicle.getVehicleSize()).remove(parkingSpot);
			return parkingSpot;
		}
		return null;
	}

	void unparkVehicle(Vehicle vehicle) {
		ParkingSpot occupiedParkingSpot = vehicleToParkingSpotMap.remove(vehicle);
		if (occupiedParkingSpot != null) {
			occupiedParkingSpot.vacat();
			availableParkingSpots.get(vehicle.getVehicleSize()).add(occupiedParkingSpot);
		}
	}
}
