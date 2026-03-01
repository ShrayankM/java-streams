package org.example.byteByteGo.movieBooking;

import lombok.Getter;

@Getter
public class Movie {
	private final String title;
	private final int durationInMinutes;

	public Movie(String title, int durationInMinutes) {
		this.title = title;
		this.durationInMinutes = durationInMinutes;
	}
}
