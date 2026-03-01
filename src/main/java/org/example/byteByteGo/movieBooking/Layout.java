package org.example.byteByteGo.movieBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Layout {
	private final int rows;
	private final int columns;
	private Map<Integer, Map<Integer, Seat>> seatMap;

	Layout(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.seatMap = new HashMap<>();
		initializeLayout();
	}

	private void initializeLayout() {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				addSeat(i, j, new Seat("SEAT-" + i + "*" + j, new NormalPricingStrategy()));
			}
		}
	}

	public void addSeat(int row, int column, Seat seat) {
		if (isRowColumnValid(row, column)) {
			seatMap.computeIfAbsent(row, k -> new HashMap<>());
			seatMap.get(row).put(column, seat);
		}
	}

	public Seat getSeatByPosition(int row, int column) {
		if (isRowColumnValid(row, column)) {
			if (seatMap.get(row) != null) {
				return seatMap.get(row).get(column);
			}
		}
		return null;
	}

	public List<Seat> getAllSeats() {
		List<Seat> seats = new ArrayList<>();
		for (Map<Integer, Seat> columnSeatMap : seatMap.values()) {
			seats.addAll(columnSeatMap.values());
		}
		return seats;
	}

	private boolean isRowColumnValid(int row, int column) {
		if (row > this.rows || column > this.columns) {
			System.out.println("Row & Column index out of bounds, cannot add seat");
			return false;
		}
		return true;
	}
}
