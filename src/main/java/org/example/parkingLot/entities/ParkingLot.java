package org.example.parkingLot.entities;

import org.example.parkingLot.enums.Status;
import org.example.parkingLot.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private static ParkingLot parkingLot;
	private List<ParkingLevel> parkingLevelList;

	private ParkingLot() {};

	public static synchronized ParkingLot getParkingLot() {
		if (parkingLot == null) {
			parkingLot = new ParkingLot();
		}
		return parkingLot;
	}

	public void addParkingLevels(int levelsToAdd, int spotsPerLevel) {
		if (parkingLevelList == null) {
			parkingLevelList = new ArrayList<>();
			for (int i = 0; i < levelsToAdd; i++) {
				ParkingLevel parkingLevel = new ParkingLevel(spotsPerLevel);
				parkingLevelList.add(parkingLevel);
			}
		} else {
			for (int i = 0; i < levelsToAdd; i++) {
				ParkingLevel parkingLevel = new ParkingLevel(spotsPerLevel);
				parkingLevelList.add(parkingLevel);
			}
		}
	}

	public void entry(Vehicle vehicle) {
		for (ParkingLevel parkingLevel : parkingLevelList) {
			boolean isAvailable = parkingLevel.checkVacantSpot(vehicle);
			if (isAvailable) {
				ParkingSpot parkingSpot = parkingLevel.getFirstVacantParkingSpot(vehicle);
				parkingSpot.parkVehicle(vehicle);
				return;
			} else {
				System.out.println("Parking spot is not available");
			}
		}
	}

	public void exit(Vehicle vehicle) {
		for (ParkingLevel parkingLevel : parkingLevelList) {
			ParkingSpot getParkedVehicleSpot = parkingLevel.getParkedVehicleSpot(vehicle);
			if (getParkedVehicleSpot != null) {
				getParkedVehicleSpot.unparkVehicle();
				return;
			} else {
				System.out.println("This vehicle is no longer parked in the lot");
			}
		}
	}

	public void addParkingSpot(VehicleType vehicleType, int levelId) {
		ParkingLevel parkingLevel = parkingLevelList.get(levelId - 1);
		parkingLevel.addParkingSpot(vehicleType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("=== Parking Lot Status ===\n");

		if (parkingLevelList == null || parkingLevelList.isEmpty()) {
			sb.append("No parking levels available\n");
			return sb.toString();
		}

		for (int i = 0; i < parkingLevelList.size(); i++) {
			sb.append("\nLevel ").append(i + 1).append(":\n");
			ParkingLevel level = parkingLevelList.get(i);

			int vacantCount = 0;
			int occupiedCount = 0;

			for (int j = 0; j < level.getParkingSpotList().size(); j++) {
				ParkingSpot spot = level.getParkingSpotList().get(j);
				sb.append("  Spot ").append(j + 1).append(" [").append(spot.getVehicleType()).append("]: ");

				if (spot.getStatus() == Status.VACANT) {
					sb.append("VACANT\n");
					vacantCount++;
				} else {
					Vehicle vehicle = spot.getParkedVehicle();
					sb.append("OCCUPIED - Vehicle ID: ").append(vehicle.getId())
							.append(" (").append(vehicle.getVehicleType()).append(")\n");
					occupiedCount++;
				}
			}

			sb.append("  Summary - Vacant: ").append(vacantCount)
					.append(", Occupied: ").append(occupiedCount).append("\n");
		}

		return sb.toString();
	}
}
