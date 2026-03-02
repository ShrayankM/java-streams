package org.example.byteByteGo.vendingMachine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineDemo {
	public static void main(String[] args) {
		// Setup products
		Product cola = new Product("COLA", "Cola", new BigDecimal("1.50"));
		Product chips = new Product("CHIPS", "Chips", new BigDecimal("1.00"));

		// Setup racks and stock them
		Rack rack1 = new Rack("R1", cola);
		Rack rack2 = new Rack("R2", chips);

		Map<String, Rack> racks = new HashMap<>();
		racks.put("R1", rack1);
		racks.put("R2", rack2);

		VendingMachine vendingMachine = new VendingMachine(racks);

		// Stock the racks (Rack starts at 0, addProductToRack increments count)
		vendingMachine.getInventoryManager().addProductToRack("R1");
		vendingMachine.getInventoryManager().addProductToRack("R1");
		vendingMachine.getInventoryManager().addProductToRack("R2");

		// === Scenario 1: Successful purchase with change ===
		System.out.println("=== Buying a Cola with $2.00 ===");
		vendingMachine.insertMoney(new BigDecimal("2.00"));
		vendingMachine.selectProduct(cola);
		Product dispensed = vendingMachine.dispenseProduct();
		System.out.println("Dispensed: " + dispensed.getName());
		BigDecimal change = vendingMachine.returnChange();
		System.out.println("Change returned: " + change);

		// === Scenario 2: Exact change purchase ===
		System.out.println("\n=== Buying Chips with $1.00 ===");
		vendingMachine.insertMoney(new BigDecimal("1.00"));
		vendingMachine.selectProduct(chips);
		dispensed = vendingMachine.dispenseProduct();
		System.out.println("Dispensed: " + dispensed.getName());
		change = vendingMachine.returnChange();
		System.out.println("Change returned: " + change);

		// === Scenario 3: Insufficient funds ===
		System.out.println("\n=== Trying to buy Cola with $0.50 ===");
		vendingMachine.insertMoney(new BigDecimal("0.50"));
		vendingMachine.selectProduct(cola);

		// === Scenario 4: Out of stock ===
		System.out.println("\n=== Trying to buy Chips (out of stock) ===");
		vendingMachine.insertMoney(new BigDecimal("1.00"));
		vendingMachine.selectProduct(chips);
	}
}
