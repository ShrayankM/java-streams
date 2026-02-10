package org.example.oopDesign.guitarApplication;

import java.util.List;

public class FindGuitarTester {
	public static void main(String [] args) {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		InstrumentSpecification whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor",
								Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 10);

		List<Instrument> foundGuitarList = inventory.searchInstrument(whatErinLikes);
		if (!foundGuitarList.isEmpty()) {
			System.out.println("Guitars found");
			for (Instrument foundGuitar : foundGuitarList) {
				System.out.println("Serial no [" + foundGuitar.getSerialNumber() + "], Price = ["
						+ foundGuitar.getPrice() + "]");
			}
		} else {
			System.out.println("Sorry no matching guitar found");
		}

		InstrumentSpecification whatErinLikesMandolin = new MandolinSpec(Builder.GIBSON, "Fractocaster",
				Type.ACOUSTIC, Wood.CEDAR, Wood.CEDAR, Style.A);

		List<Instrument> foundMandolinList = inventory.searchInstrument(whatErinLikesMandolin);
		if (!foundMandolinList.isEmpty()) {
			System.out.println("Mandolins found");
			for (Instrument foundMandolin : foundMandolinList) {
				System.out.println("Serial no [" + foundMandolin.getSerialNumber() + "], Price = ["
						+ foundMandolin.getPrice() + "]");
			}
		} else {
			System.out.println("Sorry no matching guitar found");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		GuitarSpec guitarSpec = new GuitarSpec(Builder.FENDER, "Stratocastor",
				Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 12);

		inventory.addInstrument("S01", 90.99, guitarSpec);
		inventory.addInstrument("S02", 109.99, guitarSpec);

		MandolinSpec mandolinSpec = new MandolinSpec(Builder.GIBSON, "Fractocaster",
				Type.ACOUSTIC, Wood.CEDAR, Wood.CEDAR, Style.A);

		inventory.addInstrument("M01", 139.49, mandolinSpec);
		inventory.addInstrument("M02", 149.49, mandolinSpec);
	}
}
