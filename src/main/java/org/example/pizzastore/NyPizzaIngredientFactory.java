package org.example.pizzastore;

import org.example.pizzastore.ingredients.Cheese;
import org.example.pizzastore.ingredients.Dough;
import org.example.pizzastore.ingredients.MarianaSauce;
import org.example.pizzastore.ingredients.Olive;
import org.example.pizzastore.ingredients.ReggianoCheese;
import org.example.pizzastore.ingredients.Sauce;
import org.example.pizzastore.ingredients.ThinCrustDough;
import org.example.pizzastore.ingredients.Topping;

public class NyPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		System.out.println("Creating thin crust dough");
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		System.out.println("Creating mariana sauce");
		return new MarianaSauce();
	}

	@Override
	public Cheese createCheese() {
		System.out.println("Creating reggiano cheese");
		return new ReggianoCheese();
	}

	@Override
	public Topping[] createToppings() {
		System.out.println("Creating Olive topping");
		Topping [] toppings = new Topping[1];
		toppings[0] = new Olive();
		return toppings;
	}
}
