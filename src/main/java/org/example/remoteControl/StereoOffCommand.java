package org.example.remoteControl;

public class StereoOffCommand implements Command {
	private Stereo stereo;

	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void undo() {
		this.stereo.on();
		this.stereo.setCd();
		this.stereo.setVolume(10);
	}

	@Override
	public void execute() {
		this.stereo.setVolume(3);
		this.stereo.unsetCd();
		this.stereo.off();
	}
}
