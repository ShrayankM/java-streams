package org.example.oopDesign.guitarApplication;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Guitar> guitarList;

	public Inventory() {
		this.guitarList = new ArrayList<>();
	}

	public void addGuitar(String serialNumber, Double price, GuitarSpec guitarSpec) {
		Guitar guitar = new Guitar(serialNumber, price, guitarSpec);
		guitarList.add(guitar);
	}

	public Guitar getGuitar(String serialNumber) {
		for (Guitar guitar : guitarList) {
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	public List<Guitar> searchGuitar(GuitarSpec searchGuitarSpec) {
		List<Guitar> foundGuitars = new ArrayList<>();
		if (searchGuitarSpec == null) return null;

		for (Guitar existingGuitar : guitarList) {
			GuitarSpec existingGuitarSpec = existingGuitar.getGuitarSpec();
			if (existingGuitarSpec.compareGuitarSpec(searchGuitarSpec)) {
				foundGuitars.add(existingGuitar);
			}
		}
		return foundGuitars;
	}
}
