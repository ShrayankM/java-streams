package org.example.vendingMachine.state;

import org.example.vendingMachine.VendingMachineService;

public class IdleState extends VendingMachineState {
	public IdleState(VendingMachineService vendingMachineService) {
		super(vendingMachineService);
	}

	@Override
	public void selectProduct(String productId, int quantity) {
		boolean checkIfProductsAvailable = vendingMachineService.checkProductsAndQuantity(productId, quantity);
		if (!checkIfProductsAvailable) {
			System.out.println("Selected product for quantity is not available");
		}

		vendingMachineService.setSelectedProductId(productId);
		vendingMachineService.setSelectedProductQuantity(quantity);

		System.out.println("Product selection successful");
		vendingMachineService.setVendingMachineState(new ProductSelectedState(vendingMachineService));
	}

	@Override
	public void insertMoney(Double amount) {
		System.out.println("Please select product first");
	}

	@Override
	public void dispenseProduct() {
		System.out.println("Please select product first");
	}
}
