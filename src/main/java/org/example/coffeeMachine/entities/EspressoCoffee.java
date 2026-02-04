package org.example.coffeeMachine.entities;

import java.util.Map;

public class EspressoCoffee extends Coffee {
	private final static Map<IngredientType, Integer> recipe = Map.of(
			IngredientType.WATER, 2,
			IngredientType.COFFEE, 9,
			IngredientType.MILK, 3
	);

	public EspressoCoffee() {
		this.coffeeType = CoffeeType.ESPRESSO;
		this.price = 30;
	}

	@Override
	public Map<IngredientType, Integer> getRecipe() {
		return recipe;
	}
}
