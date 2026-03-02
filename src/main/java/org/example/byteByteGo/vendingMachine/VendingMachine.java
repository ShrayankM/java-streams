package org.example.byteByteGo.vendingMachine;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
public class VendingMachine {
	private InventoryManager inventoryManager;
	private PaymentProcessor paymentProcessor;
	private TransactionManager transactionManager;
	private VendingMachineState vendingMachineState;

	public VendingMachine(Map<String, Rack> racks) {
		this.inventoryManager = new InventoryManager(racks);
		this.paymentProcessor = new PaymentProcessor();
		this.transactionManager = new TransactionManager();
		this.vendingMachineState = new IdleState();
	}

	public void resetVendingMachine() {
		this.paymentProcessor = new PaymentProcessor();
		this.transactionManager = new TransactionManager();
	}

	public void insertMoney(BigDecimal bigDecimal) {
		this.vendingMachineState.insertMoney(bigDecimal, this);
	}

	public void selectProduct(Product product) {
		this.vendingMachineState.selectProduct(product, this);
	}

	public Product dispenseProduct() {
		return this.vendingMachineState.dispenseProduct(this);
	}

	public BigDecimal returnChange() {
		return this.vendingMachineState.returnChange(this);
	}

	public void updateVendingMachineState(VendingMachineState vendingMachineState) {
		this.vendingMachineState = vendingMachineState;
	}
}
