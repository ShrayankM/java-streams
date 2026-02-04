package org.example.vendingMachine.state;

import org.example.vendingMachine.VendingMachineService;

public abstract class VendingMachineState {
	public VendingMachineService vendingMachineService;

	public VendingMachineState(VendingMachineService vendingMachineService) {
		this.vendingMachineService = vendingMachineService;
	}

	public abstract void selectProduct(String productId, int quantity);
	public abstract void insertMoney(Double amount);
	public abstract void dispenseProduct();
}
