package org.example.oopDesign.guitarApplication;

import java.util.List;

public class FindGuitarTester {
	public static void main(String [] args) {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		InstrumentSpecification whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor",
								Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 12);

		List<Instrument> foundInstrumentsForErin = inventory.searchInstrument(whatErinLikes);
		if (!foundInstrumentsForErin.isEmpty()) {
			for (Instrument foundInstrument : foundInstrumentsForErin) {
				System.out.println("Serial no [" + foundInstrument.getSerialNumber() + "], Price = ["
						+ foundInstrument.getPrice() + "], Type = {" + foundInstrument.getInstrumentType() + "}");
			}
		} else {
			System.out.println("Sorry no matching guitar found");
		}

		InstrumentSpecification whatErinLikesMandolin = new MandolinSpec(Builder.GIBSON, "Fractocaster",
				Type.ACOUSTIC, Wood.CEDAR, Wood.CEDAR, Style.A);

		List<Instrument> foundInstrumentsForErinAgain = inventory.searchInstrument(whatErinLikesMandolin);
		if (!foundInstrumentsForErinAgain.isEmpty()) {
			for (Instrument foundInstrument : foundInstrumentsForErinAgain) {
				System.out.println("Serial no [" + foundInstrument.getSerialNumber() + "], Price = ["
						+ foundInstrument.getPrice() + "], Type = {" + foundInstrument.getInstrumentType() + "}");
			}
		} else {
			System.out.println("Sorry no matching guitar found");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		GuitarSpec guitarSpec = new GuitarSpec(Builder.FENDER, "Stratocastor",
				Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 12);

		inventory.addInstrument("S01", 90.99, InstrumentType.GUITAR, guitarSpec);
		inventory.addInstrument("S02", 109.99, InstrumentType.GUITAR, guitarSpec);

		MandolinSpec mandolinSpec = new MandolinSpec(Builder.GIBSON, "Fractocaster",
				Type.ACOUSTIC, Wood.CEDAR, Wood.CEDAR, Style.A);

		inventory.addInstrument("M01", 139.49, InstrumentType.MANDOLIN, mandolinSpec);
		inventory.addInstrument("M02", 149.49, InstrumentType.MANDOLIN, mandolinSpec);
	}
}
