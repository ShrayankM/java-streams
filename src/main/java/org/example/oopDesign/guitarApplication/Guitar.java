package org.example.oopDesign.guitarApplication;

import lombok.Getter;

@Getter
public class Guitar {
	private String serialNumber;
	private Double price;
	private GuitarSpec guitarSpec;

	public Guitar(String serialNumber, Double price, GuitarSpec guitarSpec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.guitarSpec = guitarSpec;
	}

}
