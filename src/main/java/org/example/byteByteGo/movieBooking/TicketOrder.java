package org.example.byteByteGo.movieBooking;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class TicketOrder {
	private List<Ticket> ticketList;
	private final LocalDateTime orderDate;

	public TicketOrder(LocalDateTime orderDate) {
		this.orderDate = orderDate;
		this.ticketList = new ArrayList<>();
	}

	public void addTicket(Ticket ticket) {
		if (Objects.nonNull(ticket)) {
			this.ticketList.add(ticket);
		} else {
			System.out.println("Ticket is null, cannot add to order");
		}
	}

	public BigDecimal calculatePriceOfOrder() {
		BigDecimal orderPrice = new BigDecimal("0.0");
		for (Ticket ticket : ticketList) {
			orderPrice = orderPrice.add(ticket.getPrice());
		}
		return orderPrice;
	}

	@Override
	public String toString() {
		return orderDate + "-" + "Price = [" + this.calculatePriceOfOrder() + "]";
	}
}
