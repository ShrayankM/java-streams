package org.example.oopDesign.dougDoors;

public class DogDoorSimulator {
	public static void main(String [] args) {
		ginaAndFidoUseCase();
	}

	public static void ginaAndFidoUseCase() {
		Bark fidoBarkHungry = new Bark("Woof Woof");
		Bark fidoBarkWiny = new Bark("Whine");

		DogDoor dogDoor = new DogDoor(5);
		dogDoor.addUserDogBarksToDoor(fidoBarkHungry);
		dogDoor.addUserDogBarksToDoor(fidoBarkWiny);
//		RemoteControl remoteControl = new RemoteControl(dogDoor);

//		ginaAndFidoUseCaseRemote(remoteControl);
		ginaAndFidoUseCaseBarkRecognizer(dogDoor.getBarkRecognizer());
	}

	private static void ginaAndFidoUseCaseBarkRecognizer(BarkRecognizer barkRecognizer) {
		System.out.println("Fido barks to go outside");
		barkRecognizer.recognizeBark(new Bark("Whine"));

		System.out.println("Fido goes outside to do his business");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException interruptedException) {
			System.out.println("Exception occurred" + interruptedException);
		}

		System.out.println("Fido barks to be let back in again");
		barkRecognizer.recognizeBark(new Bark("Woof Woof"));

		System.out.println("Fido comes back inside");
	}

	private static void ginaAndFidoUseCaseRemote(RemoteControl remoteControl) {
		System.out.println("Fido barks to go outside");
		remoteControl.pressButton();

		System.out.println("Fido goes outside to do his business");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException interruptedException) {
			System.out.println("Exception occurred" + interruptedException);
		}

		System.out.println("Fido barks to be let back in again");
		System.out.println("Gina presses the remote button");
		remoteControl.pressButton();

		System.out.println("Fido comes back inside");

	}
}
