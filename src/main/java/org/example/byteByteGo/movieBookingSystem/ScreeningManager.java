package org.example.byteByteGo.movieBookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScreeningManager {
	private Map<Movie, List<Screening>> movieScreeningMap;
	private Map<Screening, List<Ticket>> ticketsByScreening;

	public void addScreeing(Movie movie, Screening screening) {}
	public List<Screening> getListOfScreeningForMovie(Movie movie) { return new ArrayList<>(); }
	public List<Ticket> getAvailableTicketsForScreening(Screening screening) { return new ArrayList<>(); }
	public List<Seat> getAvailableSeatsForScreening(Screening screening) { return new ArrayList<>(); }
}
