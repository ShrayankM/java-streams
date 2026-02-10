package org.example.oopDesign.dougDoors;

public class Keypad {
	private DogDoor dogDoor;
	private Window window;
	private String passcode;

	public Keypad(DogDoor dogDoor, Window window) {
		this.dogDoor = dogDoor;
		this.window = window;
	}

	public void setPassCode(String passcode) {
		if (passcode.length() != 4) {
			System.out.println("Passcode should be of size 4");
		} else {
			this.passcode = passcode;
		}
	}

	private boolean verifyPasscode(String passcode) {
		if (this.passcode == null) {
			System.out.println("Please set a passcode first");
			return false;
		}
		return this.passcode.equals(passcode);
	}

	public void enterPasscode(String passcode) {
		if (verifyPasscode(passcode)) {
			if (this.dogDoor.isOpen()) {
				this.dogDoor.close();
			} else {
				this.dogDoor.open();
			}

			if (this.window.isOpen()) {
				this.window.close();
			} else {
				this.window.open();
			}
		} else {
			System.out.println("Passcode verification failed");
		}
	}
}
