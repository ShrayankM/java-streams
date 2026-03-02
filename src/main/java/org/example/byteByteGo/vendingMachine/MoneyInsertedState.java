package org.example.byteByteGo.vendingMachine;

import java.math.BigDecimal;

public class MoneyInsertedState implements VendingMachineState {
	@Override
	public void insertMoney(BigDecimal money, VendingMachine vendingMachine) {
		System.out.println("Money is already inserted, please select a product");
	}

	@Override
	public void selectProduct(Product product, VendingMachine vendingMachine) {
		InventoryManager inventoryManager = vendingMachine.getInventoryManager();

		if (!inventoryManager.isProductInStock(product)) {
			System.out.println("Product selected is out of stock, please select another product");
			return;
		}

		String rackCodeForProduct = inventoryManager.getRackCodeForProduct(product);
		Rack rack = inventoryManager.getRackFromRackCode(rackCodeForProduct);

		TransactionManager transactionManager = vendingMachine.getTransactionManager();

		if (transactionManager.getTotalAmount().compareTo(product.getPrice()) >= 0) {
			transactionManager.setSelectedProduct(product);
			transactionManager.setTotalAmount(product.getPrice());
			transactionManager.setRack(rack);

			vendingMachine.updateVendingMachineState(new ProductSelectedState());
		} else {
			System.out.println("Insufficient funds entered, please add more money");
			PaymentProcessor paymentProcessor = vendingMachine.getPaymentProcessor();
			paymentProcessor.returnChange();
			vendingMachine.updateVendingMachineState(new IdleState());
		}
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
