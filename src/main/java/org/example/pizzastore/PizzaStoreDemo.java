package org.example.pizzastore;

public class PizzaStoreDemo {
	public static void main(String [] args) {
		PizzaStore nyPizzaStore = new NyPizzaStore();
		PizzaStore simplePizzaStore = new SimplePizzaStore();

		Pizza nyCheesePizza = nyPizzaStore.orderPizza("Cheese");
//		System.out.println(nyCheesePizza.getClass());

		Pizza simpleCheesePizza = simplePizzaStore.orderPizza("Paneer");
//		System.out.println(simplePaneerPizza.getClass());
	}
}
