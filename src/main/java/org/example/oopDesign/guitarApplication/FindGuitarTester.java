package org.example.oopDesign.guitarApplication;

import java.util.List;

public class FindGuitarTester {
	public static void main(String [] args) {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor",
				Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 12);

		List<Guitar> foundGuitarList = inventory.searchGuitar(whatErinLikes);
		if (!foundGuitarList.isEmpty()) {
			System.out.println("Guitars found");
			for (Guitar foundGuitar : foundGuitarList) {
				System.out.println("Serial no [" + foundGuitar.getSerialNumber() + "], Price = ["
						+ foundGuitar.getPrice() + "]");
			}
		} else {
			System.out.println("Sorry no matching guitar found");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		GuitarSpec guitarSpec = new GuitarSpec(Builder.FENDER, "Stratocastor",
				Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 12);

		inventory.addGuitar("S01", 90.99, guitarSpec);
		inventory.addGuitar("S02", 109.99, guitarSpec);
	}
}
