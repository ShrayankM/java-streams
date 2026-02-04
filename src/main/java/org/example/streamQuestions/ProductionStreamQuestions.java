package org.example.streamQuestions;

import java.util.List;

public class ProductionStreamQuestions {
	public static void main(String [] args) {
		ObjectStreams objectStreams = new ObjectStreams();

		List<Employee> employeeList = DataConstants.employees;

		List<Employee> distinctEmailEmployees = objectStreams.removeDuplicatesOnEmail(employeeList);
		System.out.println(distinctEmailEmployees);

		List<Order> orderList = DataConstants.orderList;
		List<String> topRevenueStoresFromOrder = objectStreams.findTopNStoresByRevenue(orderList, 2);
		System.out.println("Top 2 stores = " + topRevenueStoresFromOrder);

		List<User> userWhoPlacedOrderOnConsecutiveDays = objectStreams.getCustomersWhoPlacedOrdersOnConsecutiveDays(orderList);
		System.out.println("Customer for consecutive days = " + userWhoPlacedOrderOnConsecutiveDays);

		List<String> productIds = objectStreams.productsPriceIncreased(DataConstants.productList);
		System.out.println("Product ids where price changed on consecutive days = " + productIds);

		objectStreams.processLargeObjectList(DataConstants.numbers, 2);
	}
}
