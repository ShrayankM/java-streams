package org.example.remoteControl;

public class RemoteControlTest {
	public static void main(String [] args) {
		RemoteControl remoteControl = new RemoteControl();
		Light light = new Light();
		Command lightOnCommand = new LightOnCommand(light);
		Command lightOffCommand = new LightOffCommand(light);

		remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
		remoteControl.pressOnButton(0);
		remoteControl.pressOffButton(0);

		GarageDoor garageDoor = new GarageDoor();
		Command garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
		Command garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);

		remoteControl.setCommand(1, garageDoorOpenCommand, garageDoorCloseCommand);
		remoteControl.pressOnButton(1);
		remoteControl.pressOffButton(1);

		Stereo stereo = new Stereo();
		Command stereoOnCommand = new StereoOnCommand(stereo);
		Command stereoOffCommand = new StereoOffCommand(stereo);

		remoteControl.setCommand(2, stereoOnCommand, stereoOffCommand);
		remoteControl.pressOnButton(2);
		remoteControl.pressOffButton(2);

		remoteControl.pressUndoButton();

		MacroCommand partyOnMacroCommand = new MacroCommand(new Command[]{lightOnCommand, stereoOnCommand});
		MacroCommand partyOffMacroCommand = new MacroCommand(new Command[]{lightOffCommand, stereoOffCommand});

		remoteControl.setCommand(3, partyOnMacroCommand, partyOffMacroCommand);
		remoteControl.pressOnButton(3);
		remoteControl.pressOffButton(3);

		remoteControl.pressUndoButton();

		System.out.println(remoteControl);
	}
}
