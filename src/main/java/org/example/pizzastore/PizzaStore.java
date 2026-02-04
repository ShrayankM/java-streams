package org.example.pizzastore;

public abstract class PizzaStore {
	abstract protected Pizza createPizza(String type);

	protected Pizza orderPizza(String type) {
		Pizza pizza = null;

		pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}
}
