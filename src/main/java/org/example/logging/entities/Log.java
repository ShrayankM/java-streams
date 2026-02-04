package org.example.logging.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Log {
	private String id;
	private String message;
	private LocalDateTime timeStamp;
	private LogLevel logLevel;
	private String service;
	private Destination destination;

	public Log(String message, LogLevel logLevel, String service, Destination destination) {
		this.id = UUID.randomUUID().toString().substring(0, 12);
		this.timeStamp = LocalDateTime.now();
		this.message = message;
		this.logLevel = logLevel;
		this.service = service;
	}
}
