package org.example.pizzastore;

public class NyPizzaStore extends PizzaStore {
	private final PizzaIngredientFactory pizzaIngredientFactory = new NyPizzaIngredientFactory();

	@Override
	public Pizza createPizza(String type) {
		if (type.equals("Cheese")) {
			return new CheesePizza(pizzaIngredientFactory);
		} else if (type.equals("Paneer")) {
			return new PaneerPizza(pizzaIngredientFactory);
		}

		return null;
	}
}
