package org.example.practice.observer;

public class CurrentWeatherDisplay implements ObserverDisplay {
	private Double temperature;
	private Double humidity;
	private Double pressure;
	private WeatherData weatherData;

	public CurrentWeatherDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObservers(this);
	}

	@Override
	public void update() {
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
		this.pressure = weatherData.getPressure();
		display();
	}

	public void display() {
		System.out.println("Current Weather system [Temp = " + this.temperature + "-C] " +
				"Humidity {" + this.humidity + "%} " + "Pressure (" + this.pressure + "-bar)");
	}
}
