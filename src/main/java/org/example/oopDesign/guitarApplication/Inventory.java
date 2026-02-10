package org.example.oopDesign.guitarApplication;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Instrument> instrumentList;

	public Inventory() {
		this.instrumentList = new ArrayList<>();
	}

	public void addInstrument(String serialNumber, Double price, InstrumentSpecification instrumentSpecification) {
		Instrument instrument = null;

		if (instrumentSpecification instanceof GuitarSpec guitarSpec) {
			instrument = new Guitar(serialNumber, price, guitarSpec);
		}

		if (instrumentSpecification instanceof MandolinSpec mandolinSpec) {
			instrument = new Mandolin(serialNumber, price, mandolinSpec);
		}
		instrumentList.add(instrument);
	}

	private Instrument getInstrument(String serialNumber) {
		for (Instrument instrument : instrumentList) {
			if (instrument.getSerialNumber().equals(serialNumber)) {
				return instrument;
			}
		}
		return null;
	}

	public List<Instrument> searchInstrument(InstrumentSpecification instrumentSpecification) {
		List<Instrument> foundInstruments = new ArrayList<>();
		for (Instrument instrument : instrumentList) {
			if (instrument.getInstrumentSpecification().matches(instrumentSpecification)) {
				foundInstruments.add(instrument);
			}
		}
		return foundInstruments;
	}
}
