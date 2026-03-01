package org.example.byteByteGo.movieBooking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieBookingSystem {
	private List<Theater> theaterList;
	private List<Movie> movieList;
	private ScreeningManager screeningManager;

	public MovieBookingSystem() {
		this.theaterList = new ArrayList<>();
		this.movieList = new ArrayList<>();
		this.screeningManager = new ScreeningManager();
	}

	public void addMovie(Movie movie) {
		this.movieList.add(movie);
	}

	public void addTheater(Theater theater) {
		this.theaterList.add(theater);
	}

	public void addScreening(Movie movie, Screening screening) {
		this.screeningManager.addMovieScreening(movie, screening);
	}

	public TicketOrder bookTickets(Screening screening, List<Seat> seats) {
		TicketOrder ticketOrder = new TicketOrder(LocalDateTime.now());

		for (Seat seat : seats) {
			Ticket ticket = new Ticket(screening, seat);
			ticketOrder.addTicket(ticket);
			this.screeningManager.addScreeningTicket(screening, ticket);
		}
		return ticketOrder;
	}

	public List<Screening> getScreeningsForMovie(Movie movie) {
		return this.screeningManager.getScreeningsForMovie(movie);
	}

	public List<Seat> getAvailableSeatsForScreening(Screening screening) {
		return this.screeningManager.getAvailableSeatsForScreening(screening);
	}

	public List<Ticket> getTicketsForScreening(Screening screening) {
		return this.screeningManager.getTicketsForScreening(screening);
	}
}
