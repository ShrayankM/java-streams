package org.example.oopDesign.dougDoors;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Getter
public class DogDoor {
	private boolean isOpen;
	private final int closingTimeForDoorInSeconds;
	private final List<Bark> recordedBarksForTheDoor;
	private final BarkRecognizer barkRecognizer;

	public DogDoor(int closingTimeForDoorInSeconds) {
		this.isOpen = false;
		this.closingTimeForDoorInSeconds = closingTimeForDoorInSeconds;
		this.recordedBarksForTheDoor = new ArrayList<>();
		this.barkRecognizer = new BarkRecognizer(this);
	}

	public void addUserDogBarksToDoor(Bark bark) {
		this.recordedBarksForTheDoor.add(bark);
	}

	public void open() {
		this.isOpen = true;
		System.out.println("Opening door");

		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				close();
				timer.cancel();
			}
		}, this.closingTimeForDoorInSeconds * 1000L);
	}

	public void close() {
		this.isOpen = false;
		System.out.println("Closing door");
	}

	public void operateDoor() {
		if (this.isOpen()) {
			this.close();
		} else {
			this.open();
		}
	}
}
