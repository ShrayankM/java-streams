package org.example.oopDesign.guitarApplication;

import lombok.Getter;

@Getter
public abstract class Instrument {
	protected String serialNumber;
	protected Double price;
	protected InstrumentSpecification instrumentSpecification;

	public Instrument(String serialNumber, Double price, InstrumentSpecification instrumentSpecification) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.instrumentSpecification = instrumentSpecification;
	}
}
