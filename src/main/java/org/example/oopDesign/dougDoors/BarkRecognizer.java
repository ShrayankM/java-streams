package org.example.oopDesign.dougDoors;

public class BarkRecognizer {
	private final DogDoor dogDoor;

	public BarkRecognizer(DogDoor dogDoor) {
		this.dogDoor = dogDoor;
	}

	private boolean verifyBark(Bark bark) {
		for (Bark recordedBark : this.dogDoor.getRecordedBarksForTheDoor()) {
			if (recordedBark.equals(bark)) {
				return true;
			}
		}
		return  false;
	}

	public void recognizeBark(Bark bark) {
		if (verifyBark(bark)) {
			System.out.println("Bark is verified, operating door");
			this.dogDoor.operateDoor();
		} else {
			System.out.println("Bark not recognized, dog not allowed to go outside");
		}
	}
}
