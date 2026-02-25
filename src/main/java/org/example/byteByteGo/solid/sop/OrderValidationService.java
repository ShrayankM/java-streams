package org.example.byteByteGo.solid.sop;

public class OrderValidationService {
	public void validateOrder(String orderId, double amount) {
		// validate Order
		if (amount <= 0) {
			throw new IllegalArgumentException("Invalid amount");
		}
	}
}
