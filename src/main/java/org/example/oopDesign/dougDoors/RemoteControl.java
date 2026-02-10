package org.example.oopDesign.dougDoors;


public class RemoteControl {
	private final DogDoor dogDoor;

	public RemoteControl(DogDoor dogDoor) {
		this.dogDoor = dogDoor;
	}

	public void pressButton() {
		System.out.println("Pressing the remote control button");
		this.dogDoor.operateDoor();
	}
}
