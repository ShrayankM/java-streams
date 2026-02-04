package org.example.logging;

import org.example.logging.entities.Destination;
import org.example.logging.entities.LogConfiguration;
import org.example.logging.entities.LogLevel;
import org.example.logging.filter.LogFilter;
import org.example.logging.filter.LogFilterBuilder;

public class LogDemo {
	public static void main(String [] args) {
		LogServiceImpl logService = LogServiceImpl.getInstance();

		logService.updateLogConfigurationLevel(LogLevel.DEBUG);
		logService.updateLogConfigurationDestination(Destination.FILE);

		logService.createLog("Oms-application is up", LogLevel.INFO, "OmsApp");
		logService.createLog("Create order request received", LogLevel.INFO, "OmsApp");
		logService.createLog("Mysql query for insert fired", LogLevel.INFO, "OmsApp");
		logService.createLog("DB - query INSERT .......", LogLevel.DEBUG, "OmsApp");
		logService.createLog("Query exception occurred, key already exists", LogLevel.ERROR, "OmsApp");

		LogFilter logFilter = new LogFilterBuilder().service("OmsApp").build();
//		logService.getLogs(logFilter);

		LogFilter logFilterDebug = new LogFilterBuilder()
				.service("OmsApp")
				.loglevel(LogLevel.DEBUG)
				.build();
		logService.getLogs(logFilterDebug);
	}
}
