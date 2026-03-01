package org.example.byteByteGo.movieBooking;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Screening {
	private final Screen screen;
	private final Movie movie;
	private final LocalDateTime startTime;

	public Screening(Screen screen, Movie movie, LocalDateTime startTime) {
		this.screen = screen;
		this.movie = movie;
		this.startTime = startTime;
	}

	public int getDurationInMinutes() {
		return movie.getDurationInMinutes();
	}

	@Override
	public String toString() {
		return movie.getTitle() + "#" + screen.getNumber() + "#";
	}
}
