package org.example.byteByteGo.parkingSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
	private Map<VehicleSize, List<ParkingSpot>> parkingSpots;
	private Map<Vehicle, ParkingSpot> vehicleToParkingSpotMap;

	public ParkingManager(Map<VehicleSize, List<ParkingSpot>> parkingSpots) {
		this.parkingSpots = parkingSpots;
		this.vehicleToParkingSpotMap = new HashMap<>();
	}

	public ParkingSpot findParkingSpot(Vehicle vehicle) {
		VehicleSize vehicleSize = vehicle.getVehicleSize();

		for (VehicleSize size : VehicleSize.values()) {
			if (size.ordinal() >= vehicleSize.ordinal()) {
				List<ParkingSpot> parkingSpotList = parkingSpots.get(size);

				for (ParkingSpot parkingSpot : parkingSpotList) {
					if (parkingSpot.isParkingSpotVacant()) return parkingSpot;
				}
			}
		}
		return null;
	}

	public ParkingSpot parkVehicle(Vehicle vehicle) {
		ParkingSpot parkingSpot = findParkingSpot(vehicle);
		if (parkingSpot != null) {
			parkingSpot.occupySpot(vehicle);
			this.vehicleToParkingSpotMap.put(vehicle, parkingSpot);
		}
		return parkingSpot;
	}

	public void unparkVehicle(Vehicle vehicle) {
		ParkingSpot parkedParkingSpot = this.vehicleToParkingSpotMap.get(vehicle);
		parkedParkingSpot.vacatSpot();
	}
}
