package org.example.vendingMachine;

import org.example.vendingMachine.state.IdleState;
import org.example.vendingMachine.state.VendingMachineState;

public class VendingMachineService {
	private VendingMachineState vendingMachineState;
	private static VendingMachineService vendingMachineService;
	private Inventory inventory;
	private String selectedProductId;
	private int selectedProductQuantity;

	private VendingMachineService() {
		this.vendingMachineState = new IdleState(this);
		this.inventory = new Inventory();
	}

	public static synchronized VendingMachineService getInstance() {
		if (vendingMachineService == null) {
			vendingMachineService = new VendingMachineService();
		}
		return vendingMachineService;
	}

	public void setSelectedProductId(String id) { this.selectedProductId = id; }
	public void setSelectedProductQuantity(int quantity) { this.selectedProductQuantity = quantity; }

	public String getSelectedProductId() { return this.selectedProductId; }
	public int getSelectedProductQuantity() { return this.selectedProductQuantity; }

	public Product getProductById(String id) {
		return inventory.getProductById(id);
	}

	public Product addOrUpdateProduct(String inventoryId, String name, int quantity, Double price) {
		return inventory.addOrUpdateProduct(inventoryId, name, quantity, price);
	}

	public void displayProductInventory() {
		inventory.displayProductInventory();
	}

	public boolean checkProductsAndQuantity(String id, int quantity) {
		return inventory.checkProductsAndQuantity(id, quantity);
	}

	public void setVendingMachineState(VendingMachineState vendingMachineState) {
		this.vendingMachineState = vendingMachineState;
	}

	public void dispenseProducts(String id, int quantity) {
		inventory.dispenseProducts(id, quantity);
	}

	public void selectProduct(String id, int quantity) {
		this.vendingMachineState.selectProduct(id, quantity);
	}

	public void insertMoney(Double amount) {
		this.vendingMachineState.insertMoney(amount);
	}

	public void dispenseProducts() {
		this.vendingMachineState.dispenseProduct();
	}
}
