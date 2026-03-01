package org.example.byteByteGo.movieBooking;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Ticket {
	private Screening screening;
	private Seat seat;
	private BigDecimal price;

	public Ticket(Screening screening, Seat seat) {
		this.screening = screening;
		this.seat = seat;
		this.price = this.seat.getSeatPrice();
	}
}
