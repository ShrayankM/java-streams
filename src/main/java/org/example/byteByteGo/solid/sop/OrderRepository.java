package org.example.byteByteGo.solid.sop;

public class OrderRepository {

	public void createOrderInDB(String orderId) {
		// save to database
		System.out.println("Saving order " + orderId + " to DB");
	}
}
