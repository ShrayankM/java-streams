package org.example.byteByteGo.movieBookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Layout {
	private int rows;
	private int columns;
	private Map<String, Seat> seatByNumber;
	private Map<Integer, Map<Integer, Seat>> seatByPositon;

	public void addSeat(int row, int colunm, Seat seat) {}
	public Seat getSeatByNumber(String seatNumber) { return null; }
	public Seat getSeatByPosition(int row, int column) { return null; }
	public List<Seat> getAllSeats() { return new ArrayList<>(); }
}
