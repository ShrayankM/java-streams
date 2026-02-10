package org.example.oopDesign.guitarApplication;

import lombok.Getter;

@Getter
public class Instrument {
	protected String serialNumber;
	protected Double price;
	protected InstrumentType instrumentType;
	protected InstrumentSpecification instrumentSpecification;

	public Instrument(String serialNumber, Double price, InstrumentType instrumentType, InstrumentSpecification instrumentSpecification) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.instrumentType = instrumentType;
		this.instrumentSpecification = instrumentSpecification;
	}
}
