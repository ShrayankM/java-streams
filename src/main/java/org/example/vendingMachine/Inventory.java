package org.example.vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	private Map<String, Product> inventoryMap = new HashMap<>();

	public Product addOrUpdateProduct(String inventoryId, String name, int quantity, Double price) {
		if (inventoryMap.containsKey(inventoryId)) {
			// update inventory
			Product updateProduct = inventoryMap.get(inventoryId);
			updateProduct.setName(name);
			updateProduct.updateQuantity(quantity);

			inventoryMap.put(inventoryId, updateProduct);
			return updateProduct;
		} else {
			// add product
			Product product = new Product(inventoryId, name, quantity, price);
			inventoryMap.put(inventoryId, product);
			return product;
		}
	}

	public Product getProductById(String productId) {
		return inventoryMap.get(productId);
	}

	public void displayProductInventory() {
		System.out.println("------- Product ------- ");
		for (Map.Entry<String, Product> productEntry : inventoryMap.entrySet()) {
			System.out.println(" | " + productEntry.getKey() + " | " + productEntry.getValue() + "|");
		}
		System.out.println("------- ######### ------- ");
	}

	public boolean checkProductsAndQuantity(String id, int quantity) {
		if (!inventoryMap.containsKey(id)) {
			return false;
		}

		Product product = inventoryMap.get(id);
		return product.getQuantity().get() >= quantity;
	}

	public void dispenseProducts(String id, int quantity) {
		Product getProduct = inventoryMap.get(id);
		getProduct.updateQuantity(-quantity);
	}
}
