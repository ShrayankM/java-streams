package org.example.traffic.entities;

import lombok.Setter;
import org.example.traffic.entities.enums.SignalIndicatorColor;
import org.example.traffic.entities.enums.SignalStatus;

@Setter
public class Signal {
	private String id;
	private SignalIndicatorColor signalIndicatorColor;
	private SignalStatus signalStatus;
	private int switchDurationTimeInSeconds;

	public Signal() {
		this.signalIndicatorColor = SignalIndicatorColor.YELLOW;
		this.signalStatus = SignalStatus.INACTIVE;
		this.switchDurationTimeInSeconds = 60;
	}
}
