package org.example.coffeeMachine.entities;

import java.util.Map;

public class CappuccinoCoffee extends Coffee {
	private final static Map<IngredientType, Integer> recipe = Map.of(
			IngredientType.WATER, 3,
			IngredientType.COFFEE, 5,
			IngredientType.MILK, 10
	);

	public CappuccinoCoffee() {
		this.coffeeType = CoffeeType.CAPPUCCINO;
		this.price = 25;
	}

	@Override
	public Map<IngredientType, Integer> getRecipe() {
		return recipe;
	}
}
