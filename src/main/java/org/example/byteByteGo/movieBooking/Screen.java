package org.example.byteByteGo.movieBooking;

import lombok.Getter;

@Getter
public class Screen {
	private final String number;
	private final Layout layout;

	Screen(String number, Layout layout) {
		this.number = number;
		this.layout = layout;
	}
}
