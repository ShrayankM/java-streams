package org.example.byteByteGo.movieBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreeningManager {
	private Map<Movie, List<Screening>> movieScreeningMap;
	private Map<Screening, List<Ticket>> screeningTicketMap;

	public ScreeningManager() {
		this.movieScreeningMap = new HashMap<>();
		this.screeningTicketMap = new HashMap<>();
	}

	public void addMovieScreening(Movie movie, Screening screening) {
		movieScreeningMap.computeIfAbsent(movie, k -> new ArrayList<>());
		movieScreeningMap.get(movie).add(screening);
	}

	public void addScreeningTicket(Screening screening, Ticket ticket) {
		screeningTicketMap.computeIfAbsent(screening, k -> new ArrayList<>());
		screeningTicketMap.get(screening).add(ticket);
	}

	public List<Screening> getScreeningsForMovie(Movie movie) {
		if (movieScreeningMap.containsKey(movie)) {
			return movieScreeningMap.get(movie);
		}
		return new ArrayList<>();
	}

	public List<Ticket> getTicketsForScreening(Screening screening) {
		if (screeningTicketMap.containsKey(screening)) {
			return screeningTicketMap.get(screening);
		}
		return new ArrayList<>();
	}

	public List<Seat> getAvailableSeatsForScreening(Screening screening) {
		List<Seat> allSeatsForScreening = screening.getScreen().getLayout().getAllSeats();

		List<Seat> availableSeats = new ArrayList<>(allSeatsForScreening);
		List<Ticket> bookedTickets = getTicketsForScreening(screening);
		for (Ticket bookedTicket : bookedTickets) {
			availableSeats.remove(bookedTicket.getSeat());
		}

		return availableSeats;
	}
}
