package org.example.coffeeMachine.state;

import org.example.coffeeMachine.CoffeeMachine;
import org.example.coffeeMachine.entities.Coffee;
import org.example.coffeeMachine.entities.Inventory;

public class MakePaymentState implements CoffeeMachineState {
	@Override
	public void selectCoffee(Coffee coffee, CoffeeMachine coffeeMachine) {
		System.out.println("Coffee already selected, please make payment to proceed");
	}

	@Override
	public void makePayment(int amount, CoffeeMachine coffeeMachine) {
		Coffee coffee = coffeeMachine.getSelectedCoffee();

		Integer price = coffee.getPrice();
		if (amount < price) {
			System.out.println("Incorrect amount received, please enter correct change");
			return;
		}

		if (amount > price) {
			System.out.println("Returning change = " + (amount - price));
		}

		coffeeMachine.setCoffeeMachineState(new DispenseCoffeeState());

	}

	@Override
	public Coffee dispenseCoffee(CoffeeMachine coffeeMachine) {
		System.out.println("Please make payment to dispense coffee");
		return null;
	}
}
