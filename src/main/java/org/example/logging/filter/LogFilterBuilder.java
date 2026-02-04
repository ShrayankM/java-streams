package org.example.logging.filter;

import org.example.logging.entities.Log;
import org.example.logging.entities.LogLevel;

import java.time.LocalDateTime;

public class LogFilterBuilder {
	private LocalDateTime startTimeStamp;
	private LocalDateTime endTimeStamp;
	private String keyword;
	private String service;
	private LogLevel logLevel;

	public LogFilterBuilder startTimeStamp(LocalDateTime startTimeStamp) {
		this.startTimeStamp = startTimeStamp;
		return this;
	}

	public LogFilterBuilder endTimeStamp(LocalDateTime endTimeStamp) {
		this.endTimeStamp = endTimeStamp;
		return this;
	}

	public LogFilterBuilder keyword(String keyword) {
		this.keyword = keyword;
		return this;
	}

	public LogFilterBuilder service(String service) {
		this.service = service;
		return this;
	}

	public LogFilterBuilder loglevel(LogLevel logLevel) {
		this.logLevel = logLevel;
		return this;
	}


	public LogFilter build() {
		return new LogFilter(this.startTimeStamp, this.endTimeStamp, this.keyword, this.service, this.logLevel);
	}
}
