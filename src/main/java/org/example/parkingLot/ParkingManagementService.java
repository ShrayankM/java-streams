package org.example.parkingLot;

import org.example.parkingLot.entities.ParkingLot;
import org.example.parkingLot.entities.Vehicle;
import org.example.parkingLot.enums.VehicleType;

public class ParkingManagementService {
	public static void main(String [] args) {
		ParkingLot parkingLot = ParkingLot.getParkingLot();

		parkingLot.addParkingLevels(1, 2);
		parkingLot.addParkingLevels(1, 2);

		parkingLot.addParkingSpot(VehicleType.MOTORCYCLE, 1);
		parkingLot.addParkingSpot(VehicleType.TRUCKS, 1);

		System.out.println(parkingLot);

		Vehicle Car1 = new Vehicle("V1", VehicleType.CAR);
		Vehicle Car2 = new Vehicle("V2", VehicleType.CAR);

		parkingLot.entry(Car1);
		parkingLot.entry(Car2);

		Vehicle Bike1 = new Vehicle("V3", VehicleType.MOTORCYCLE);
		Vehicle Truck1 = new Vehicle("V4", VehicleType.TRUCKS);

		parkingLot.entry(Bike1);
		parkingLot.entry(Truck1);

		System.out.println(parkingLot);

		parkingLot.exit(Bike1);
		Vehicle Bike2 = new Vehicle("V5", VehicleType.MOTORCYCLE);
		parkingLot.entry(Bike2);
	}


}
