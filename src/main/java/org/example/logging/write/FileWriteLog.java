package org.example.logging.write;

import org.example.logging.entities.Destination;
import org.example.logging.entities.Log;

public class FileWriteLog implements WriteLog {
	@Override
	public boolean supports(Destination destination) {
		return destination == Destination.FILE;
	}

	@Override
	public void writeLogToDestination(LogEvent logEvent) {
		System.out.println("Writing log to file - " + logEvent.getLog().getMessage());
	}
}
