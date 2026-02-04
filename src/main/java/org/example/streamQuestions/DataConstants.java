package org.example.streamQuestions;

import java.time.LocalDate;
import java.util.List;

public class DataConstants {
	public static List<Employee> employees = List.of(
			new Employee("E1", "John", 180_000, "Technology", "john@email.com"),
			new Employee("E2", "John", 150_000, "Finance", "john@email.com"),
			new Employee("E3", "Alice", 80_000, "Technology", "alice@gmai.com"),
			new Employee("E4", "Alex", 95_000, "Product", "alex@gmail.com"),
			new Employee("E5", "Rick", 95_000, "Technology", "rick@gmail.com"),
			new Employee("E6", "Robert", 95_000, "Finance", "robert@gmail.com")
	);

	public static List<Transaction> transactionList = List.of(
			new Transaction("t1", TransactionStatus.SUCCESS),
			new Transaction("t2", TransactionStatus.SUCCESS),
			new Transaction("t3", TransactionStatus.FAILED),
			new Transaction("t4", TransactionStatus.SUCCESS),
			new Transaction("t5", TransactionStatus.FAILED),
			new Transaction("t6", TransactionStatus.FAILED),
			new Transaction("t7", TransactionStatus.FAILED)
	);

	public static List<User> userList = List.of(
			new User("u1", "john@gmail.com"),
			new User("u2", "rick@yahoo.com"),
			new User("u3", "alice@gmail.com"),
			new User("u4", "alex@gmail.com")
	);

	public static List<Order> orderList = List.of(
			new OrderBuilder()
					.orderId("0-191")
					.storeId("PST-1")
					.orderAmount(10.00)
					.orderStatus(OrderStatus.ACTIVE)
					.createdAt(LocalDate.now().minusDays(3))
					.user(userList.get(0))
					.build(),

			new OrderBuilder()
					.orderId("0-192")
					.storeId("PST-1")
					.orderAmount(20.00)
					.orderStatus(OrderStatus.INACTIVE)
					.createdAt(LocalDate.now().minusDays(2))
					.user(userList.get(0))
					.build(),

			new OrderBuilder()
					.orderId("0-193")
					.storeId("PST-2")
					.orderAmount(10.55)
					.orderStatus(OrderStatus.INACTIVE)
					.createdAt(LocalDate.now().minusDays(1))
					.user(userList.get(0))
					.build(),

			new OrderBuilder()
					.orderId("0-194")
					.storeId("PST-1")
					.orderAmount(9.55)
					.orderStatus(OrderStatus.ACTIVE)
					.createdAt(LocalDate.now().minusDays(2))
					.user(userList.get(1))
					.build(),

			new OrderBuilder()
					.orderId("0-194")
					.storeId("PST-2")
					.orderAmount(13.55)
					.orderStatus(OrderStatus.ACTIVE)
					.createdAt(LocalDate.now().minusDays(4))
					.user(userList.get(1))
					.build(),

			new OrderBuilder()
					.orderId("0-194")
					.storeId("PST-3")
					.orderAmount(13.55)
					.orderStatus(OrderStatus.ACTIVE)
					.createdAt(LocalDate.now().minusDays(6))
			.user(userList.get(2))
			.build(),

			new OrderBuilder()
					.orderId("0-194")
					.storeId("PST-4")
					.orderAmount(50.55)
					.orderStatus(OrderStatus.ACTIVE)
					.createdAt(LocalDate.now().minusDays(7))
			.user(userList.get(2))
			.build()
	);

	public static List<Product> productList = List.of(
			new Product("apple", 99.5, LocalDate.now().minusDays(1)),
			new Product("apple", 100.5, LocalDate.now()),
			new Product("orange", 95.5, LocalDate.now().minusDays(2)),
			new Product("orange", 100.5, LocalDate.now().minusDays(1)),
			new Product("orange", 105.5, LocalDate.now()),
			new Product("banana", 90.5,  LocalDate.now()),
			new Product("kiwi", 18.5,  LocalDate.now().minusDays(1)),
			new Product("kiwi", 20.5,  LocalDate.now()),
			new Product("peach", 85.5,  LocalDate.now())
	);

	public static List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
}
