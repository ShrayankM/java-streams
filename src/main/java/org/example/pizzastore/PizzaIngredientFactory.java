package org.example.pizzastore;

import org.example.pizzastore.ingredients.Cheese;
import org.example.pizzastore.ingredients.Dough;
import org.example.pizzastore.ingredients.Sauce;
import org.example.pizzastore.ingredients.Topping;

public interface PizzaIngredientFactory {
	Dough createDough();
	Sauce createSauce();
	Cheese createCheese();
	Topping [] createToppings();
}
