package org.example.remoteControl;

public class Stereo {
	private int volume;
	public void on() {
		System.out.println("Turning on the Stereo");
	}

	public void off() {
		System.out.println("Turning off the Stereo");
	}

	public void setCd() {
		System.out.println("Enabling CD-mode");
	}

	public void unsetCd() {
		System.out.println("Disabling CD-mode");
	}

	public void setRadio() {
		System.out.println("Enabling radio-mode");
	}

	public void setVolume(int volume) {
		this.volume = volume;
		System.out.println("Adjusting the volume of the stereo to = [" + this.volume + "]");
	}
}
