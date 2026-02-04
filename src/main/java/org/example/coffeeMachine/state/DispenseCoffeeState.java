package org.example.coffeeMachine.state;

import org.example.coffeeMachine.CoffeeMachine;
import org.example.coffeeMachine.entities.Coffee;
import org.example.coffeeMachine.entities.IngredientType;
import org.example.coffeeMachine.entities.Inventory;

import java.util.Map;

public class DispenseCoffeeState implements CoffeeMachineState {
	@Override
	public void selectCoffee(Coffee coffee, CoffeeMachine coffeeMachine) {
		System.out.println("Coffee is already selected, preparing to dispense");
	}

	@Override
	public void makePayment(int amount, CoffeeMachine coffeeMachine) {
		System.out.println("Payment completed, preparing to dispense");
	}

	@Override
	public Coffee dispenseCoffee(CoffeeMachine coffeeMachine) {
		Coffee coffee = coffeeMachine.getSelectedCoffee();
		Inventory inventory = coffeeMachine.getInventory();

		if (!inventory.checkInventoryQuantity(coffee.getRecipe())) {
			System.out.println("Insufficient ingredients present in the machine");
		}

		Map<IngredientType, Integer> recipe = coffee.getRecipe();

		for (Map.Entry<IngredientType, Integer> entry : recipe.entrySet()) {
			IngredientType ingredientType = entry.getKey();
			Integer requiredQuantity = entry.getValue();

			inventory.reduceInventory(ingredientType, requiredQuantity);
		}
		coffeeMachine.setCoffeeMachineState(new IdleState());
		coffeeMachine.setCoffeeMachineState(null);
		return coffee;
	}
}
