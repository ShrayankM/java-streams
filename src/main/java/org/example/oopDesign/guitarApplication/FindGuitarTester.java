package org.example.oopDesign.guitarApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindGuitarTester {
	public static void main(String [] args) {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		Map<String, Property> guitarProperties = new HashMap<>();
		guitarProperties.put("Builder", Builder.FENDER);
		guitarProperties.put("Model", Model.Stratocastor);
		guitarProperties.put("Type", Type.ELECTRIC);
		guitarProperties.put("Wood", Wood.ALDER);
		guitarProperties.put("numOfString", NumOfStrings.TWELVE);

		InstrumentSpecification whatErinLikes = new InstrumentSpecification(guitarProperties);

		List<Instrument> foundInstrumentsForErin = inventory.searchInstrument(whatErinLikes);
		if (!foundInstrumentsForErin.isEmpty()) {
			for (Instrument foundInstrument : foundInstrumentsForErin) {
				System.out.println("Serial no [" + foundInstrument.getSerialNumber() + "], Price = ["
						+ foundInstrument.getPrice() + "], Type = {" + foundInstrument.getInstrumentType() + "}");
			}
		} else {
			System.out.println("Sorry no matching guitar found");
		}

		Map<String, Property> mandolinProperties = new HashMap<>();
		mandolinProperties.put("Builder", Builder.GIBSON);
		mandolinProperties.put("Model", Model.Fractocaster);
		mandolinProperties.put("Type", Type.ACOUSTIC);
		mandolinProperties.put("Wood", Wood.CEDAR);
		mandolinProperties.put("style", Style.F);


		InstrumentSpecification whatErinLikesMandolin = new InstrumentSpecification(mandolinProperties);

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
		Map<String, Property> guitarProperties = new HashMap<>();
		guitarProperties.put("Builder", Builder.FENDER);
		guitarProperties.put("Model", Model.Stratocastor);
		guitarProperties.put("Type", Type.ELECTRIC);
		guitarProperties.put("Wood", Wood.ALDER);
		guitarProperties.put("numOfString", NumOfStrings.TWELVE);

		InstrumentSpecification guitarSpecification = new InstrumentSpecification(guitarProperties);

		inventory.addInstrument("S01", 90.99, InstrumentType.GUITAR, guitarSpecification);
		inventory.addInstrument("S02", 109.99, InstrumentType.GUITAR, guitarSpecification);

		Map<String, Property> mandolinProperties = new HashMap<>();
		mandolinProperties.put("Builder", Builder.GIBSON);
		mandolinProperties.put("Model", Model.Fractocaster);
		mandolinProperties.put("Type", Type.ACOUSTIC);
		mandolinProperties.put("Wood", Wood.CEDAR);
		mandolinProperties.put("style", Style.F);

		InstrumentSpecification mandolinSpec = new InstrumentSpecification(mandolinProperties);

		inventory.addInstrument("M01", 139.49, InstrumentType.MANDOLIN, mandolinSpec);
		inventory.addInstrument("M02", 149.49, InstrumentType.MANDOLIN, mandolinSpec);
	}
}
