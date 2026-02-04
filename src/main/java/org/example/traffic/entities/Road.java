package org.example.traffic.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Road {
	private String id;
	private Signal signal;

	public Road() {
		this.signal = new Signal();
	}
}
