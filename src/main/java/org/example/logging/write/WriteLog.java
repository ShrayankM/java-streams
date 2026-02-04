package org.example.logging.write;

import org.example.logging.entities.Destination;
import org.example.logging.entities.Log;

public interface WriteLog {
	boolean supports(Destination destination);
	void writeLogToDestination(LogEvent logEvent);
}
