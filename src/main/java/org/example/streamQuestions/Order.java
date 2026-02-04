package org.example.streamQuestions;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Order {
	private String orderId;
	private String storeId;
	private Double orderAmount;
	private OrderStatus orderStatus;
	private LocalDate createdAt;
	private User user;

	public Order(String orderId, String storeId, Double orderAmount, OrderStatus orderStatus, LocalDate createdAt, User user) {
		this.orderId = orderId;
		this.storeId = storeId;
		this.orderAmount = orderAmount;
		this.orderStatus = orderStatus;
		this.createdAt = createdAt;
		this.user = user;
	}

	@Override
	public String toString() {
		return this.orderId + ", " + this.createdAt;
	}
}
