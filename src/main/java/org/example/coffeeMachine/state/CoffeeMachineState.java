package org.example.coffeeMachine.state;

import org.example.coffeeMachine.CoffeeMachine;
import org.example.coffeeMachine.entities.Coffee;

public interface CoffeeMachineState {
	void selectCoffee(Coffee coffee, CoffeeMachine coffeeMachine);
	void makePayment(int amount, CoffeeMachine coffeeMachine);
	Coffee dispenseCoffee(CoffeeMachine coffeeMachine);
}
