package org.example.practice.observer;

public class WeatherStatisticsDisplay implements ObserverDisplay {
	private Double temperature;
	private Double humidity;
	private Double pressure;
	private WeatherData weatherData;

	public WeatherStatisticsDisplay(WeatherData weatherData) {
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

	void display() {
		System.out.println("Weather statistics for the day [Avg.Temp = " + this.temperature + "]" +
				" [Avg.Humidity = " + this.humidity + "] " + "[Avg.Pressure = " + this.pressure + "]");
	}
}
