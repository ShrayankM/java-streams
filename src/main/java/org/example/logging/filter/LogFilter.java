package org.example.logging.filter;

import lombok.Getter;
import lombok.Setter;
import org.example.logging.entities.Log;
import org.example.logging.entities.LogLevel;

import java.time.LocalDateTime;

@Getter
@Setter
public class LogFilter {
	private LocalDateTime startTimeStamp;
	private LocalDateTime endTimeStamp;
	private LogLevel logLevel;
	private String service;
	private String keyword;

	public LogFilter(LocalDateTime startTimeStamp, LocalDateTime endTimeStamp, String keyword, String service,
			LogLevel logLevel) {
		this.startTimeStamp = startTimeStamp;
		this.endTimeStamp = endTimeStamp;
		this.keyword = keyword;
		this.service = service;
		this.logLevel = logLevel;
	}
}
