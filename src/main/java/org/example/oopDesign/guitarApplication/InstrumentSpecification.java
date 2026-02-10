package org.example.oopDesign.guitarApplication;

import lombok.Getter;

@Getter
public class InstrumentSpecification {
	protected Builder builder;
	protected String model;
	protected Type type;
	protected Wood backWood;
	protected Wood topWood;

	public InstrumentSpecification( Builder builder, String model, Type type,
			Wood backWood, Wood topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public boolean matches(InstrumentSpecification instrumentSpecification) {
		Builder builder = instrumentSpecification.getBuilder();
		if (builder != null && !builder.equals(this.getBuilder())) {
			return false;
		}

		String model = instrumentSpecification.getModel();
		if (model != null && !model.isEmpty() && !model.equals(this.getModel())) {
			return false;
		}

		Type type = instrumentSpecification.getType();
		if (type != null && !type.equals(this.getType())) {
			return false;
		}

		Wood backWood = instrumentSpecification.getBackWood();
		if (backWood != null && !backWood.equals(this.getBackWood())) {
			return false;
		}

		Wood topWood = instrumentSpecification.getTopWood();
		if (topWood != null && !topWood.equals(this.getTopWood())) {
			return false;
		}
		return true;
	}
}
