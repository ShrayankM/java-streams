package org.example.starbuzz;

import org.example.starbuzz.Beverage.Size;

public class StarbuzzCoffee {
	public static void main(String [] args) {
		Beverage espresso = new Espresso();
		System.out.println(espresso.getDescription() + ", Cost = [" + espresso.cost() + "]");

		Beverage darkRoastWithMochaAndWhip = new DarkRoast();
		darkRoastWithMochaAndWhip.setSize(Size.VENTI);

		darkRoastWithMochaAndWhip = new Whip(darkRoastWithMochaAndWhip);
		darkRoastWithMochaAndWhip = new Mocha(darkRoastWithMochaAndWhip);
		darkRoastWithMochaAndWhip = new Soy(darkRoastWithMochaAndWhip);


		System.out.println(darkRoastWithMochaAndWhip.getDescription() +
				", Cost = [" + darkRoastWithMochaAndWhip.cost() + "]");
	}
}
