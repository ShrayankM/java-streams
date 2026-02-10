package org.example.oopDesign.guitarApplication;

import lombok.Getter;

@Getter
public class GuitarSpec extends InstrumentSpecification {
	private Integer numOfStrings;

	public GuitarSpec( Builder builder, String model, Type type,
			Wood backWood, Wood topWood, Integer numOfStrings) {
		super(builder, model, type, backWood, topWood);
		this.numOfStrings = numOfStrings;
	}

	@Override
	public boolean matches(InstrumentSpecification instrumentSpecification) {
		if (!(instrumentSpecification instanceof GuitarSpec compareGuitarSpec)) {
			return super.matches(instrumentSpecification);
		}

		Integer numOfString = compareGuitarSpec.getNumOfStrings();
		if (numOfString != null && !numOfString.equals(this.getNumOfStrings())) {
			return false;
		}
		return super.matches(compareGuitarSpec);
	}
}
