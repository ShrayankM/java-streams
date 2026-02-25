package org.example.byteByteGo.movieBookingSystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
	private LocalDateTime orderDate;
	private List<Ticket> ticketList;
	private BigDecimal orderPrice;

	public Order createOrder() { return null; }
	public void addTicketToOrder(Ticket ticket) {}
	public BigDecimal calculatePriceOfOrder() { return BigDecimal.ZERO; }
}
