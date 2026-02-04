package org.example.coffeeMachine.entities;

import java.util.Map;

public abstract class Coffee {
	protected CoffeeType coffeeType;
	protected Integer price;
	abstract public Map<IngredientType, Integer> getRecipe();
	public Integer getPrice() { return price; }
	public void displayCoffee() {
		System.out.println("Coffee Type: " + this.coffeeType);
		System.out.println("Price: $" + this.price);
	}
}
