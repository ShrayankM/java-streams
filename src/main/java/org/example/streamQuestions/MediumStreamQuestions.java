package org.example.streamQuestions;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MediumStreamQuestions {
	public static void main(String [] args) {
		ObjectStreams objectStreams = new ObjectStreams();
		NumberStreams numberStreams = new NumberStreams();
		StringStreams stringStreams = new StringStreams();

		List<Order> orderList = List.of(
				new OrderBuilder()
						.orderId("0-192")
						.storeId("PST-1")
						.orderAmount(9.55)
						.orderStatus(OrderStatus.ACTIVE)
						.createdAt(LocalDate.now().minusDays(2))
						.build(),

				new OrderBuilder()
						.orderId("0-191")
						.storeId("PST-1")
						.orderAmount(9.55)
						.orderStatus(OrderStatus.INACTIVE)
						.createdAt(LocalDate.now().minusDays(1))
						.build(),

				new OrderBuilder()
						.orderId("0-193")
						.storeId("PST-2")
						.orderAmount(10.55)
						.orderStatus(OrderStatus.INACTIVE)
						.createdAt(LocalDate.now())
						.build(),

				new OrderBuilder()
						.orderId("0-194")
						.storeId("PST-1")
						.orderAmount(9.55)
						.orderStatus(OrderStatus.ACTIVE)
						.createdAt(LocalDate.now().minusDays(3))
						.build()
		);

		Map<String, List<Order>> storeIdOrderMap = objectStreams.groupOrdersByStoreId(orderList);
		storeIdOrderMap.forEach((key, value) -> System.out.println("Store-id = " + key + " Order = " + value));

		Map<String, Double> storeIdRevenueMap = objectStreams.getRevenuePerStore(orderList);
		storeIdRevenueMap.forEach((key, value) -> System.out.println("Store-id = " + key + " Revenue = " + value));

		List<Order> activeOrderSortedByCreatedAt = objectStreams.activeOrderSortedByCreatedAt(orderList);
		System.out.println("Sorted orders = " + activeOrderSortedByCreatedAt);


		List<Product> productList = DataConstants.productList;

		List<Product> topThreeProductsList = objectStreams.topThreeProducts(productList);
		System.out.println("Top 3 priced products = " + topThreeProductsList);


		List<Employee> employees = DataConstants.employees;

		Map<String, List<Employee>> departmentEmployeeList = objectStreams.getDepartmentEmployeeListMap(employees);
		departmentEmployeeList.forEach((key, value) -> System.out.println("Department = " +
				key + ", Employee-list = " + value));

		Map<String, Integer> departmentSalaryMap = objectStreams.getDepartmentSalaryMap(employees);
		departmentSalaryMap.forEach((key, value) -> System.out.println("Department = " +
				key + ", Total-salary = " + value));

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10);
		List<Integer> duplicates = numberStreams.findDuplicateIntegers(numbers);
		System.out.println("Duplicates = " + duplicates);

		List<String> strings = List.of("swim", "dance", "apple", "eye", "iron", "union", "test", "program");
		String longestString = stringStreams.getLongestStringFromString(strings);
		System.out.println("Longest string = " + longestString);

		List<Employee> sortedEmployees = objectStreams.sortEmployeeByNameAndSalary(employees);
		System.out.println("Sorted employees = " + sortedEmployees);
	}
}
