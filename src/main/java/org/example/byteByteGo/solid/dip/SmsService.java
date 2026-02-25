package org.example.byteByteGo.solid.dip;

public class SmsService implements NotificationService {
	@Override
	public void sendConfirmation(String orderId) {
		System.out.println("Sending confirmation sms for: " + orderId);
	}
}
