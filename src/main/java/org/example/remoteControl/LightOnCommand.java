package org.example.remoteControl;

public class LightOnCommand implements Command {
	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		this.light.turnOnLight();
	}

	@Override
	public void undo() {
		this.light.turnOffLight();
	}
}
