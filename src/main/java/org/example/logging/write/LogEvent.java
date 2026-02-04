package org.example.logging.write;

import lombok.Getter;
import org.example.logging.entities.Destination;
import org.example.logging.entities.Log;

@Getter
public class LogEvent {
	private Log log;
	private Destination destination;

	public LogEvent(Log log, Destination destination) {
		this.log = log;
		this.destination = destination;
	}
}
