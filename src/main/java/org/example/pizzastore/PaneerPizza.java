package org.example.pizzastore;

public class PaneerPizza extends Pizza {
	private PizzaIngredientFactory pizzaIngredientFactory;
	public PaneerPizza(PizzaIngredientFactory pizzaIngredientFactory) {
		this.pizzaIngredientFactory = pizzaIngredientFactory;
	}

	@Override
	void prepare() {
		this.dough = this.pizzaIngredientFactory.createDough();
		this.sauce = this.pizzaIngredientFactory.createSauce();
		this.cheese = this.pizzaIngredientFactory.createCheese();
		this.toppings = this.pizzaIngredientFactory.createToppings();
	}
}
