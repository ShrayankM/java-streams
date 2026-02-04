package org.example.vendingMachine.state;

import org.example.vendingMachine.VendingMachineService;

public class DispenseProductState extends VendingMachineState {
	public DispenseProductState(VendingMachineService vendingMachineService) {
		super(vendingMachineService);
	}

	@Override
	public void selectProduct(String productId, int quantity) {
		System.out.println("Dispensing products, cannot select new products");
	}

	@Override
	public void insertMoney(Double amount) {
		System.out.println("Payment is already done, dispensing products");
	}

	@Override
	public void dispenseProduct() {
		vendingMachineService.dispenseProducts(vendingMachineService.getSelectedProductId(),
				vendingMachineService.getSelectedProductQuantity());
		vendingMachineService.setVendingMachineState(new IdleState(vendingMachineService));
	}
}
