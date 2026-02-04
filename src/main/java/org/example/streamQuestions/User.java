package org.example.streamQuestions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {
	private String id;
	private String email;
	private List<Order> userOrders;

	public User(String id, String email) {
		this.id = id;
		this.email = email;
		this.userOrders = new ArrayList<>();
	}

	public void addOrder(Order order) {
		this.userOrders.add(order);
	}

	@Override
	public String toString() {
		return this.id + "," + this.email;
	}
}
