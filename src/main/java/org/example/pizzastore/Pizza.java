package org.example.pizzastore;

import org.example.pizzastore.ingredients.Cheese;
import org.example.pizzastore.ingredients.Dough;
import org.example.pizzastore.ingredients.Sauce;
import org.example.pizzastore.ingredients.Topping;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Cheese cheese;
	Topping[] toppings;

	abstract void prepare();

	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}
	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}
	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}
}
