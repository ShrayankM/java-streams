package org.example.oopDesign.guitarApplication;

import lombok.Getter;

@Getter
public class MandolinSpec extends InstrumentSpecification {
	private Style style;

	public MandolinSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, Style style) {
		super(builder, model, type, backWood, topWood);
		this.style = style;
	}

	@Override
	public boolean matches(InstrumentSpecification instrumentSpecification) {
		if (!(instrumentSpecification instanceof MandolinSpec compareMandolinSpec)) {
			return super.matches(instrumentSpecification);
		}

		Style style = compareMandolinSpec.getStyle();
		if (style != null && !style.equals(this.getStyle())) {
			return false;
		}
		return super.matches(compareMandolinSpec);
	}
}
