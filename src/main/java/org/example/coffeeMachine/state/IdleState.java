package org.example.coffeeMachine.state;

import org.example.coffeeMachine.CoffeeMachine;
import org.example.coffeeMachine.entities.Coffee;
import org.example.coffeeMachine.entities.Inventory;

public class IdleState implements CoffeeMachineState {

	@Override
	public void selectCoffee(Coffee coffee, CoffeeMachine coffeeMachine) {
		// check inventory
		Inventory inventory = coffeeMachine.getInventory();
		if (!inventory.checkInventoryQuantity(coffee.getRecipe())) {
			System.out.println("Insufficient ingredients present in the machine");
			return;
		}

		coffeeMachine.setSelectedCoffee(coffee);
		coffeeMachine.setCoffeeMachineState(new MakePaymentState());
	}

	@Override
	public void makePayment(int amount, CoffeeMachine coffeeMachine) {
		System.out.println("Please select coffee before making payment");
	}

	@Override
	public Coffee dispenseCoffee(CoffeeMachine coffeeMachine) {
		System.out.println("Please select coffee first, cannot dispense coffee");
		return null;
	}
}
