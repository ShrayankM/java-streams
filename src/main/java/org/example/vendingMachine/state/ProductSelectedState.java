package org.example.vendingMachine.state;

import org.example.vendingMachine.VendingMachineService;

public class ProductSelectedState extends VendingMachineState {
	public ProductSelectedState(VendingMachineService vendingMachineService) {
		super(vendingMachineService);
	}

	@Override
	public void selectProduct(String productId, int quantity) {
		System.out.println("Product is already selected");
	}

	@Override
	public void insertMoney(Double amount) {
		Double amountRequired = vendingMachineService.getProductById(vendingMachineService.getSelectedProductId()).getPrice() *
		vendingMachineService.getSelectedProductQuantity();

		if (amount.equals(amountRequired)) {
			vendingMachineService.setVendingMachineState(new DispenseProductState(vendingMachineService));
		} else {
			System.out.println("Please enter exact change");
		}
	}

	@Override
	public void dispenseProduct() {
		System.out.println("Please make payment first");
	}
}
