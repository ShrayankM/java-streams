package org.example.byteByteGo.solid.dip;

public class StripePaymentGateway implements PaymentGateway {

	@Override
	public void charge(double amount) {
		System.out.println("Charging via Stripe: " + amount);
	}
}
