package org.example.remoteControl;

public class StereoOnCommand implements Command {
	private Stereo stereo;

	public StereoOnCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		this.stereo.on();
		this.stereo.setCd();
		this.stereo.setVolume(10);
	}

	@Override
	public void undo() {
		this.stereo.setVolume(3);
		this.stereo.unsetCd();
		this.stereo.off();
	}
}
