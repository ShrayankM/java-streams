package org.example.byteByteGo.solid.dip;

public class EmailService implements NotificationService {

	@Override
	public void sendConfirmation(String orderId) {
		System.out.println("Sending confirmation email for: " + orderId);
	}
}