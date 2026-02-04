package org.example.vendingMachine;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
	private String id;
	private String name;
	private AtomicInteger quantity;
	private Double price;

	public Product(String id, String name, int quantity, Double price) {
		this.id = id;
		this.name = name;
		this.quantity = new AtomicInteger(quantity);
		this.price = price;
	}

	// setters
	public void setName(String name) { this.name = name; }
	public void updateQuantity(int quantity) { this.quantity.addAndGet(quantity); }
	public void setPrice(Double price) { this.price = price; }

	// getters
	public String getId() { return this.id; }
	public String getName() { return this.name; }
	public AtomicInteger getQuantity() { return this.quantity; }
	public Double getPrice() { return this.price; }

	@Override
	public String toString() {
		return this.id + " | " + this.name + " | " + this.quantity + " | " + this.price;
	}
}
