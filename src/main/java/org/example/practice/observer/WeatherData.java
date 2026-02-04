package org.example.practice.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	private Double temperature;
	private Double humidity;
	private Double pressure;

	private List<ObserverDisplay> observerList = new ArrayList<>();

	// Getters
	public Double getTemperature() { return this.temperature; }
	public Double getHumidity() { return this.humidity; }
	public Double getPressure() { return this.pressure; }

	// Setters
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	@Override
	public void registerObservers(ObserverDisplay observerDisplay) {
		this.observerList.add(observerDisplay);
	}

	@Override
	public void removeObserver(ObserverDisplay observerDisplay) {
		this.observerList.remove(observerDisplay);
	}

	@Override
	public void notifyObservers() {
		for (ObserverDisplay observer : observerList) {
			observer.update();
		}
	}

	public void measurementsChanged() {
		// our code
		notifyObservers();
	}
}
