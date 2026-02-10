package org.example.oopDesign.guitarApplication;

import lombok.Getter;

@Getter
public class GuitarSpec {
	private Builder builder;
	private String model;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	private Integer numOfStrings;

	public GuitarSpec( Builder builder, String model, Type type,
			Wood backWood, Wood topWood, Integer numOfStrings) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
		this.numOfStrings = numOfStrings;
	}

	public boolean compareGuitarSpec(GuitarSpec compareGuitarSpec) {
		Builder builder = compareGuitarSpec.getBuilder();
		if (builder != null && !builder.equals(this.getBuilder())) {
			return false;
		}

		String model = compareGuitarSpec.getModel();
		if (model != null && !model.isEmpty()
				&& !model.equals(this.getModel())) {
			return false;
		}

		Type type = compareGuitarSpec.getType();
		if (type != null && !type.equals(this.getType())) {
			return false;
		}

		Wood backWood = compareGuitarSpec.getBackWood();
		if (backWood != null
				&& !backWood.equals(this.getBackWood())) {
			return false;
		}

		Wood topWood = compareGuitarSpec.getTopWood();
		if (topWood != null &&
				!topWood.equals(this.getTopWood())) {
			return false;
		}

		Integer numOfString = compareGuitarSpec.getNumOfStrings();
		if (numOfString != null && !numOfString.equals(this.getNumOfStrings())) {
			return false;
		}
		return true;
	}
}
