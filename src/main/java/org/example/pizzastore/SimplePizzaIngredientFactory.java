package org.example.pizzastore;

import org.example.pizzastore.ingredients.Cheese;
import org.example.pizzastore.ingredients.Dough;
import org.example.pizzastore.ingredients.MozarrellaCheese;
import org.example.pizzastore.ingredients.Paneer;
import org.example.pizzastore.ingredients.Sauce;
import org.example.pizzastore.ingredients.ThickCrustDough;
import org.example.pizzastore.ingredients.TomatoSauce;
import org.example.pizzastore.ingredients.Topping;

public class SimplePizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		System.out.println("Creating thick crust dough");
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		System.out.println("Creating tomato sauce");
		return new TomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		System.out.println("Creating mozzarella cheese");
		return new MozarrellaCheese();
	}

	@Override
	public Topping[] createToppings() {
		System.out.println("Creating paneer topping");
		Topping [] toppings = new Topping[1];
		toppings[0] = new Paneer();
		return toppings;
	}
}
