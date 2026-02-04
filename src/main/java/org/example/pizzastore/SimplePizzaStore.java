package org.example.pizzastore;

public class SimplePizzaStore extends PizzaStore {
	private PizzaIngredientFactory pizzaIngredientFactory;

	public SimplePizzaStore() {
		this.pizzaIngredientFactory = new SimplePizzaIngredientFactory();
	}

	@Override
	protected Pizza createPizza(String type) {
		if (type.equals("Cheese")) {
			return new CheesePizza(pizzaIngredientFactory);
		} else if (type.equals("Paneer")) {
			return new PaneerPizza(pizzaIngredientFactory);
		}

		return null;
	}
}
