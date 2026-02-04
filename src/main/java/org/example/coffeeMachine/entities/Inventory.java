package org.example.coffeeMachine.entities;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	private Map<IngredientType, Integer> inventoryMap = new HashMap<>();

	public void addInventory(IngredientType ingredientType, int quantity) {
		int currentIngredientCount = 0;
		if (inventoryMap.containsKey(ingredientType)) {
			currentIngredientCount = inventoryMap.get(ingredientType);
		}
		inventoryMap.put(ingredientType, currentIngredientCount + quantity);
	}

	public void reduceInventory(IngredientType ingredientType, int quantity) {
		if (inventoryMap.containsKey(ingredientType)) {
			int currentIngredientCount = inventoryMap.get(ingredientType);

			if (currentIngredientCount >= quantity) {
				inventoryMap.put(ingredientType, currentIngredientCount - quantity);
			} else {
				System.out.println("Insufficient inventory present");
			}

		} else {
			System.out.println("Inventory not present in the system");
		}
	}

	public boolean checkInventoryQuantity(Map<IngredientType, Integer> requiredInventory) {
		for (Map.Entry<IngredientType, Integer> entry : requiredInventory.entrySet()) {
			IngredientType key = entry.getKey();
			Integer requiredQuantity = entry.getValue();

			if (!inventoryMap.containsKey(key) || (inventoryMap.get(key) < requiredQuantity)) {
				return false;
			}
		}
		return true;
	}

	public void displayInventory() {
		System.out.println("=== Current Inventory ===");
		if (inventoryMap.isEmpty()) {
			System.out.println("Inventory is empty");
		} else {
			for (Map.Entry<IngredientType, Integer> entry : inventoryMap.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue() + " units");
			}
		}
	}
}
