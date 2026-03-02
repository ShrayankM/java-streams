package org.example.byteByteGo.vendingMachine;

import java.math.BigDecimal;

public class PaymentProcessor {
	private BigDecimal currentBalance;

	public PaymentProcessor() {
		this.currentBalance = new BigDecimal("0.0");
	}

	public void updateBalance(BigDecimal amount) {
		this.currentBalance = this.currentBalance.add(amount);
	}

	public BigDecimal charge(BigDecimal charge) {
		if (this.currentBalance.compareTo(charge) >= 0) {
			this.currentBalance = this.currentBalance.subtract(charge);
			return this.currentBalance;
		} else {
			System.out.println("Insufficient balance");
			return returnChange();
		}
	}

	public BigDecimal returnChange() {
		BigDecimal change = this.currentBalance;

		System.out.println("Returning customer change = " + change);
		this.currentBalance = new BigDecimal("0.0");
		return change;
	}
}
