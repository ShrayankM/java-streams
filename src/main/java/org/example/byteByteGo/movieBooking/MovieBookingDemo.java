package org.example.byteByteGo.movieBooking;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class MovieBookingDemo {
	public static void main(String [] args) {
		MovieBookingSystem movieBookingSystem = new MovieBookingSystem();

		// pre-requisites
		Theater t1 = new Theater("PVR", "pune");
//		Theater t2 = new Theater("Inox", "pune");

		movieBookingSystem.addTheater(t1);
//		movieBookingSystem.addTheater(t2);

		Screen s1 = new Screen("S1", new Layout(3, 3));
		Screen s2 = new Screen("S2", new Layout(4, 4));

		t1.addScreen(s1);
		t1.addScreen(s2);

		Movie m1 = new Movie("Spider-man", 120);
		Movie m2 = new Movie("Rocky", 155);

		movieBookingSystem.addMovie(m1);
		movieBookingSystem.addMovie(m2);

		Screening spiderManOne = new Screening(s1, m1, LocalDateTime.now());
		Screening rockyOne = new Screening(s2, m2, LocalDateTime.now());

		movieBookingSystem.addScreening(m1, spiderManOne);
		movieBookingSystem.addScreening(m2, rockyOne);

		System.out.println(movieBookingSystem.getScreeningsForMovie(m1));
		System.out.println(movieBookingSystem.getScreeningsForMovie(m2));

		List<Seat> seatList = movieBookingSystem.getAvailableSeatsForScreening(spiderManOne);
		System.out.println(seatList);

		TicketOrder ticketOrder =  movieBookingSystem.bookTickets(spiderManOne, Arrays.asList(seatList.get(0), seatList.get(1)));
		System.out.println(ticketOrder);

		List<Seat> seatList2 = movieBookingSystem.getAvailableSeatsForScreening(spiderManOne);
		System.out.println(seatList2);
	}
}
