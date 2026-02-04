package org.example.logging.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogConfiguration {
	private Destination destination;
	private LogLevel logLevel;

	public LogConfiguration() {
		this.destination = Destination.CONSOLE;
		this.logLevel = LogLevel.INFO;
	}


}
