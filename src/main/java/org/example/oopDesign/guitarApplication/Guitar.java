package org.example.oopDesign.guitarApplication;

import lombok.Getter;

@Getter
public class Guitar extends Instrument {
	public Guitar(String serialNumber, Double price, GuitarSpec guitarSpec) {
		super(serialNumber, price, guitarSpec);
	}
}
