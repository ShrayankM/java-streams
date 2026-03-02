package org.example.byteByteGo.vendingMachine;

import java.math.BigDecimal;

public class ProductDispensedState implements VendingMachineState {
	@Override
	public void insertMoney(BigDecimal money, VendingMachine vendingMachine) {
		System.out.println("Product is already dispensed");
	}

	@Override
	public void selectProduct(Product product, VendingMachine vendingMachine) {
		System.out.println("Product is already dispensed");
	}

	@Override
	public Product dispenseProduct(VendingMachine vendingMachine) {
		System.out.println("Product is already dispensed");
		return null;
	}

	@Override
	public BigDecimal returnChange(VendingMachine vendingMachine) {
		PaymentProcessor paymentProcessor = vendingMachine.getPaymentProcessor();
		BigDecimal change =  paymentProcessor.returnChange();

		vendingMachine.updateVendingMachineState(new IdleState());
		return change;
	}
}
