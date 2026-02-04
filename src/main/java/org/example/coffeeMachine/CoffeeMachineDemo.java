package org.example.coffeeMachine;

import org.example.coffeeMachine.entities.Coffee;
import org.example.coffeeMachine.entities.EspressoCoffee;
import org.example.coffeeMachine.entities.IngredientType;

import java.util.Map;

public class CoffeeMachineDemo {
	public static void main(String [] args) {
		CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

		coffeeMachine.addInventory(Map.of(
				IngredientType.WATER, 10,
				IngredientType.COFFEE, 20,
				IngredientType.MILK, 30
		));

		coffeeMachine.getInventory().displayInventory();

		coffeeMachine.selectCoffee(new EspressoCoffee());
		coffeeMachine.makePayment(10);
		Coffee dispensedCoffee = coffeeMachine.makeCoffee();

		dispensedCoffee.displayCoffee();

		coffeeMachine.getInventory().displayInventory();

	}
}
