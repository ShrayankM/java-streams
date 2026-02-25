package org.example.byteByteGo.solid.dip;

public class DBLogger implements Logger {
	@Override
	public void log(String message) {
		System.out.println("Logging to database = [" + message + "]");
	}
}
