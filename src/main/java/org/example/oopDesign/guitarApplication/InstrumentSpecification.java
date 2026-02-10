package org.example.oopDesign.guitarApplication;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class InstrumentSpecification {
	protected Map<String, Property> properties;

	public InstrumentSpecification(Map<String, Property> properties) {
		if (properties == null) {
			this.properties = new HashMap<>();
		} else {
			this.properties = new HashMap<>(properties);
		}
	}

	public Property getProperty(String propertyName) {
		return this.properties.get(propertyName);
	}


	public boolean matches(InstrumentSpecification instrumentSpecification) {
		for(Map.Entry<String, Property> entry : this.getProperties().entrySet()) {
			String propertyName = entry.getKey();
			Property property = entry.getValue();

			if (property != null && !property.equals(instrumentSpecification.getProperty(propertyName))) {
				return false;
			}
		}
		return true;
	}
}
