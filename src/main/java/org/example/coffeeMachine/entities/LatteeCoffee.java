package org.example.coffeeMachine.entities;

import java.util.Map;

public class LatteeCoffee extends Coffee {
	private final static Map<IngredientType, Integer> recipe = Map.of(
			IngredientType.WATER, 1,
			IngredientType.COFFEE, 3,
			IngredientType.MILK, 5
	);

	public LatteeCoffee() {
		this.coffeeType = CoffeeType.LATTE;
		this.price = 20;
	}

	@Override
	public Map<IngredientType, Integer> getRecipe() {
		return recipe;
	}
}
