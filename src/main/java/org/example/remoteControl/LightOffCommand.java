package org.example.remoteControl;

public class LightOffCommand implements Command {
	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		this.light.turnOffLight();
	}

	@Override
	public void undo() {
		this.light.turnOnLight();
	}
}
