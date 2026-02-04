package org.example.coffeeMachine;

import org.example.coffeeMachine.entities.Coffee;
import org.example.coffeeMachine.entities.IngredientType;
import org.example.coffeeMachine.entities.Inventory;
import org.example.coffeeMachine.state.CoffeeMachineState;
import org.example.coffeeMachine.state.IdleState;

import java.util.Map;

public class CoffeeMachine {
	private static CoffeeMachine coffeeMachine;
	private CoffeeMachineState coffeeMachineState;
	private Inventory inventory;
	private Coffee selectedCoffee;

	private CoffeeMachine() {
		this.coffeeMachineState = new IdleState();
		this.inventory = new Inventory();
		this.selectedCoffee = null;
	};

	public static synchronized CoffeeMachine getInstance() {
		if (coffeeMachine == null) {
			coffeeMachine = new CoffeeMachine();
		}
		return coffeeMachine;
	}

	public void setSelectedCoffee(Coffee coffee) {
		this.selectedCoffee = coffee;
	}

	public void setCoffeeMachineState(CoffeeMachineState coffeeMachineState) {
		this.coffeeMachineState = coffeeMachineState;
	}

	public Coffee getSelectedCoffee() { return this.selectedCoffee; }

	public Inventory getInventory() { return this.inventory; }

	public void addInventory(Map<IngredientType, Integer> inventory) {
		for (Map.Entry<IngredientType, Integer> entry : inventory.entrySet()) {
			this.inventory.addInventory(entry.getKey(), entry.getValue());
		}
	}

	public void selectCoffee(Coffee coffee) {
		this.coffeeMachineState.selectCoffee(coffee, this);
	}

	public void makePayment(Integer amount) {
		this.coffeeMachineState.makePayment(amount, this);
	}

	public Coffee makeCoffee() {
		return this.coffeeMachineState.dispenseCoffee(this);
	}
}
