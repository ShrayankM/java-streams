package org.example.streamQuestions;

import java.util.List;
import java.util.Map;

public class MediumHardStreamQuestions {
	public static void main(String [] args) {
		ObjectStreams objectStreams = new ObjectStreams();
		List<Order> orderList = DataConstants.orderList;

		Map<String, Long> orderCountPerStore = objectStreams.getCountOfOrdersPerStore(orderList);
		orderCountPerStore.forEach((key, value) -> System.out.println("Store-id = " + key + ", Order-count = " + value));

		String storeIdWithMaxRevenue = objectStreams.findStoreIdWithMaximumRevenue(orderList);
		System.out.println("Store with maximum revenue = " + storeIdWithMaxRevenue);

		List<Employee> employees = DataConstants.employees;
		Map<String, Employee> highestPaidEmployeePerDepartment = objectStreams.highestPaidEmployeePerDepartment(employees);
		highestPaidEmployeePerDepartment.forEach((key, value) -> System.out.println("Department = " + key + ", Employee = " + value));

		List<Transaction> transactions = DataConstants.transactionList;
		objectStreams.filterAndProcessTransactions(transactions);

		List<User> userList = DataConstants.userList;
		userList.get(0).addOrder(orderList.get(0));
		userList.get(0).addOrder(orderList.get(1));
		userList.get(1).addOrder(orderList.get(2));

		List<String> emailsOfCustomer = objectStreams.emailsOfCustomers(userList);
		System.out.println("Emails of customer = " + emailsOfCustomer);

	}
}
