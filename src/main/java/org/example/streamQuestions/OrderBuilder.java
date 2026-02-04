package org.example.streamQuestions;

import java.time.LocalDate;

public class OrderBuilder {
	private String orderId;
	private String storeId;
	private Double orderAmount;
	private OrderStatus orderStatus;
	private LocalDate createdAt;
	private User user;

	public OrderBuilder orderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public OrderBuilder storeId(String storeId) {
		this.storeId = storeId;
		return this;
	}

	public OrderBuilder orderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
		return this;
	}

	public OrderBuilder orderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
		return this;
	}

	public OrderBuilder createdAt(LocalDate createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public OrderBuilder user(User user) {
		this.user = user;
		return this;
	}

	public Order build() {
		return new Order(orderId, storeId, orderAmount, orderStatus, createdAt, user);
	}
}
