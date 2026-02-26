package org.example.byteByteGo.parkingSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingDemo {
	public static void main(String [] args) throws InterruptedException {
		Map<VehicleSize, List<ParkingSpot>> parkingSpots = new HashMap<>();
		parkingSpots.put(
				VehicleSize.COMPACT,
				List.of(
						new CompactSpot("P1"),
						new CompactSpot("P2")
						));

		parkingSpots.put(
				VehicleSize.REGULAR,
				List.of(
						new RegularSpot("P3"),
						new RegularSpot("P4")
				)
		);

		ParkingManager parkingManager = new ParkingManager(parkingSpots);
		ParkingFareCalculator parkingFareCalculator = new ParkingFareCalculator(
				List.of(new BaseFareStrategy(), new PeekHoursFareStrategy()));

		ParkingLot parkingLot = new ParkingLot(parkingManager, parkingFareCalculator);
		Ticket ticket =  parkingLot.entryVehicle(new Motorcycle("MH-14-KX-3265"));

		Thread.sleep(5000);

		parkingLot.exitVehicle(ticket);

//		Ticket truckTicket = parkingLot.entryVehicle(new Truck("MH-7-HJ-0099"));
//		System.out.println(truckTicket);
	}
}
