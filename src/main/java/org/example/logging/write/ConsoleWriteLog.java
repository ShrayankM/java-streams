package org.example.logging.write;

import org.example.logging.entities.Destination;
import org.example.logging.entities.Log;

public class ConsoleWriteLog implements WriteLog {
	@Override
	public boolean supports(Destination destination) {
		return destination == Destination.CONSOLE;
	}

	@Override
	public void writeLogToDestination(LogEvent logEvent) {
		System.out.println("Writing log to console - " + logEvent.getLog().getMessage());
	}
}
