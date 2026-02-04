package org.example.practice.observer;

public class WeatherDemo {
	public static void main(String [] args) {
		WeatherData weatherData = new WeatherData();

		CurrentWeatherDisplay currentWeatherDisplay = new CurrentWeatherDisplay(weatherData);
		WeatherStatisticsDisplay weatherStatisticsDisplay = new WeatherStatisticsDisplay(weatherData);

		weatherData.setTemperature(34.5);
		weatherData.setHumidity(67.0);
		weatherData.setPressure(94.55);

		weatherData.measurementsChanged();

		weatherData.removeObserver(currentWeatherDisplay);

		weatherData.setTemperature(36.9);
		weatherData.setHumidity(78.9);
		weatherData.setPressure(92.55);

		weatherData.measurementsChanged();
	}
}
