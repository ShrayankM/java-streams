package org.example.vendingMachine;

public class VendingMachineDemo {
	public static void main(String [] args) {
		VendingMachineService vendingMachineService = VendingMachineService.getInstance();

		vendingMachineService.addOrUpdateProduct("chips-01", "potato-chips", 10, 5.00);
		vendingMachineService.addOrUpdateProduct("chips-01", "potato-chips", 2, 5.00);
		vendingMachineService.addOrUpdateProduct("beverage-02", "diet-coke", 15, 15.00);

		vendingMachineService.displayProductInventory();

		vendingMachineService.selectProduct("chips-01", 3);
		vendingMachineService.insertMoney(15.00);
		vendingMachineService.dispenseProducts();

		vendingMachineService.displayProductInventory();
	}
}
