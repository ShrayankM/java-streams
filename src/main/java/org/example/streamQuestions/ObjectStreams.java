package org.example.streamQuestions;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ObjectStreams {

	//	Remove duplicates from a list without using distinct().
	public <T> List<T> removeDuplicates(List<T> objectList) {
		return objectList.stream().collect(Collectors.toSet()).stream().toList();
	}

//	Given List<Employee>, return names of employees with salary > X.
	public List<String> employeeNamesWithSalary(List<Employee> employees, Integer salaryThreshold) {
		return employees.stream()
				.filter(employee -> employee.salary() > salaryThreshold)
				.map(Employee::name)
				.toList();
	}

//	Given List<Order>, group orders by storeId.
	public Map<String, List<Order>> groupOrdersByStoreId(List<Order> orders) {
		return orders.stream()
				.collect(Collectors.groupingBy(Order::getStoreId, Collectors.toList()));
	}

//	From List<Order>, calculate total revenue per store.
	public Map<String, Double> getRevenuePerStore(List<Order> orders) {
		return orders.stream()
				.collect(Collectors.groupingBy(Order::getStoreId,
						Collectors.summingDouble(Order::getOrderAmount)));
	}

//	Given List<Order>, return only ACTIVE orders sorted by createdAt.
	public List<Order> activeOrderSortedByCreatedAt(List<Order> orders) {
		return orders.stream()
				.filter(order -> order.getOrderStatus() == OrderStatus.ACTIVE)
				.sorted(Comparator.comparing(Order::getCreatedAt))
				.toList();
	}

//	Find top 3 highest-priced products from a product list.
	public List<Product> topThreeProducts(List<Product> productList) {
		return productList.stream()
				.sorted(Comparator.comparing(Product::price).reversed())
				.limit(3)
				.toList();
	}

//	Convert List<Employee> to Map<department, List<Employee>>.
	public Map<String, List<Employee>> getDepartmentEmployeeListMap(List<Employee> employees) {
		return employees.stream()
				.collect(Collectors.groupingBy(Employee::department, Collectors.toList()));
	}

//	Convert List<Employee> to Map<department, totalSalary>.
	public Map<String, Integer> getDepartmentSalaryMap(List<Employee> employees) {
		return employees.stream()
				.collect(Collectors.groupingBy(Employee::department, Collectors.summingInt(Employee::salary)));
	}

//	Sort a list of objects by multiple fields (salary desc, name asc).
	public List<Employee> sortEmployeeByNameAndSalary(List<Employee> employees) {
		Comparator<Employee> customEmployeeComparator = (a, b) -> {
			if (!a.name().equals(b.name())) {
				return a.name().compareTo(b.name());
			}
			return Integer.compare(a.salary(), b.salary());
		};

		return employees.stream()
				.sorted(customEmployeeComparator.reversed())
				.toList();
	}

//	Given List<Order>, group by storeId and return count of orders per store.
	public Map<String, Long> getCountOfOrdersPerStore(List<Order> orders) {
		return orders.stream()
				.collect(Collectors.groupingBy(Order::getStoreId, Collectors.counting()));
	}

//	From List<Order>, find the store with maximum revenue.
	public String findStoreIdWithMaximumRevenue(List<Order> orders) {
//		return orders.stream()
//				.collect(
//						Collectors.groupingBy(
//								Order::getStoreId, Collectors.summingDouble(Order::getOrderAmount))
//				)
//				.entrySet().stream()
//				.sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
//				.map(Entry::getKey)
//				.findFirst()
//				.orElseThrow();

		return orders.stream()
				.collect(
						Collectors.groupingBy(
								Order::getStoreId, Collectors.summingDouble(Order::getOrderAmount))
				)
				.entrySet().stream()
				.max(Comparator.comparingDouble(Entry::getValue))
				.map(Entry::getKey)
				.orElseThrow();
	}

//	Given List<Employee>, find the highest paid employee per department.
	public Map<String, Employee> highestPaidEmployeePerDepartment(List<Employee> employees) {
//		return employees.stream()
//				.collect(Collectors.toMap(
//						Employee::department,
//						employee -> employee,
//						(a, b) -> a.salary() >= b.salary() ? a : b));

		return employees.stream()
				.collect(Collectors.groupingBy(
						Employee::department,
						Collectors.collectingAndThen(
								Collectors.maxBy(
										Comparator.comparingInt(Employee::salary)), Optional::orElseThrow
						)
					)
				);
	}

//	“Given List<Transaction>, filter failed transactions and log skipped IDs.”
	// process only the success transactions
	public void filterAndProcessTransactions(List<Transaction> transactions) {
//		transactions.stream()
//				.filter(tx -> tx.status() == TransactionStatus.FAILED)
//				.forEach(tx -> System.out.println("failed tx = " + tx.id()));
//
//		transactions.stream()
//				.filter(tx -> tx.status() == TransactionStatus.SUCCESS)
//				.forEach(Transaction::processTransaction);

		Map<Boolean, List<Transaction>> partitioned =
				transactions.stream()
						.collect(Collectors.partitioningBy(
								tx -> tx.status() == TransactionStatus.SUCCESS
						));

		partitioned.get(false)
				.forEach(transaction -> System.out.println("Skipping failed transaction " + transaction.id()));

		partitioned.get(true)
				.forEach(Transaction::processTransaction);

	}

//	Merge two lists and remove duplicates based on custom field (id).

//	From List<User>, return emails of users who placed at least one order.
	public List<String> emailsOfCustomers(List<User> userList) {
		return userList.stream()
				.filter(user -> !user.getUserOrders().isEmpty())
				.map(User::getEmail)
				.toList();
	}

	public Map<User, Order> latestOrderPerUser(List<Order> orders) {
		return orders.stream()
				.collect(Collectors.groupingBy(
						Order::getUser,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Order::getCreatedAt)),
								Optional::orElseThrow
						)
				));
	}

//	From List<Employee>, remove duplicates based on email keeping highest salary.
	public List<Employee> removeDuplicatesOnEmail(List<Employee> employees) {
		return employees.stream()
				.collect(Collectors.toMap(
						Employee::email,
						emp -> emp,
						(a, b) -> a.salary() > b.salary() ? a : b
				)
				).values().stream().toList();
	}

//	Given List<Order>, find top N stores by revenue.
	public List<String> findTopNStoresByRevenue(List<Order> orders, int N) {
		Map<String, Double> storeRevenueMap = orders.stream()
				.collect(Collectors.groupingBy(
						Order::getStoreId,
						Collectors.summingDouble(Order::getOrderAmount)
				));

		return storeRevenueMap.entrySet().stream()
				.sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
				.map(Entry::getKey)
				.limit(N)
				.toList();
	}

//	Given List<Order>, return customers who placed orders on consecutive days
	public List<User> getCustomersWhoPlacedOrdersOnConsecutiveDays(List<Order> orders) {

		return orders.stream()
				.collect(Collectors.groupingBy(Order::getUser))
				.entrySet().stream()
				.filter(entry -> hasConsecutiveDays(entry.getValue()))
				.map(Entry::getKey)
				.toList();
	}

	private boolean hasConsecutiveDays(List<Order> orders) {
		List<LocalDate> sortedDates = orders.stream()
				.sorted(Comparator.comparing(Order::getCreatedAt))
				.map(Order::getCreatedAt)
				.distinct()
				.toList();

		for (int i = 0; i < sortedDates.size() - 1; i++) {
			if (sortedDates.get(i).plusDays(1).equals(sortedDates.get(i + 1))) {
				return true;
			}
		}
		return false;
	}

//	From List<Product>, find products whose price increased compared to previous day.
	public List<String> productsPriceIncreased(List<Product> productList) {
		Map<String, List<Product>> productMap = productList.stream()
				.collect(Collectors.groupingBy(Product::id, Collectors.toList()
						)
				);

		return productMap.entrySet().stream()
				.filter(entry -> hasPriceIncreasedToPreviousDay(entry.getValue()))
				.map(Entry::getKey)
				.toList();
	}

	private boolean hasPriceIncreasedToPreviousDay(List<Product> productList) {
		List<Product> sortedOnCreatedAt = productList.stream()
				.sorted(Comparator.comparing(Product::createdAt))
				.toList();

		for (int i = 0; i < sortedOnCreatedAt.size() - 1; i++) {
			if (sortedOnCreatedAt.get(i).price() < sortedOnCreatedAt.get(i + 1).price()) {
				return true;
			}
		}
		return false;
	}

//	Given a large list, process it in batches of size N using streams.
	public <T> void processLargeObjectList(List<T> objectList, int batchSize) {
		if (objectList == null || objectList.isEmpty() || batchSize <= 0) return;

		int size = objectList.size();
		int totalBatches = (size + batchSize - 1) / batchSize;
		System.out.println("Total batches = " + totalBatches);

		IntStream.range(0, totalBatches)
				.parallel()
				.forEach(i -> {
					int start = i * batchSize;
					int end = Math.min(start + batchSize, size);
					processList(objectList.subList(start, end), start, end);
				});
	}

	private <T> void processList(List<T> objectList, int start, int end) {
		System.out.println("Process from start = " + start + ", end = " + end);
	}
}
