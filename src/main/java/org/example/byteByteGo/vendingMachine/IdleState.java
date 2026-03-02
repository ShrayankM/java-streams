package org.example.byteByteGo.vendingMachine;

import java.math.BigDecimal;

public class IdleState implements VendingMachineState {
	@Override
	public void insertMoney(BigDecimal money, VendingMachine vendingMachine) {
		vendingMachine.resetVendingMachine();

		PaymentProcessor paymentProcessor = vendingMachine.getPaymentProcessor();
		paymentProcessor.updateBalance(money);

		TransactionManager transactionManager = vendingMachine.getTransactionManager();
		transactionManager.setTotalAmount(money);

		vendingMachine.updateVendingMachineState(new MoneyInsertedState());
	}

	@Override
	public void selectProduct(Product product, VendingMachine vendingMachine) {
		System.out.println("Please insert money before selecting product");
	}

	@Override
	public Product dispenseProduct(VendingMachine vendingMachine) {
		System.out.println("Please enter money & select product to dispense product");
		return null;
	}

	@Override
	public BigDecimal returnChange(VendingMachine vendingMachine) {
		return null;
	}
}
