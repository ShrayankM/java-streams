package org.example.byteByteGo.movieBooking;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Theater {
	private final String name;
	private final String location;
	private List<Screen> screenList;

	Theater(String name, String location) {
		this.name = name;
		this.location = location;
		this.screenList = new ArrayList<>();
	}

	public void addScreen(Screen screen) {
		if (Objects.nonNull(screen)) {
			this.screenList.add(screen);
		} else {
			System.out.println("Screen is null or empty");
		}
	}
}
