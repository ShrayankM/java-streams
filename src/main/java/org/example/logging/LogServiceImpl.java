package org.example.logging;

import org.example.logging.entities.Destination;
import org.example.logging.entities.Log;
import org.example.logging.entities.LogConfiguration;
import org.example.logging.entities.LogLevel;
import org.example.logging.filter.LogFilter;
import org.example.logging.write.ConsoleWriteLog;
import org.example.logging.write.FileWriteLog;
import org.example.logging.write.LogEvent;
import org.example.logging.write.WriteLog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LogServiceImpl {
	private static LogServiceImpl logService;
	private List<Log> logList = new ArrayList<>();
	private LogConfiguration logConfiguration;
	private List<WriteLog> logWriteObservers = new ArrayList<>();

	private LogServiceImpl() {
		this.logConfiguration = new LogConfiguration();
		this.logWriteObservers.add(new ConsoleWriteLog());
		this.logWriteObservers.add(new FileWriteLog());
	}

	public static synchronized LogServiceImpl getInstance() {
		if (logService == null) {
			logService = new LogServiceImpl();
		}
		return logService;
	}

	void createLog(String message, LogLevel logLevel, String service) {
		Log log = new Log(message, logLevel, service, logConfiguration.getDestination());

		if (logLevel == LogLevel.ERROR || logLevel == LogLevel.INFO) {
			logList.add(log);
		}

		if (logLevel == LogLevel.DEBUG && logConfiguration.getLogLevel() == LogLevel.DEBUG) {
			logList.add(log);
		}
		handleLogWriting(new LogEvent(log, logConfiguration.getDestination()));
	}

	private void handleLogWriting(LogEvent logEvent) {
		for (WriteLog writeLog : logWriteObservers) {
			if (writeLog.supports(logEvent.getDestination())) {
				writeLog.writeLogToDestination(logEvent);
			}
		}
	}

	void getLogs(LogFilter logFilter) {
		// display-logs
		Predicate<Log> predicate = log -> true;

		if (logFilter.getStartTimeStamp() == null && logFilter.getEndTimeStamp() == null) {
			// default 2 weeks
			logFilter.setStartTimeStamp(LocalDateTime.now().minusDays(14));
			logFilter.setEndTimeStamp(LocalDateTime.now());
		}

		// time-stamp filter
		predicate = predicate.and(
				log -> logFilter.getStartTimeStamp().isBefore(log.getTimeStamp())
				&& logFilter.getEndTimeStamp().isAfter(log.getTimeStamp())
		);

		// log-level filter
		if (logFilter.getLogLevel() != null) {
			predicate = predicate.and(
					log -> logFilter.getLogLevel().equals(log.getLogLevel())
			);
		}

		// service-level filter
		if (logFilter.getService() != null) {
			predicate = predicate.and(
					log -> logFilter.getService().equals(log.getService())
			);
		}

		// keyword filter
		if (logFilter.getKeyword() != null) {
			predicate = predicate.and(
					log -> Arrays.stream(log.getMessage().split(" ")).toList().contains(logFilter.getKeyword())
			);
		}

		List<Log> filteredLogs = logList.stream().filter(predicate).toList();

		viewLogs(filteredLogs);
	}

	private void viewLogs(List<Log> logs) {
		if (logs.isEmpty()) {
			System.out.println("No logs found.");
			return;
		}

		System.out.println("=".repeat(80));
		System.out.println("LOGS");
		System.out.println("=".repeat(80));

		for (Log log : logs) {
			System.out.println("ID: " + log.getId());
			System.out.println("Timestamp: " + log.getTimeStamp());
			System.out.println("Level: " + log.getLogLevel());
			System.out.println("Service: " + log.getService());
			System.out.println("Message: " + log.getMessage());
			System.out.println("-".repeat(80));
		}

		System.out.println("Total logs: " + logs.size());
		System.out.println("=".repeat(80));
	}

	public void updateLogConfigurationLevel(LogLevel logLevel) {
		this.logConfiguration.setLogLevel(logLevel);
	}

	public void updateLogConfigurationDestination(Destination destination) {
		this.logConfiguration.setDestination(destination);
	}
}
