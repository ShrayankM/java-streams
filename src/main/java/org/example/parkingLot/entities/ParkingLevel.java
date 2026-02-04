package org.example.parkingLot.entities;

import org.example.parkingLot.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
	private int vacantSpotsCount;
	private List<ParkingSpot> parkingSpotList;

	public ParkingLevel(int parkingSpots) {
		parkingSpotList = new ArrayList<>();
		for (int i = 0; i < parkingSpots; i++) {
			ParkingSpot parkingSpot = new ParkingSpot();
			parkingSpotList.add(parkingSpot);
		}
		this.vacantSpotsCount = parkingSpots;
	}

	public void addParkingSpot(VehicleType vehicleType) {
		ParkingSpot parkingSpot = new ParkingSpot(vehicleType);
		parkingSpotList.add(parkingSpot);
		this.vacantSpotsCount++;
	}

	public ParkingSpot getFirstVacantParkingSpot(Vehicle vehicle) {
		for (ParkingSpot parkingSpotOnLevel : parkingSpotList) {
			if (parkingSpotOnLevel.isVacant() && parkingSpotOnLevel.matchesVehicleType(vehicle.getVehicleType())) {
				return parkingSpotOnLevel;
			}
		}
		return null;
	}

	public ParkingSpot findOptimalParkingSpot(Vehicle vehicle) {
		if (vacantSpotsCount == 0) {
			return null;
		}
		return null;
	}

	public ParkingSpot getParkedVehicleSpot(Vehicle vehicle) {
		for (ParkingSpot parkingSpotOnLevel : parkingSpotList) {
			if (!parkingSpotOnLevel.isVacant() &&
					vehicle.getId().equals(parkingSpotOnLevel.getParkedVehicle().getId())) {
				return parkingSpotOnLevel;
			}
		}
		return null;
	}

	public boolean checkVacantSpot(Vehicle vehicle) {
			for (ParkingSpot parkingSpotOnLevel : parkingSpotList) {
				if (parkingSpotOnLevel.isVacant() && parkingSpotOnLevel.matchesVehicleType(vehicle.getVehicleType())) {
					return true;
				}
			}
		return false;
	}

	public List<ParkingSpot> getParkingSpotList() {
		return parkingSpotList;
	}
}
