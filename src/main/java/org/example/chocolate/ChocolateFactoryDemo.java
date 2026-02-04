package org.example.chocolate;

public class ChocolateFactoryDemo {
	public static void main(String [] args) {
		ChocolateBoiler chocolateBoiler = ChocolateBoiler.INSTANCE;

		chocolateBoiler.fill();
		System.out.println(chocolateBoiler.isEmpty());
		System.out.println(chocolateBoiler.isBoiled());

		chocolateBoiler.boil();
		System.out.println(chocolateBoiler.isBoiled());

		chocolateBoiler.drain();
		System.out.println(chocolateBoiler.isEmpty());
	}
}
