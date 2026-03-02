package org.example.byteByteGo.vendingMachine;

import java.math.BigDecimal;

public class ProductSelectedState implements VendingMachineState {
	@Override
	public void insertMoney(BigDecimal money, VendingMachine vendingMachine) {
		System.out.println("Money is already inserted preparing to dispense product");
	}

	@Override
	public void selectProduct(Product product, VendingMachine vendingMachine) {
		System.out.println("Product is already selected preparing to dispense product");
	}

	@Override
	public Product dispenseProduct(VendingMachine vendingMachine) {
		InventoryManager inventoryManager = vendingMachine.getInventoryManager();
		TransactionManager transactionManager = vendingMachine.getTransactionManager();
		PaymentProcessor paymentProcessor = vendingMachine.getPaymentProcessor();

		paymentProcessor.charge(transactionManager.getTotalAmount());
		Product product = inventoryManager.dispenseProductFromRack(transactionManager.getRack().getRackCode());
		vendingMachine.updateVendingMachineState(new ProductDispensedState());
		return product;
	}

	@Override
	public BigDecimal returnChange(VendingMachine vendingMachine) {
		return null;
	}
}
