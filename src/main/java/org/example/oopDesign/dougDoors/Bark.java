package org.example.oopDesign.dougDoors;

import lombok.Getter;

@Getter
public class Bark {
	private final String sound;

	public Bark(String sound) {
		this.sound = sound;
	}

	public boolean equals(Object bark) {
		if (bark instanceof Bark otherBark) {
			return this.getSound().equalsIgnoreCase(otherBark.getSound());
		}
		return false;
	}
}
